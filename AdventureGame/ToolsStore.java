package AdventureGame;

public class ToolsStore extends NormalLocation {

    public ToolsStore(Player player) {
        super(2, player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("**** Welcome to the store ****");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weaponry");
            System.out.println("2 - Armors");
            System.out.println("0 - Log out");
            System.out.println();
            System.out.print("Which category would you like to choose? :");
            int selectCase = Location.scanner.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("You entered an invalid value. Re-enter value ");
                selectCase = scanner.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    showMenu = false;
                    break;
                case 2:
                    printArmor();
                    showMenu = false;
                    break;
                case 3:
                    System.out.println("We look forward to seeing you again");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Weapons selected");
                    printWeapon();
                    showMenu = false;
                    break;
            }
        }
        return true;

    }

    private void printWeapon() {
        System.out.println("**** Weapons ****");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " : "
                    + " Price: " + weapon.getPrice()
                    + " Damage: " + weapon.getDamage());
        }
        System.out.println("0 - Log out");
    }

    private void buyWeapon() {
        System.out.print("Choose a weapon: ");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.print("Invalid value. Re-enter: ");
            selectWeapon = scanner.nextInt();
        }

        if (selectWeapon != 0) {
            Weapon selectedWeaponId = Weapon.getWeaponById(selectWeapon);

            if (selectedWeaponId != null) {
                if (selectedWeaponId.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {

                    System.out.println(selectedWeaponId.getName() + " you bought");
                    int balance = this.getPlayer().getMoney() - selectedWeaponId.getPrice();
                    System.out.println("Your remaining money: " + balance);
                    System.out.println("Your previous weapon: "
                            + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeaponId);
                    System.out.println("Your new weapon: "
                            + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().setMoney(balance);
                }
            }
        }
    }

    private void printArmor() {
        System.out.println("**** Armors ****");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName()
                    + " Block: " + armor.getBlock()
                    + " Price: " + armor.getPrice());
        }
        System.out.println("0 - Log out");
        System.out.println();
        System.out.println(" Choose armor: ");
        int selectArmor = scanner.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.print("Invalid value. Re-enter:");
            selectArmor = scanner.nextInt();
        }
        Armor selectedArmor = Armor.getArmorById(selectArmor);

        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money!");
            } else {
                System.out.println(selectedArmor.getName() + " you bought");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                System.out.println("Your remaining money: " + balance);
                this.getPlayer().setMoney(balance);

            }
        }
    }
}
