package Arena_LLD;


import model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Arena {
    List<Player> players;

    public Arena(List<Player> players) {
        this.players = players;
    }

    public void fight(String player1Name, String player2Name) {
        Player player1=null;
        Player player2=null;
        int attackIntensity;
        int defendIntensity;
        int resultantDamage;
        Random random = new Random();
        int counter = 1;

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(player1Name)) {
                player1 = player;
            }
            if (player.getName().equalsIgnoreCase(player2Name)) {
                player2 = player;
            }
        }

        if (player1 == null || player2 == null) {
            System.out.println("One/Both players are invalid");
            return;
        }

        Deque<Player> pq = new LinkedList<>();
        pq.add(player1);
        pq.add(player2);

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            Player attacker = pq.poll();
            Player defender = pq.peek();

            attackIntensity = random.nextInt(1, 7);
            defendIntensity = random.nextInt(1, 7);

            assert defender != null;
            assert attacker != null;
            resultantDamage = attacker.getAttack() * attackIntensity - defender.getStrength() * defendIntensity;
            if (resultantDamage > 0) {
                defender.setHealth(defender.getHealth() - resultantDamage);
            }
            System.out.println("After " + counter++ + " round");
            System.out.println(attacker.getName() + " attack intensity: " + attackIntensity + " health: " + attacker.getHealth());
            System.out.println(defender.getName() + " defense intensity: " + defendIntensity + " health: " + defender.getHealth());

            if (defender.getHealth() <= 0) {
                System.out.println(attacker.getName() + " wins the battle");
                return;
            }
            pq.add(attacker);
        }
    }
}
