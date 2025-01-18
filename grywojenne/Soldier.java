
package grywojenne;

public class Soldier {
    private Rank rank;
    private int experience;

    public Soldier(Rank rank) {
        this.rank = rank;
        this.experience = 1;
    }

    public int getStrength() {
        return rank.getValue() * experience;
    }

    public void increaseExperience() {
        experience++;
        if (experience >= 5 * rank.getValue()) {
            promote();
        }
    }

    public void decreaseExperience() {
        experience--;
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
        experience = 1;
    }

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