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
        if(active) {
            this.changePosition(this.getDirection().mul(ShadowLife.TILE_SIZE));
        }

        // Loop through all actors to see if this thief is on them
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

                if(a instanceof Pad) {
                    consuming = true;
                }

                if(a instanceof Gatherer) {
                    this.changeDirection(270);
                }

                if(a instanceof Tree) {
                    if(!carrying) {
                        if(((Tree) a).anyFruit()) {
                            ((Tree) a).changeFruitNum(-1);
                            this.carrying = true;
                        }
                    }
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
                        this.changeDirection(90);
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

            }
        }
    }

    public static void moveAll() {
        for(Thief t : THIEVES) {
            t.move();
        }
    }
}
