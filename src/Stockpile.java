import bagel.util.Point;
import java.util.ArrayList;

public class Stockpile extends StockActor {
    public static final String TYPE = "Stockpile";
    public static final ArrayList<Stockpile> LIST = new ArrayList<>();

    public Stockpile(Point position) {
        super(position, "res/images/cherries.png",0);
        LIST.add(this);
    }
}
