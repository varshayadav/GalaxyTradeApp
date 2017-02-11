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

    public float calculateCredits(float quantity) throws Exception {
        return cost * quantity;
    }
}
