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
            if (randomNumber > 90 && randomNumber <= 100) eatLobster(octopus);
            if (octopus.getEnergy() == 0) octopus.setHealthPoints(lowHealthPoints(octopus, 20));
            if (octopus.getHealthPoint() == 0) {
                octopus.setIsAlive(false);
                printLastMessage();
            }
            System.out.println("Текущее состояние осьминога. Здоровье: " + octopus.getHealthPoint() + " и " + "энергия: " + octopus.getEnergy());
            try {
                //noinspection BusyWait
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void giveBirthOctopus() {
        String introduction = """
                Сегодня родилась маленькая особь осьминога!
                Это самка. Жизнь осьминога трудна, опасна.
                И составляет не более двух лет.
                """;
        System.out.println(introduction);
    }

    private static void eatFish(Octopus octopus) {
        octopus.setEnergy(upEnergy(octopus, 5));
        String message = "Осьминог поела рыбок! Силы восстановлены.";
        System.out.println(message);
    }

    private static void surroundOctopusBySparks(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 40));
        String message = "Вокруг плавают усатые кошачьи акулы. Чтобы выжить нужно спрятаться, ушло столько сил.";
        System.out.println(message);
        int randomNumber = createRandomNumber();
        if (randomNumber <= 50) {
            hidSuccessfully(octopus);
        } else hidUnsuccessfully(octopus);
    }

    private static void swim(Octopus octopus) {
        octopus.setEnergy(lowEnergy(octopus, 8));
        String message = "Какой отличный день, вокруг никаких опасностей, можно вдоволь поплавать!";
        System.out.println(message);
    }

    private static void sleep(Octopus octopus) {
        octopus.setEnergy(upEnergy(octopus, 10));
        octopus.setHealthPoints(upHealthPoints(octopus, 10));
        String message = "Удалось спокойно поспать и набраться сил.";
        System.out.println(message);
    }

    private static void hidSuccessfully(Octopus octopus) {
        octopus.setEnergy(upEnergy(octopus, 5));
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

    private static void attackOctopusByHuman(Octopus octopus) {
        octopus.setHealthPoints(lowHealthPoints(octopus, 25));
        octopus.setEnergy(lowEnergy(octopus, 10));
        String message = "О нет! Человек. Он не так страшен как акула, но в случае неудачи осьминога зажарят на гриле.";
        System.out.println(message);
    }

    private static void eatLobster(Octopus octopus) {
        octopus.setEnergy(upEnergy(octopus, 15));
        String message = "Повезло, на обед попался омар, что является большой редкостью!";
        System.out.println(message);
    }

    private static void growTentacles(Octopus octopus) {
        octopus.setHealthPoints(upHealthPoints(octopus, 5));
        octopus.setIsInjured(false);
        String message = "Начали отрастать новые щупальца!";
        System.out.println(message);
    }

    private static int lowEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() - energy;
        return newEnergy <= 0 ? 0 : newEnergy;
    }

    private static int upEnergy(Octopus octopus, int energy) {
        int newEnergy = octopus.getEnergy() + energy;
        return newEnergy > 100 ? 100 : newEnergy;
    }

    private static int lowHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() - points;
        return newHealthPoints <= 0 ? 0 : newHealthPoints;
    }

    private static int upHealthPoints(Octopus octopus, int points) {
        int newHealthPoints = octopus.getHealthPoint() + points;
        return newHealthPoints > 100 ? 100 : newHealthPoints;
    }

    private static int createRandomNumber() {
        return (int) (Math.random() * 100);
    }

    private static void printLastMessage() {
        String message = "Прожив свою короткую, но насыщенную жизнь осьминог умерла.";
        System.out.println(message);
    }
}