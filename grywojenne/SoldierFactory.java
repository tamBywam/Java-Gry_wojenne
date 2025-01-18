package grywojenne;

public class SoldierFactory {
    public static Soldier createSoldier(Rank rank) {
        // Could add logic for different soldier types
        return new Soldier(rank);
    }
}

