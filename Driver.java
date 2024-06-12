
import Arena_LLD.Arena;
import model.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of players in arena");
        int playersCount = sc.nextInt();

        List<Player> players = new ArrayList<>(playersCount);

        for (int i = 1; i <= playersCount; i++) {
            System.out.println("Enter player " +i+ " name");
            String playerName = sc.next();
            System.out.println("Enter player attack");
            int playerAttack = sc.nextInt();
            System.out.println("Enter player strength");
            int playerStrength = sc.nextInt();
            System.out.println("Enter player health");
            int playerHealth = sc.nextInt();

            players.add(new Player(playerName, playerAttack, playerStrength, playerHealth));
        }

        Arena arena = new Arena(players);

        System.out.println("Enter player 1 name to fight");
        String player1Name = sc.next();
        System.out.println("Enter player 2 name to fight");
        String player2Name = sc.next();

        arena.fight(player1Name,player2Name);


    }
}
