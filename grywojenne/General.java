package grywojenne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class General implements Serializable {
    // Kompozycja: General zawiera listę obiektów Soldier oraz obiekt Secretary
    private int gold;
    private List<Soldier> army = new ArrayList<>();
    private transient Secretary secretary;

    public General(int gold) {
        this.gold = gold;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    // Implementacja algorytmu manewrów
    public void doManeuvers(List<Soldier> group) {
        int cost = 0;
        for (Soldier s : group) {
            cost += s.getRank().getValue();
        }
        if (cost <= gold) {
            gold -= cost;
            for (Soldier s : group) {
                s.increaseExperience();
            }
        }
        if (secretary != null) {
            secretary.logAction("General performed maneuvers on " + group.size() + " soldiers.");
        }
    }

    // Implementacja algorytmu ataku
    public void attack(General opponent) {
        int myStrength = getTotalStrength();
        int opponentStrength = opponent.getTotalStrength();
        if (myStrength > opponentStrength) {
            resolveVictory(this, opponent);
        } else if (myStrength < opponentStrength) {
            resolveVictory(opponent, this);
        } else {
            // Remis
            shootRandomSoldier(this);
            shootRandomSoldier(opponent);
        }
        if (secretary != null) {
            secretary.logAction("Attacked general with strength " + opponent.getTotalStrength());
        }
    }

    private void resolveVictory(General winner, General loser) {
        int transfer = (int)(loser.gold * 0.1);
        loser.gold -= transfer;
        winner.gold += transfer;
        for (Soldier s : loser.army) {
            s.decreaseExperience();
        }
        for (Soldier s : winner.army) {
            s.increaseExperience();
        }
    }

    private void shootRandomSoldier(General g) {
        if (!g.army.isEmpty()) {
            Soldier randomSoldier = g.army.get(new Random().nextInt(g.army.size()));
            randomSoldier.decreaseExperience();
            if (!randomSoldier.isAlive()) {
                g.army.remove(randomSoldier);
            }
        }
    }

    // Implementacja algorytmu zakupu żołnierzy
    public void buySoldier(Rank rank) {
        int cost = 10 * rank.getValue();
        if (gold >= cost) {
            gold -= cost;
            Soldier s = SoldierFactory.createSoldier(rank);
            army.add(s);
            if (secretary != null) {
                secretary.logAction("Bought a " + rank + " soldier.");
            }
        }
    }

    public void save(String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(this);
        }
    }

    public static General load(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (General) ois.readObject();
        }
    }

    public int getTotalStrength() {
        return army.stream().filter(Soldier::isAlive).mapToInt(Soldier::getStrength).sum();
    }

    public int getGold() {
        return gold;
    }

    public List<Soldier> getArmy() {
        return army;
    }
}