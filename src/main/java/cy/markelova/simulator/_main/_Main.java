package cy.markelova.simulator._main;

import cy.markelova.simulator.entity.Octopus;

import static cy.markelova.simulator.util.Events.runLife;

public class _Main {

    public static void main(String[] args) {
        Octopus octopus = new Octopus();
        runLife(octopus);
    }
}