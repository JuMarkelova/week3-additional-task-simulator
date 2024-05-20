package cy.markelova.simulator.entity;

public class Octopus {

    private int healthPoints = 100; // когда = 0, то умирает
    private int energy = 100; // когда = 0, то тратится здоровье
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
