package grywojenne;

public class Main {
    public static void main(String[] args) {
        Secretary s = new Secretary();
        General g1 = new General(100);
        General g2 = new General(100);
        g1.setSecretary(s);
        g2.setSecretary(s);

        g1.buySoldier(Rank.PRIVATE);
        g2.buySoldier(Rank.CAPTAIN);
        g1.doManeuvers(g1.getArmy());
        g2.doManeuvers(g2.getArmy());

        g1.attack(g2);
    }
}
