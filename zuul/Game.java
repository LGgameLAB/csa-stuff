import java.util.*;
/**
 *  "Zuul" is a very simple, text based adventure game.
 * 
 * @author  Luke Gonsalves
 * @version 2024.03.22
 */

public class Game 
{
    private Parser parser;
    private CommandWords commands;
    private ArrayList<Room> rooms;

    public Room currentRoom;
    public Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        commands = new CommandWords();
        parser = new Parser(commands);
        player = new Player();
    }
    /*
        Println Wrapper
    } */
    public void println(String p){
        System.out.println(p);
    }
    /**
       print wrapper 
    } */
    public void print(String p){
        System.out.print(p);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11;
      
        // create the rooms
        r1 = new Room(1, "in the visitor entrance bay");
        r2 = new Room(2, "in the east bay wing", 16, 3);
        r3 = new Room(3, "in the defense systems array");
        r3.setLore("Observing the defense logs, you read that the crew left at -98 hours and set security to low. Since then, the port has been visited twice, once by you and once more..");
        r3.addItem((Item) Items.SHIELD.clone());
        r4 = new Room(4, "in the utlity closet");
        r4.setLore("The items here have been scattered and several tools are missing");
        r4.addItem(Items.SCREWDRIVER.clone());
        r4.addItem(Items.LADDER.clone());
        r5 = new Room(5, "in the suit room");
        r5.setLore("Only one suit remains on the seven suit racks...");
        r6 = new Room(6, "in the filtration system");
        r6.setLore("This room is filled with pipes and man sized vents sending breathable air around "+Colors.RED+"Zuul"+Colors.RESET+" as well as waste chemicals");
        r7 = new Room(7, "in the debriefing room");
        r7.setLore("Swivel chairs are lined around a circular table, each facing a different direction There is a board on the wall that has a list of tasks with the most recent one being\n\033[3mAnswer distress call\033[0m");
        r8 = new Room(8, "in the radar arrays");
        r8.setLore("There is a small obround window on the far side of the room where you can see a large radar pointing out into space.");
        r9 = new Room(9, "in the "+Colors.RED+"CRITICAL ZONE"+Colors.RESET);
        r9.setLore("This room is dimly lit and "+Colors.RED+"warnings" + Colors.RESET + " along the eastern exit imply that it may be dangerous to venture to");
        r10 = new Room(10, "in the core analyzer");
        r10.setLore("There are several display screens in this room giving readings on the " +Colors.RED + "Zuul" + Colors.RESET + " core. \nIt appears that the core spin drive interface is active");
        r11 = new Room(11, "in the "+Colors.RED+"CORE"+Colors.RESET);

        // initialise room exits
        r1.setExit("east", r2);
        r1.setExit("north", r5);
        r1.setExit("west", r6);
        r2.setExit("west", r1);
        r2.setExit("east", r3);
        r3.setExit("west", r2);
        r3.setExit("north", r4);
        r4.setExit("south", r3);
        r5.setExit("south", r1);
        r5.setExit("west", r7);
        r6.setExit("east", r1);
        r7.setExit("east", r5);
        r7.setExit("west", r8);
        r8.setExit("east", r7);
        r8.setExit("north", r10);
        r9.setExit("west", r10);
        r9.setExit("east", r11);
        r10.setExit("east", r9);
        r10.setExit("south", r8);


        currentRoom = r1;  // start game outside
        rooms = new ArrayList<Room>(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11));
    }
    public Room getRoomById(int id){
        for (Room r: rooms){
            if (id == r.getId()){
                return r;
            }
        }
        return new Room(999, "This room is an error");
    }

    /**
     *  Main play routine.  Loops until end of play.
     * @throws NoSuchMethodException 
     * @throws ClassNotFoundException 
     */
    public void play()
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            GameState.checkEvent(this);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        println("\n\n\n\n\n\n\n\n\n");
        println("Welcome to . . . ."+Colors.RED+"\n███████╗██╗░░░██╗██╗░░░██╗██╗░░░░░\n╚════██║██║░░░██║██║░░░██║██║░░░░░\n░░███╔═╝██║░░░██║██║░░░██║██║░░░░░\n██╔══╝░░██║░░░██║██║░░░██║██║░░░░░\n███████╗╚██████╔╝╚██████╔╝███████╗\n╚══════╝░╚═════╝░░╚═════╝░╚══════╝");
        println(Colors.RESET+"Personal log, stardate 1357.8 \nI have arrived for routine maintenence at the" + Colors.RED + " \033[3mZuul\033[0m " + Colors.RESET + "base in the Cygnus system");
        println("After entering the primary docks, something appears amiss...the regular crew is nowhere to be found and all the service bots are inactive");
        println("I state this with the intent of finding this problem and fixing it. Will report back shortly");
        println(" -  \033[3mM.S.\033[0m ");
        println("");
        println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    // throws ClassNotFoundException, NoSuchMethodException
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            look(command);
        } 
        else if (commandWord.equals("jump")) {
            jump(command);
        }
        else if (commandWord.equals("items")) {
            seeItems(command);
        } 
        else if (commandWord.equals("drop")){
            drop(command);
        } 
        else if (commandWord.equals("whereami")){
            System.out.println(currentRoom.getLongDescription());
        }
        else if (commandWord.equals("use")){
            use(command);
        } 
        // else command not recognised.
        return wantToQuit;
    }
    /**
     * 
     * @return the current room
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public Parser getParser(){
        return parser;
    }
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        // System.out.println("You are lost. You are alone. You wander");
        // System.out.println("around at the university.");
        // System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    /**
     * 
     * @param command
     */
    public void use(Command command){
        if (player.getItems().size() == 0){
            println("You have no items to use, go find some...");
        } else {
            println("Choose an item to use with a number");
            int a = 0;
            for (Item b: player.getItems()){
                println("" + a + ": " + b.getShortDescription());
                a++;
            }
            try {
                int item = Integer.valueOf( parser.getInput() );
                println(player.getItems().get(item).getUse(this));
            }
            catch(Exception e) {
                println("that wasnt a valid number silly");
            }
        }

    }
    /**
     * 
     * @param command
     */
    private void seeItems(Command command){
        println(player.seeItemList());
    }
    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            String psg = GameState.checkPassage(this, nextRoom);
            if (psg.equals("good")){
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            } else {
                println(psg);
            }
            
        }
        
    }
    /**
     * Lets you investigate the room more closely
     * @param command
     */
    private void look(Command command){ 
        if (!currentRoom.getLore().isEmpty()){
            println(currentRoom.getLore());
        }
        ArrayList<Item> stuff = currentRoom.getItems();
        if (stuff.isEmpty()){
            println("There appears to be nothing of interest"); 
        } else {
            for (Item i: stuff){
                println("There is a " + i.getShortDescription());
                println("Would you like to pick it up?");
                if (parser.getYesNo()){
                    if (player.addItem(i)){
                        println("You added the " + i.getShortDescription() + " to your pack");
                        currentRoom.delete(i);
                    } else {
                        println("Your pack is too heavy to pick up this item. Try dropping something?");
                    }
                } else {
                    println("you ignored the " + i.getShortDescription());
                }
            }
            
        }

    }
    /**
     * Drops a specific item you are carrying
     * @param command
     */
    private void drop(Command command){
        if ( command.hasSecondWord() && player.hasItem(command.getSecondWord()) ){
            Item item = player.dropItem(command.getSecondWord());
            println("You dropped the " + item.getShortDescription() + " " + currentRoom.getShortDescription());
            currentRoom.addItem(item);
        }
    }
    /**
     * Rather Useless command but who knows. . . .
     * @param command
     */
    private void jump(Command command){
        println("You leap off the ground majestically only to return a moment later");
    }
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
