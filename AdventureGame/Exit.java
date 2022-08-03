package AdventureGame;

public class Exit extends NormalLocation {
    public Exit(Player player) {
        super(0, player, "Log out");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Checked Out");
        return true;
    }
}
