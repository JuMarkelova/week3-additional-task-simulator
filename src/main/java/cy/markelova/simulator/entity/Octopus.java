package cy.markelova.simulator.entity;

public class Octopus {

    private int healthPoints = 100; // it dies when healthPoints is 0
    private int energy = 100; // when energy drops to 0, healthPoints decreases
    private boolean isInjured = false;
    private boolean isAlive = true;

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

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsInjured(boolean isInjured) {
        this.isInjured = isInjured;
    }

    public boolean getIsInjured() {
        return this.isInjured;
    }
}