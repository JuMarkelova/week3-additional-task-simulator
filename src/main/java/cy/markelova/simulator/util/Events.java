package cy.markelova.simulator.util;

import cy.markelova.simulator.entity.Octopus;

public class Events {

    private static void birthOfOctopus() {
        String introduction = """
                Сегодня родилась маленькая особь осьминога!
                Это самка. Жизнь осьминога трудна, опасна.
                И состовляет не более двух лет.
                """;
        System.out.println(introduction);
    }

    private static void eatingFish(Octopus octopus) {
        octopus.setEnergy(highEnergy(octopus, 5));
        String message = "Осьминог поела рыбок! Силы восстановлены.";
        System.out.println(message);
    }

    private static void swim(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 8));
        String message = """
                Какой отличный день, вокруг никаких опасностей, можно вдоволь поплавать!""";
        System.out.println(message);
    }

    private static void sleep(Octopus octopus) {
        octopus.setEnergy(highEnergy(octopus, 10));
        octopus.setHealthPoints(highHealthPoints(octopus, 10));
        String message = "Удалось спокойно поспать и набраться сил.";
        System.out.println(message);
    }

    private static void thereAreOctopusEnemyAround(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 40));
        String message = "Вокруг плавают усатые кошачьи акулы. Чтобы выжить нужно спрятаться, ушло столько сил.";
        System.out.println(message);
        int randomNumber = createRandomNumber();
        if (randomNumber <= 50) {
            hidSuccessfully(octopus);
        } else hidUnsuccessfully(octopus);
    }

    private static void hidSuccessfully(Octopus octopus) {
        octopus.setEnergy(highEnergy(octopus, 5));
        String message = "Осьминогу удалось укрыться. Она чувствует облегчение.";
        System.out.println(message);
    }

    private static void hidUnsuccessfully(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 10));
        octopus.setHealthPoints(lowHealthPoints(octopus, 25));
        octopus.setIsInjured(true);
        String message = "К сожалению, осьминогу не удалось спрятаться. Акула нашла ее и откусила щупальце.";
        System.out.println(message);
    }

    private static void attackedByHuman(Octopus octopus) {
        octopus.setHealthPoints(lowHealthPoints(octopus, 25));
        octopus.setEnergy(lowEnergy(octopus, 10));
        String message = "О нет! Человек. Он не так страшен как акула, но в случае неудачи осьминога зажарят на гриле.";
        System.out.println(message);
    }

    private static void eatLobster(Octopus octopus) {
        octopus.setEnergy(highEnergy(octopus, 15));
        String message = "Повезло, попался омар, что является большой редкостью!";
        System.out.println(message);
    }

    private static void growTentacles(Octopus octopus) {
        octopus.setHealthPoints(highHealthPoints(octopus, 5));
        octopus.setIsInjured(false);
        String message = "Начали отрастать новые щупальца!";
        System.out.println(message);
    }

    private static int lowEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() - energy;
        if (newEnergy <= 0) {
            return 0;
        } else return newEnergy;
    }

    private static int highEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() + energy;
        if (newEnergy > 100) {
            return 100;
        } else return newEnergy;
    }

    private static int lowHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() - points;
        if (newHealthPoints <= 0) {
            return 0;
        } else return newHealthPoints;
    }

    private static int highHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() + points;
        if (newHealthPoints > 100) {
            return 100;
        } else return newHealthPoints;
    }

    private static void hasEnergy(Octopus octopus) {
        if (octopus.getEnergy() == 0) {
            octopus.setHealthPoints(lowHealthPoints(octopus, 20));
        }
    }

    private static void isAlive(Octopus octopus) {
        if (octopus.getHealthPoint() == 0) {
            octopus.setIsAlive(false);
            dieOctopus();
        }
    }

    private static int createRandomNumber() {
        return (int) (Math.random() * 100);
    }

    private static void dieOctopus() {
        String message = """
                Прожив свою короткую, но насыщенную жизнь осьминог умерла.""";
        System.out.println(message);
    }

    public static void runLife(Octopus octopus) {
        birthOfOctopus();
        while (octopus.getIsAlive()) {
            int randomNumber = createRandomNumber();
            if (randomNumber <= 15) eatingFish(octopus);
            if (randomNumber <= 50) thereAreOctopusEnemyAround(octopus);
            if (randomNumber <= 58) swim(octopus);
            if (randomNumber <= 69) sleep(octopus);
            if (randomNumber <= 80 && octopus.getIsInjured()) growTentacles(octopus);
            if (randomNumber <= 90) attackedByHuman(octopus);
            if (randomNumber <= 100) eatLobster(octopus);
            hasEnergy(octopus);
            isAlive(octopus);
            System.out.println("Текущее состояние осьминога. Здоровье: " + octopus.getHealthPoint() + " и " + "энергия: " + octopus.getEnergy());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}