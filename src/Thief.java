import bagel.util.Point;
import bagel.util.Vector2;

import java.util.ArrayList;

public class Thief extends MovableActor {
    public static final String TYPE = "Thief";

    private boolean carrying = false;
    private boolean consuming = false;

    public static final ArrayList<Thief> LIST = new ArrayList<>();



    public Thief(Point position) {
        super(position, "res/images/thief.png", Vector2.up);
        LIST.add(this);
    }

    public void move() {
        if(this.isActive()) {
            this.changePosition(this.getDirection());
            // return;   return here to avoid further actions
        }

        Actor temp;
        if(this.isOn(Fence.TYPE) != null) {
            this.setActive(false);
            this.changePosition(this.getDirection().mul(-1));
        }

        if(this.isOn(Pool.TYPE) != null) {
            Point currentP = this.getPosition();
            Vector2 currentD = this.getDirection();

            Thief first = new Thief(currentP);
            first.toDirection(currentD);
            first.changeDirection(CLOCKWISE_90);
            first.move();

            this.changeDirection(-1 * CLOCKWISE_90);
            this.move();
            // initialise the current thief
            this.carrying = false;
            this.consuming = false;
        }

        if((temp = this.isOn(Sign.TYPE)) != null) {
            this.toDirection(((Sign) temp).getDirection());
        }

        if(this.isOn(Pad.TYPE) != null) {
            consuming = true;
        }

        if(this.isOn(Gatherer.TYPE) != null) {
            this.changeDirection(-1 * CLOCKWISE_90);
        }

        if((temp = this.isOn(Tree.TYPE)) != null) {
            if(!carrying) {
                Tree tree = (Tree) temp;
                if(tree.anyFruit()) {
                    tree.changeFruitNum(-1);
                    carrying = true;
                }
            }
        }

        if(this.isOn(GoldenTree.TYPE) != null) {
            carrying = true;
        }

        if((temp = this.isOn(Hoard.TYPE)) != null) {
            Hoard hoard = (Hoard) temp;
            if(consuming) {
                consuming = false;
                if(!carrying) {
                    if(hoard.anyFruit()) {
                        carrying = true;
                        hoard.changeFruitNum(-1);
                    }else {
                        this.changeDirection(CLOCKWISE_90);
                    }
                }
            }else if(carrying) {
                carrying = false;
                hoard.changeFruitNum(1);
                this.changeDirection(CLOCKWISE_90);
            }
        }

        if((temp = this.isOn(Stockpile.TYPE)) != null) {
            Stockpile stockpile = (Stockpile) temp;
            if(!carrying) {
                if(stockpile.anyFruit()) {
                    carrying = true;
                    consuming = false;
                    stockpile.changeFruitNum(-1);
                    this.changeDirection(CLOCKWISE_90);
                }
            }else {
                this.changeDirection(CLOCKWISE_90);
            }
        }
    }

    public static void moveAll() {
        int size = LIST.size();
        for(int i = 0;i<size;i++) {
            LIST.get(i).move();
        }
    }
}
