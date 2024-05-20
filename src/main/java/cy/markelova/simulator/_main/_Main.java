package cy.markelova.simulator._main;

import cy.markelova.simulator.entity.Octopus;
import cy.markelova.simulator.util.Events;

public class _Main {

    public static void main(String[] args) {
        Octopus octopus = new Octopus();
        Events.birthOfOctopus();
        Events.eatingFish(octopus);
        Events.thereAreOctopusEnemyAround(octopus);

        System.out.println(octopus.getHealthPoint() + " " + octopus.getEnergy());
    }
}