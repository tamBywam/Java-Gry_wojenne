package grywojenne;

public class Soldier extends Person implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Rank rank;
    private int experience;

    public Soldier(Rank rank) {
        this.rank = rank;
        this.experience = 1;
    }

    @Override
    public int getStrength() {
        return rank.getValue() * experience;
    }

    public void increaseExperience() {
        experience++;
        if (experience >= 5 * rank.getValue()) {
            promote();
            return;
        }
    }

    public void decreaseExperience() {
        experience--;
        if (experience <= 0) {
            experience = 0;
        }
    }

    private void promote() {
        switch (rank) {
            case PRIVATE:
                rank = Rank.CORPORAL;
                break;
            case CORPORAL:
                rank = Rank.CAPTAIN;
                break;
            case CAPTAIN:
                rank = Rank.MAJOR;
                break;
            default:
                break;
        }
        experience = 0;
    }

    @Override
    public boolean isAlive() {
        return experience > 0;
    }

    public Rank getRank() {
        return rank;
    }

    public int getExperience() {
        return experience;
    }
}