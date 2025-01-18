package grywojenne;

public class SoldierFactory {
    // Implementacja wzorca fabryki (Factory Pattern)
    public static Soldier createSoldier(Rank rank) {
        return new Soldier(rank);
    }
}

