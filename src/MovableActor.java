import bagel.util.Point;
import bagel.util.Vector2;
import java.util.ArrayList;

/**
 * This abstract class describes actors which can change their position
 * during the process of the game.
 */
public abstract class MovableActor extends DirectionActor {
    private boolean active = true;

    /**
     * The constructor of the MovableActor class.
     * @param position The position of the actor.
     * @param imageFile The image file of the actor.
     * @param direction The direction of the actor.
     */
    public MovableActor(Point position, String imageFile, Vector2 direction) {
        super(position,imageFile,direction);
    }

    /**
     * The getter for the active attribute.
     * @return The active state of the actor.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter for the active attribute.
     * @param active The new active state.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * The move method describe how the MovableActor move at each tick.
     */
    public abstract void move();

    /**
     * A method to check if this MovableActor is on the type of actor specified
     * by the className parameter.
     * @param className The type of actor to check if on.
     * @return Return the intended typed actor this MovableActor is on if any.
     */
    // Check if this movable is on some type of actor
    // Return the instance of that actor if there is any
    public Actor isOn(String className) {
        try {
            ArrayList<? extends Actor> actorList =
                    (ArrayList<? extends Actor>) Class.forName(className).getDeclaredField(LIST_NAME).get(null);
            for(Actor a : actorList) {
                if(a.getPosition().equals(this.getPosition())) {
                    return a;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Check if all MovableActors are inactive.
     * @return Return true if all MovableActors are inactive, else false.
     */
    public static boolean allInactive() {
        for(Gatherer g : Gatherer.LIST) {
            if(g.isActive()) {
                return false;
            }
        }
        for(Thief t : Thief.LIST) {
            if(t.isActive()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Move all MovableActors.
     */
    public static void moveAll() {
        Gatherer.moveAll();
        Thief.moveAll();
    }
}
