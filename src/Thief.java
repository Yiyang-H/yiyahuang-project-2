import bagel.*;
import bagel.util.Point;
import bagel.util.Vector2;

import java.util.ArrayList;

public class Thief extends DirectionActor {
    private boolean carrying = false;
    private boolean consuming = false;
    private boolean active = true;

    private static final ArrayList<Thief> THIEVES = new ArrayList<>();



    public Thief(Point position) {
        super(position, new Image("res/images/thief.png"), Vector2.up);
        THIEVES.add(this);
    }

    public void move() {
        // Loop through all actors to see if gatherer is on them
        for(Actor a : ShadowLife.ACTORS) {
            if(a.getPosition().equals(this.getPosition())) {
                if(a instanceof MitosisPool) {
                    // Need to implement
                }
                if(a instanceof Sign) {
                    this.toDirection(((Sign) a).getDirection());
                }
                if(a instanceof Pad) {
                    // Need to implement
                }
                if(a instanceof Gatherer) {
                    // Need to implement
                }
                if(a instanceof Hoard) {
                    if(consuming) {
                        consuming = false;
                        if(!carrying) {
                            if(((Hoard) a).anyFruit()) {
                                carrying = true;
                                ((Hoard) a).changeFruitNum(-1);
                            }else {
                                this.changeDirection(90);
                            }
                        }
                    }else if(carrying) {
                        carrying = false;
                        ((Hoard) a).changeFruitNum(1);
                    }
                }
                if(a instanceof Stockpile) {
                    if(!carrying) {
                        if(((Stockpile) a).anyFruit()) {
                            carrying = true;
                            consuming = false;
                            ((Stockpile) a).changeFruitNum(-1);
                            this.changeDirection(90);
                        }
                    }else {
                        this.changeDirection(90);
                    }
                }
                if(a instanceof Fence) {
                    active = false;
                    this.changeDirection(180);
                    this.changePosition(this.getDirection());
                }
            }
        }
        if(active) {
            this.changePosition(this.getDirection());
        }
    }

    public static void moveAll() {
        for(Thief t : THIEVES) {
            t.move();
        }
    }
}
