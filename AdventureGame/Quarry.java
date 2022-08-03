package AdventureGame;

public class Quarry extends BattleLoc {
    private Obstacle obstacle;

    public Quarry(Player player0) {
        super(6, player0, "Coal", Quarry.getobstacle(), "Spoils of war", 2);
    }

    public static Obstacle getobstacle() {
        return new Snake();
    }
}
