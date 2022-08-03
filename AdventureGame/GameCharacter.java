package AdventureGame;

public abstract class GameCharacter {
    public String characterName;
    public int ID;
    public int damage;
    public int health;
    public int money;

    public GameCharacter(String characterName, int ID, int damage, int health, int money) {
        this.characterName = characterName;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
