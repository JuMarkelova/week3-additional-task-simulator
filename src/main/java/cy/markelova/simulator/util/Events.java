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
                Чтобы остаться в живых нужно спрятаться, это отнимает много энергии."
                """;
        System.out.println(message);
    }

    public static int lowEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() - energy;
        if (newEnergy < 0) {
            return 0;
        } else return newEnergy;
    }

    public static int highEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() + energy;
        if (newEnergy > 100) {
            return 100;
        } else return newEnergy;
    }
}