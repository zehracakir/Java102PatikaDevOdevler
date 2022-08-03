package AdventureGame;

public class SafeHouse extends NormalLocation {

    public SafeHouse(Player player) {
        super(1, player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe house!");
        System.out.println("Your soul is renewed!");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
