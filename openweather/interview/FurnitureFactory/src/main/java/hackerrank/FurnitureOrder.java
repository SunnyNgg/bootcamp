package hackerrank;

import java.util.HashMap;


public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> funitures; 

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        funitures = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        int count = 0; 
        if(funitures.constainKey(type)){
            count = funitures.get(type);
        }
        funitures.put(type, count + furnitureCount);

    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method 
        return new HashMap<Furniture, Integer>(funitures);

    }

    public float getTotalOrderCost() {
        // TODO: Complete the method        
        if(!furnitures.isEmpty()) {
        	return furnitures.entrySet().stream()
            .map(f -> f.getKey().cost() * f.getValue())
            .collect(Collectors.toList())
            .stream()
            .reduce(Float::sum)
            .get();
}
return 0.0f;
    }
   

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if (funitures.constainKey(type) ){
            return funitures.get(type);
        }
        return 0 ;
    }
    

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        if (funitures.constainKey(type)){
            return funitures.get(type) * funitures.cost();
        }
        return 0.0f;
    }
    

    public int getTotalOrderQuantity() {
        if(!funitures.isEmpty()){
            return funitures.value.stream()
            .reduce(Integer :: sum)
            .get();
                            
        }
        
        // TODO: Complete the method
        return 0;
    }
}
   