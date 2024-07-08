package cy.markelova.simulator.util;

import cy.markelova.simulator.entity.Octopus;

@SuppressWarnings("ManualMinMaxCalculation")
public class Events {

    public static void runLife(Octopus octopus) {
        giveBirthOctopus();
        while (octopus.getIsAlive()) {
            int randomNumber = createRandomNumber();
            if (randomNumber > 0 && randomNumber <= 15) eatFish(octopus);
            if (randomNumber > 15 && randomNumber <= 50) surroundOctopusBySparks(octopus);
            if (randomNumber > 50 && randomNumber <= 58) swim(octopus);
            if (randomNumber > 58 && randomNumber <= 69) sleep(octopus);
            if (randomNumber > 69 && randomNumber <= 80 && octopus.getIsInjured()) growTentacles(octopus);
            if (randomNumber > 80 && randomNumber <= 90) attackOctopusByHuman(octopus);
            if (randomNumber > 90 && randomNumber < 100) eatLobster(octopus);
            if (octopus.getEnergy() == 0) octopus.setHealthPoints(decreaseHealthPoints(octopus, 20));
            if (octopus.getHealthPoint() == 0) {
                octopus.setIsAlive(false);
                printLastMessage();
            }
            System.out.println("Current state of the octopus. Health: " + octopus.getHealthPoint() + " and " + "energy: " + octopus.getEnergy());
            try {
                //noinspection BusyWait
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void giveBirthOctopus() {
        System.out.println("""
                A baby octopus was born today.
                It's a female. The life of an octopus is difficult and dangerous.
                And it lasts no more than two years.
                """);
    }

    private static void eatFish(Octopus octopus) {
        octopus.setEnergy(increaseEnergy(octopus, 5));
        System.out.println("The octopus ate some fish! Her energy is restored.");
    }

    private static void surroundOctopusBySparks(Octopus octopus) {
        octopus.setEnergy(decreaseEnergy(octopus, 40));
        System.out.println("Cat sharks are swimming around. To survive, she needs to hide, which took so much energy.");
        int randomNumber = createRandomNumber();
        if (randomNumber <= 50) {
            hidSuccessfully(octopus);
        } else hidUnsuccessfully(octopus);
    }

    private static void swim(Octopus octopus) {
        octopus.setEnergy(decreaseEnergy(octopus, 8));
        System.out.println("What a great day, there are no dangers around, she can swim freely.");
    }

    private static void sleep(Octopus octopus) {
        octopus.setEnergy(increaseEnergy(octopus, 10));
        octopus.setHealthPoints(increaseHealthPoints(octopus, 10));
        System.out.println("She was able to sleep well and recharge.");
    }

    private static void hidSuccessfully(Octopus octopus) {
        octopus.setEnergy(increaseEnergy(octopus, 5));
        System.out.println("The octopus successfully hid. She feels relieved.");
    }

    private static void hidUnsuccessfully(Octopus octopus) {
        octopus.setEnergy(decreaseEnergy(octopus, 10));
        octopus.setHealthPoints(decreaseHealthPoints(octopus, 25));
        octopus.setIsInjured(true);
        System.out.println("The octopus couldn't hide. The shark found her and bit off one of her tentacles.");
    }

    private static void attackOctopusByHuman(Octopus octopus) {
        octopus.setHealthPoints(decreaseHealthPoints(octopus, 25));
        octopus.setEnergy(decreaseEnergy(octopus, 10));
        System.out.println("No! A human. If the octopus fails, she'll end up grilled.");
    }

    private static void eatLobster(Octopus octopus) {
        octopus.setEnergy(increaseEnergy(octopus, 15));
        System.out.println("Good fortune! She caught a lobster for lunch, which is a rare find!");
    }

    private static void growTentacles(Octopus octopus) {
        octopus.setHealthPoints(increaseHealthPoints(octopus, 5));
        octopus.setIsInjured(false);
        System.out.println("New tentacles began to grow");
    }

    private static int decreaseEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() - energy;
        return newEnergy <= 0 ? 0 : newEnergy;
    }

    private static int increaseEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() + energy;
        return newEnergy > 100 ? 100 : newEnergy;
    }

    private static int decreaseHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() - points;
        return newHealthPoints <= 0 ? 0 : newHealthPoints;
    }

    private static int increaseHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() + points;
        return newHealthPoints > 100 ? 100 : newHealthPoints;
    }

    private static int createRandomNumber() {
        return (int) (Math.random() * 100);
    }

    private static void printLastMessage() {
        System.out.println("After living her short but eventful life, the octopus passed away.");
    }
}