package AdventureGame;

import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    private boolean selectCombatValue = false;
    public static Scanner scanner = new Scanner(System.in);

    public Location(int id, Player player, String name) {
        this.id = id;
        this.player = player;
        this.name = name;
    }

    abstract boolean onLocation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelectCombatValue() {
        return selectCombatValue;
    }

    public void setSelectCombatValue(boolean selectCombatValue) {
        this.selectCombatValue = selectCombatValue;
    }
}
