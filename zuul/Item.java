public class Item {

    private String name;
    private String use;
    private String description = "";
    private static final String COMMAND_FAILURE = "Critical command failure. Abort program";
    private float weight;

    /*
     * Several Different ways to initialize an item
     */
    /**
     * 
     * @param name
     * @param weight
     * @param description
     */
    public Item(String name, float weight, String description){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    /**
     * 
     * @param name
     * @param weight
     * @param description
     * @param use
     */
    public Item(String name, float weight, String description, String u){
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.use = u;
    }
    /**
     * 
     * @param name
     * @param description
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.weight = 2;
    }
    /**
     * 
     * @param name
     * @param description
     * @param use
     */
    public Item(String name, String description, String u){
        this.name = name;
        this.description = description;
        this.weight = 2;
        this.use = u;
    }
    /**
     * 
     * @return just the name of the item
     */
    public String getShortDescription(){
        return name;
    }
    /**
     *  
     * @return float of the item's weight
     */
    public float getWeight(){
        return weight;
    }
    /** 
     * @return a soft clone of the current item
    */
    public Item clone(){
        return new Item(name, weight, description, use);
    }
    public String getUse(Game game){
        if (use == null){
            return "This item is of no use here";
        } else {
            try {
                return (String) GameState.getState(use).invoke(null, game);
            } catch (Exception e) {
                return e.toString();
            }
        }
    }

}

// class Items {
//     public final Item ancientScroll1 = new Item("Ancient Scroll", 1, "Inside this dusty scroll is a text that reads: \n\nWe");
// }
