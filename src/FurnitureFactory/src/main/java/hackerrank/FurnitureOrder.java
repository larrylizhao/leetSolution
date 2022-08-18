package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {

    private final HashMap<Furniture, Integer> order;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        order = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        int count = this.getTypeCount(type);
        order.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<Furniture, Integer>(order);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float cost = 0.0f;
        for(Map.Entry<Furniture, Integer> entry : order.entrySet()) {
            cost += this.getTypeCost(entry.getKey());
        }
        return cost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return order.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        return this.getTypeCount(type) * type.cost();
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int total = 0;
        for(int count : order.values()) {
            total += count;
        }
        return 0;
    }

    public static void main(String[] args) {
        FurnitureOrder furnitureOrder = new FurnitureOrder();
        furnitureOrder.addToOrder(Furniture.TABLE, 6);
        furnitureOrder.getTotalOrderCost();
    }
}