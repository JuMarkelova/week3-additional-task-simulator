package cy.markelova.simulator.entity;

public class Octopus {

    private int healthPoints = 100; // когда = 0, то умирает
    private int energy = 100; // когда = 0, то тратится здоровье

    public int getHealthPoint() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
