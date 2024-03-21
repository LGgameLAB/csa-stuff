import java.util.*;



// Class for the player
public class Player {
    private ArrayList<Item> items;
    private final int LIMIT = 30; //Pounds
    /*
     * Constructs the player
     */
    public Player(){
        items = new ArrayList<Item>();
        items.add(Items.LADDER.clone());
    }
    /**
     * 
     * @return float of the weight of all the players items
     */
    public float getPackWeight(){
        float sum = 0;
        for (Item i: items){
            sum += i.getWeight();
        }
        return sum;
    }
    /**
     * 
     * @param item
     * @return boolean of whether the player can carry it or not
     */
    public boolean addItem(Item i){
        if ( (i.getWeight() + getPackWeight()) > LIMIT){
            return false;
        }
        items.add(i);
        return true;
    }
    /**
     * 
     * @param name
     * @return bool
     */
    public boolean hasItem(String name){
        for (Item i: items){
            if (i.getShortDescription().equals(name)){
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param name
     * @return the item dropped
     */
    public Item dropItem(String name){
        for (Item i: items){
            if (i.getShortDescription().equals(name)){
                deleteItem(i);
                return i;
            }
        }
        return new Item("null", "null");
    }
    /**
     * 
     * @param item - Item to delete from list in the room
     */
    public void deleteItem(Item item){
        items.remove(items.indexOf(item));
    }
    /**
     * 
     * @return list of the players items as a String
     */
    public String seeItemList(){
        String msg = "Your items:\n";
        for (Item i: items){
            msg += i.getShortDescription() + "\n";
        }
        msg += "Total weight: " + getPackWeight();
        return msg;
    }
    /**
     * 
     * @return
     */
    public ArrayList<Item> getItems(){
        return items;
    }
}