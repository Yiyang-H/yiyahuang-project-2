import bagel.util.Point;
import java.util.ArrayList;
/**
 * The Stockpile element in the game.
 */
public class Stockpile extends StockActor {
    /**
     * The type of this element.
     */
    public static final String TYPE = "Stockpile";
    /**
     * This list stores all Stockpile elements in the game.
     */
    public static final ArrayList<Stockpile> LIST = new ArrayList<>();

    /**
     * The constructor of the Stockpile class.
     * @param position The position of the Stockpile.
     */
    public Stockpile(Point position) {
        super(position, "res/images/cherries.png",0);
        LIST.add(this);
    }
}
