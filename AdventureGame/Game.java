package AdventureGame;

import java.util.Scanner;

public class Game {
    public Player player;
    public Location location;

    Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the adventure!");
        System.out.println("Please enter a name:");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + " welcome to the dark and foggy island.");
        System.out.println("Please select a character:");
        player.selectChar();
        player.selectLocation();

    }

}
