package GalactialUtilities;

public class Utility {
    private final String name;
    private final float cost;

    public Utility(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public float calculateCredits(float quantity) {
        return cost * quantity;
    }

    public String getName() {
        return name;
    }
}
