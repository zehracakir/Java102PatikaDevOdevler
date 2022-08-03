package AdventureGame;

import java.nio.file.LinkPermission;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private Inventory inventory;
    private Location location = null;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameCharacter[] characters = { new Samurai(), new Archer(), new Knight() };
        for (GameCharacter character : characters) {
            System.out.println("ID: " + character.getID()
                    + "\t Character: " + character.getCharacterName()
                    + "\t Damage: " + character.getDamage()
                    + "\t Health: " + character.getHealth()
                    + "\t Money: " + character.getMoney());
        }

        System.out.print("Which character would you like to play with:");
        int selectedChar = scanner.nextInt();
        switch (selectedChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println("Character: " + this.getCharName() + " Damage: " + this.getDamage()
                + " Health: " + this.getHealth() + " Money: " + this.getMoney());
    }

    private void initPlayer(GameCharacter character) {
        this.setCharName(character.getCharacterName());
        this.setDamage(character.getDamage() + this.getDamage());
        this.setHealth(character.getHealth());
        this.setOrijinalHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    public void selectLocation() {
        while (true) {
            System.out.println();
            System.out.println("**************************************************************");
            System.out.println("Now choose a region! ");
            Location[] locations = { new SafeHouse(this), new ToolsStore(this),
                    new Cave(this), new Forest(this),
                    new River(this), new Quarry(this), new Exit(this) };
            for (Location locationn : locations) {
                System.out.println(locationn.getId() + ". region: " + locationn.getName());
            }
            System.out.print("Please choose: ");
            int noLoc = scanner.nextInt();

            switch (noLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolsStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new Forest(this);
                    break;
                case 5:
                    location = new River(this);
                    break;
                case 6:
                    Quarry quarry = new Quarry(this);
                    location = quarry;
                    break;
                default:
                    System.out.println("Not valid region! Going to the safe zone!");
                    location = new SafeHouse(this);
                    break;
            }
            if (location == null) {
                System.out.println("Exiting the game...");
                break;
            } else if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }

    public void isDelete(int choose) {
        if (location.isSelectCombatValue()) {
            System.out.println("All creatures in this area are dead, please choose another area!");

        }
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int gender) {
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public Armor getArmor() {
        return this.getInventory().getArmor();
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

    public void awardForQarry(int possib) {
        Weapon[] weapons = {

                Weapon.getWeaponById(3),
                Weapon.getWeaponById(3),
                Weapon.getWeaponById(2),
                Weapon.getWeaponById(2),
                Weapon.getWeaponById(2),
                Weapon.getWeaponById(1),
                Weapon.getWeaponById(1),
                Weapon.getWeaponById(1),
                Weapon.getWeaponById(1),
                Weapon.getWeaponById(1)
        };
        Armor[] armors = {
                Armor.getArmorById(3),
                Armor.getArmorById(3),
                Armor.getArmorById(2),
                Armor.getArmorById(2),
                Armor.getArmorById(2),
                Armor.getArmorById(1),
                Armor.getArmorById(1),
                Armor.getArmorById(1),
                Armor.getArmorById(1),
                Armor.getArmorById(1)
        };

        int money[] = { 1, 1, 1, 1, 1, 5, 5, 5, 10, 10 };

        Random random = new Random();
        int possRn = possib;
        int percent;
        if (possRn < 3) {
            percent = random.nextInt(10);
            Weapon weapon = weapons[percent];
            System.out.println("Congratulations! You have won a weapon.");
            System.out.println("Your previous weapon: " + this.getWeapon().getName());
            this.getInventory().setWeapon(weapon);
            System.out.println("Your new weapon: " + this.getWeapon().getName());

        } else if (2 < possRn || possRn < 6) {
            percent = random.nextInt(10);
            Armor armor = armors[percent];
            System.out.println("Congratulations! You have gained armor.");
            System.out.println("Your previous weapon:" + this.getArmor().getName());
            this.getInventory().setArmor(armor);
            System.out.println("Your new weapon: " + this.getArmor().getName());
        } else if (5 < possRn || possRn < 11) {
            percent = random.nextInt(10);
            int gain = money[percent];
            System.out.println("Congratulations! You won gold.");
            System.out.println("Your previous money:" + this.getMoney() + " gold");
            this.setMoney(this.getMoney() + gain);
            System.out.println("Your new money: " + getMoney() + " gold");
        } else {
            System.out.println("Unfortunately you didn't win anything!");
        }
    }
}
