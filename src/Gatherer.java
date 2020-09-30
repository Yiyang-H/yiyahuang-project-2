import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;
import java.util.ArrayList;

public class Gatherer extends DirectionActor {
    // Instance variable for Gatherer
    private boolean carrying = false;
    private boolean active = true;

    private static final ArrayList<Gatherer> GATHERERS = new ArrayList<>();

    public Gatherer(Point position){
        super(position, new Image("res/images/gatherer.png"), Vector2.left);
        GATHERERS.add(this);
    }

    public void move() {
        if(active) {
            this.changePosition(this.getDirection().mul(ShadowLife.TILE_SIZE));
        }
        // Loop through all actors to see if this gatherer is on them
        for(Actor a : ShadowLife.ACTORS) {
            if(a.getPosition().equals(this.getPosition())) {
                if(a instanceof Fence) {
                    active = false;
                    this.changePosition(this.getDirection().mul(-1 * ShadowLife.TILE_SIZE));
                }

                if(a instanceof MitosisPool) {
                    // Need to implement
                }

                if(a instanceof Sign) {
                    this.toDirection(((Sign) a).getDirection());
                }

                if(a instanceof Tree) {
                    if(!carrying) {
                        if(((Tree) a).anyFruit()) {
                            ((Tree) a).changeFruitNum(-1);
                            carrying = true;
                            this.changeDirection(180);
                        }
                    }
                }

                if(a instanceof Hoard || a instanceof Stockpile) {
                    if(carrying) {
                        carrying = false;
                        ((StockActor) a).changeFruitNum(1);
                    }
                    this.changeDirection(180);
                }

            }
        }
    }

    public static void moveAll() {
        for(Gatherer g : GATHERERS) {
            g.move();
        }
    }
}
