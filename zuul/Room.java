import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private String lore = "";
    private HashMap<String, Room> exits;        // stores exits of this room.
    private String[][] roomTemplate = {{"╔", "═", "╗"},
                                      {"║", " ", "║"},
                                      {"╚", "═", "╝"}};
    private String[][] roomDiagram = {{"╔", "═════════", "╗"},
                                      {"║", "         ", "║"},
                                      {"║", "         ", "║"},
                                      {"║", "         ", "║"},
                                      {"╚", "═════════", "╝"}};
    private ArrayList<Item> items = new ArrayList<Item>();
    private int id, width, height;
    private Random rand = new Random();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        generateDiagram();
        exits = new HashMap<>();
        id = rand.nextInt(900)+100;
    }
    public Room(int id, String description) 
    {
        this.description = description;
        generateDiagram();
        exits = new HashMap<>();
        this.id = id;
    }
    /**
     * 
     * @param description
     * @param w
     * @param h
     */
    public Room(String description, int w, int h) 
    {
        this.description = description;
        this.width = w;
        this.height = h;
        generateDiagram();
        exits = new HashMap<>();
    }
    public void generateDiagram(){
        if (width == 0){
            width = rand.nextInt(4)*2 + 6;
            height = rand.nextInt(3)*2 + 4;
        }
        
        roomDiagram = new String[height][width];
        roomDiagram[0][0] = roomTemplate[0][0];
        roomDiagram[0][width-1] = roomTemplate[0][2];
        roomDiagram[height-1][0] = roomTemplate[2][0];
        roomDiagram[height-1][width-1] = roomTemplate[2][2];
        for (int i = 1; i < width-1; i++){
            roomDiagram[0][i] = roomTemplate[0][1];
            roomDiagram[height-1][i] = roomTemplate[2][1];
        }
        for (int i = 1; i < height-1; i++){
            roomDiagram[i][0] = roomTemplate[1][0];
            roomDiagram[i][width-1] = roomTemplate[1][2];
        }

    }
    /**
     * 
     * @param inp
     */
    public void setLore(String inp){
        lore = inp;
    }
    /**
     * 
     * @return lore of the room if there is lore
     */
    public String getLore(){
        return lore;
    }
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
        Set<String> keys = exits.keySet();
        // for(String exit : keys) {
        if (direction.equals("east")){
            roomDiagram[rand.nextInt(height-2)+1][width-1] = " ";
        }
        else if (direction.equals("north")){
            int r = rand.nextInt(width-3);
            roomDiagram[0][r+1] = " ";
            roomDiagram[0][r+2] = " ";
        }
        else if (direction.equals("south")){
            int r = rand.nextInt(width-3);
            roomDiagram[height-1][r+1] = " ";
            roomDiagram[height-1][r+2] = " ";
        }
        else if (direction.equals("west")){
            roomDiagram[rand.nextInt(height-2)+1][0] = " ";
        }
        // }

    }
    /**
     * 
     * @return List of items in the room
     */
    public ArrayList<Item> getItems(){
        return (ArrayList<Item>)items.clone();
    }
    /*
     * Adds an item to class
     * @param
     */
    public void addItem(Item itm){
        items.add(itm);
        // roomDiagram[1][1] = roomDiagram[1][1].substring(0, 6) + "$";
    }
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String room = Colors.YELLOW;
        room += drawRoom();
        return "You are " + description + ".\n" + room + Colors.WHITE + getExitString();
    }
    /**
     * 
     * @return the drawing of the room
     */
    public String drawRoom(){
        String out = "";
        for (String[] r : roomDiagram){
            for (String c : r){
                if (c == null){
                    out += " ";
                } else {
                    out += c;
                }
                
            }
            out += "\n";
        }
        return out;
    }
    /**
     * 
     * @param item - Item to delete from list in the room
     */
    public void delete(Item item){
        items.remove(items.indexOf(item));
        // roomDiagram[1][1] = roomDiagram[1][1].substring(0, 2) + " ";
    }
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    /**
     * @return int for the room's ID
     */
    public int getId(){
        return id;
    }
}

