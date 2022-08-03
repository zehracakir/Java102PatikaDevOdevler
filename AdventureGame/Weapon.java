package AdventureGame;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon() {
    }

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weapons = {
                new Weapon(1, "Gun", 2, 15),
                new Weapon(2, "Sword", 3, 35),
                new Weapon(3, "Rifle", 7, 45)
        };
        return weapons;
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
