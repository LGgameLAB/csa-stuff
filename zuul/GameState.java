import java.lang.reflect.Method;

public class GameState {
    public static Method getState(String name) throws NoSuchMethodException {
        Class[] arguments = new Class[1];
        arguments[0] = Game.class;
        return GameState.class.getDeclaredMethod(name, arguments);
    }
    /**
     * @param G=game object to use the shield on
     */
    public static void useShield(Game game){
        game.println("You summon the powerful forcefield");
    }
    /**
     * @param game object to use the ladder on
     */
    public static String useLadder(Game game){
        if (game.currentRoom.getId() == 6){
            game.currentRoom = game.getRoomById(9);
            System.out.println(game.currentRoom.getLongDescription());
            return "You used the ladder to climb through an empty pipe";
        }
        return "No use for the ladder here";
    }
    /**
     * 
     * @param game
     * @param nextRoom
     * @return String 
     */
    public static String checkPassage(Game game, Room nextRoom){
        if (nextRoom.getId() == 11){
            if (game.player.hasItem("temp-shield")){
                return "Your temp shield keeps you safe against high levels of radiation as you make your way towards...";
            } else {
                game.println("You die to radiation bombardment . . . " + Colors.RED + "GAME OVER");
                System.exit(0);
            }
        }
        return "good";
    } 
    /**
     * 
     * @param game
     */
    public static void checkEvent(Game game){
        if (game.currentRoom.getId() == 8 && game.player.hasItem("screw-driver")){
            game.println("Would you like to use your screwdriver to fix the radar system?");
            if (game.getParser().getYesNo()){
                game.println("The radar is fixed. On screen you can see what looks to be debris of a space ship heading 200 m/s away from " +Colors.RED + "Zuul" + Colors.RESET);
            }
        }
    }
}
