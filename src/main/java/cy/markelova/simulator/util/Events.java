package cy.markelova.simulator.util;

import cy.markelova.simulator.entity.Octopus;

public class Events {

    public static void birthOfOctopus() {
        String introduction = """
                Сегодня родилась маленькая особь осьминога!
                Это самка. Жизнь осьминога трудна, опасна и коротка.
                Она продолжается не более двух лет.
                """;
        System.out.println(introduction);
    }

    public static void eatingFish(Octopus octopus) {
        octopus.setEnergy(highEnergy(octopus, 10));
        String message = "Осьминог поела рыбок! Силы восстановлены.";
        System.out.println(message);
    }

    public static void thereAreOctopusEnemyAround(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 40));
        String message = """
                Осторожно! Вокруг плавают усатые кошачьи акулы.
                Чтобы остаться в живых нужно спрятаться, это отнимает много энергии.
                """;
        System.out.println(message);
    }

    public static int lowEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() - energy;
        if (newEnergy <= 0) {
            return 0;
        } else return newEnergy;
    }

    public static int highEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() + energy;
        if (newEnergy > 100) {
            return 100;
        } else return newEnergy;
    }

    public static int lowHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() - points;
        if (newHealthPoints <= 0) {
            return 0;
        } else return newHealthPoints;
    }

    public static void hasEnergy(Octopus octopus) {
        if (octopus.getEnergy() == 0) {
            octopus.setHealthPoints(lowHealthPoints(octopus, 20));
        }
    }

    public static boolean isAlive(Octopus octopus) {
        if (octopus.getHealthPoint() == 0) {
            octopus.setIsAlive(false);
            return false;
        } else return true;
    }

    public static int createRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public static void runLife(Octopus octopus) {
        birthOfOctopus();
        while (octopus.getIsAlive()) {
            int randomNumber = createRandomNumber();
            if (randomNumber <= 50) {
                eatingFish(octopus);
            } else if (randomNumber <= 100) {
                thereAreOctopusEnemyAround(octopus);
            }
            hasEnergy(octopus);
            System.out.println("до проверки энергии " + octopus.getHealthPoint() + " " + octopus.getEnergy());
            isAlive(octopus);
            System.out.println("до проверки жизни " + octopus.getHealthPoint() + " " + octopus.getEnergy());
        }
    }
}