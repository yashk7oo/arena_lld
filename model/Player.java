package model;

public class Player {
    private final String name;
    private int attack;
    private final int strength;
    private int health;

    public Player(String name, int attack, int strength, int health) {
        this.name = name;
        this.attack = attack;
        this.strength = strength;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}


