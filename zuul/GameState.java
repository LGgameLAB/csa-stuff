import java.lang.reflect.Method;

public class GameState {
    public static Method getState(String name) throws NoSuchMethodException {
        Class[] arguments = new Class[1];
        arguments[0] = Game.class;
        return GameState.class.getDeclaredMethod(name, arguments);
    }
    /**
     * @param Game object to use the shield on
     */

    public static void useShield(Game game){
        game.println("You summon the powerful forcefield");
    }
    /**
     * @param Game object to use the ladder on
     */

    public static void useLadder(Game game){
        if (game.currentRoom.getId() == 6){
            game.currentRoom = game.getRoomById(9);
            System.out.println(game.currentRoom.getLongDescription());
        }
    }
    public static String checkPassage(Game game){
        return "good";
    } 
}
