package AdventureGame;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(3, player, "Cave", new Zombie(), "Food", 3);
    }
}
