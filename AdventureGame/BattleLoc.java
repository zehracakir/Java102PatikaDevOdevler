package AdventureGame;

import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String selectCombat;
    private boolean selectCombatValue;

    public BattleLoc(int id, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(id, player, name);
        this.award = award;
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        System.out.println("You are here now : " + this.getName());
        System.out.println("Be careful! Here " + this.getMaxObstacle() + " piece"
                + this.getObstacle().getName() + " lives");
        boolean continueEx = true;
        while (continueEx) {
            System.out.println("<W>ar or <R>un");
            String selectCase = Location.scanner.nextLine();
            selectCase = selectCase.toUpperCase();
            if (selectCase.equals("W")) {
                if (combat(getMaxObstacle())) {
                    break;
                } else {
                    System.out.println("You are dead!");
                    return false;
                }
            } else if (selectCase.equals("R")) {
                continueEx = false;
            }
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());

            obstacleStatus(i);
            playerStats();

            while (this.getPlayer().getHealth() > 0
                    && this.getObstacle().getHealth() > 0) {
                int priotiry = random.nextInt(2);
                System.out.println("<H>it or <R>un");
                String selectCombat = scanner.nextLine().toUpperCase();

                if (selectCombat.equals("H")) {
                    if (priotiry == 0) {
                        System.out.println("You hit it!" + " priority: " + (priotiry));
                        this.getObstacle().setHealth(this.getObstacle().getHealth()
                                - this.getPlayer().getTotalDamage());
                        afterHit(i);
                    } else {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println(this.getObstacle().getName() + " hit you" + " öncelik: " + (priotiry));
                            int obstacleDamage = this.getObstacle().getDamage()
                                    - this.getPlayer().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());
                            afterHit(i);
                        }
                    }
                    this.setSelectCombatValue(true);
                } else if (selectCombat.equals("R")) {
                    afterHit(i);
                    this.setSelectCombatValue(false);

                    return true;
                }
            }

        }

        if (this.getPlayer().getHealth() > this.getObstacle().getHealth()) {
            System.out.println("You have defeated the enemy!");
            if (this.getObstacle().getName().equals("Snake")) {
                Player player = this.getPlayer();
                player.awardForQarry(this.getObstacle().getAward());

                this.setSelectCombatValue(true);
                return true;
            } else {
                int totalGain = this.getObstacle().getAward() * getMaxObstacle();
                System.out.println(totalGain + " You won the gold award");
                System.out.println("Your previous money: " + this.getPlayer().getMoney());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + totalGain);
                System.out.println("Your current money : " + this.getPlayer().getMoney());
                System.out.println(this.getName() + " You have defeated all the enemies in the area!");
                System.out.println("This area has now been cleared. ");
                System.out.println("isSelected value: " + isSelectCombatValue());

                this.setSelectCombatValue(true);
                return true;
            }
        } else {

            return false;
        }
    }

    private void afterHit(int i) {
        System.out.println("Your soul: " + this.getPlayer().getHealth());
        System.out.println(i + ". " + this.obstacle.getName() + " soul: "
                + this.obstacle.getHealth());
        System.out.println();
    }

    private void obstacleStatus(int i) {
        System.out.println("***************");
        System.out.println(i + ". " + this.getObstacle().getName() + " Values: ");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Prize: " + this.getObstacle().getAward());
    }

    private void playerStats() {
        System.out.println("--> Player values: ");

        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getArmor().getName());
        System.out.println("***************");

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public String getSelectCombat() {
        return selectCombat;
    }

    public void setSelectCombat(String selectCombat) {
        this.selectCombat = selectCombat;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public boolean isSelectCombatValue() {
        return selectCombatValue;
    }

    @Override
    public void setSelectCombatValue(boolean selectCombatValue) {
        this.selectCombatValue = selectCombatValue;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
