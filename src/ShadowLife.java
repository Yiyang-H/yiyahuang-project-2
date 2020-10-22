import bagel.*;
import bagel.util.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class ShadowLife extends AbstractGame {
    public static final int TILE_SIZE = 64;
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int NUM_OF_ARGUMENTS = 3;
    private static final int NUM_OF_ENTRIES = 3;
    private static final int CONST_TWO = 2;
    private static final String[] KEY_ARRAY = {Tree.TYPE,GoldenTree.TYPE,Stockpile.TYPE,
            Hoard.TYPE,Pad.TYPE,Fence.TYPE,Sign.TYPE,Pool.TYPE,Gatherer.TYPE,Thief.TYPE};

    private static int tickRate;
    private static int maxTicks;
    private static String filename;

    private final Image background = new Image("res/images/background.png");
    // Keep track of the order in the world file
    private final ArrayList<StockActor> orderOfStockpileAndHoard = new ArrayList<>();

    // Count number of ticks
    private int counter;
    private long referenceTime = System.currentTimeMillis();

    boolean paused = false;

    public ShadowLife() {
        super(WIDTH,HEIGHT,"ShadowLife");
        loadActors();
    }

    public static void main(String[] args) {
        // Checks if the input arguments are valid
        boolean validArguments = true;
        if(args.length != NUM_OF_ARGUMENTS) {
            validArguments = false;
        }else {
            try {
                // Using parseUnsignedInt to test if the number is non-negative
                tickRate = Integer.parseUnsignedInt(args[0]);
                maxTicks = Integer.parseUnsignedInt(args[1]);
            } catch (NumberFormatException e) {
                validArguments = false;
            } catch (Exception e) {
                System.out.println("Other Exceptions caught!");
                System.exit(-1);
            }
        }
        if(!validArguments){
            System.out.println("usage: ShadowLife <tick rate> <max ticks> <world file>");
            System.exit(-1);
        }

        filename = args[CONST_TWO];
        ShadowLife game = new ShadowLife();
        game.run();
    }

    @Override
    public void update(Input input) {
        background.drawFromTopLeft(0,0);
        // Press space to pause the simulation
        if(input.wasPressed(Keys.SPACE)) {
            paused = paused ? false : true;
        }

        // Check if 1 tick has passed
        if(System.currentTimeMillis()-referenceTime >= tickRate && !paused) {
            // System.out.println("Tick: "+counter);
            referenceTime = System.currentTimeMillis();
            counter++;
            MovableActor.moveAll();
        }

        // Draw all actors using keys to ensure ordering of actors
        for(String key : KEY_ARRAY) {
            try {
                ArrayList<? extends Actor> actorList =
                        (ArrayList<? extends Actor>) Class.forName(key).getDeclaredField(Actor.LIST_NAME).get(null);
                for(Actor a : actorList) {
                    a.draw();
                }
            } catch(Exception e) {

            }
        }

        if(MovableActor.allInactive()) {
            System.out.println(counter + " ticks");
            for(StockActor s : orderOfStockpileAndHoard) {
                System.out.println(s.getFruitNum());
            }
            System.exit(-1);
        }

        if(counter > maxTicks) {
            System.out.println("Timed out");
            System.exit(-1);
        }

        if(input.isDown(Keys.ESCAPE)) {
            Window.close();
        }
    }

    private static boolean isValidColumn(String[] column) {
        if(column.length != NUM_OF_ENTRIES) {
            return false;
        }
        try {
            Integer.parseInt(column[1]);
            Integer.parseInt(column[CONST_TWO]);
        } catch(NumberFormatException e) {
            return false;
        } catch(Exception e) {
            System.out.println("General Exception found in isValidColumn!");
            System.out.println(e.getMessage());
        }

        String type = column[0];
        boolean isValid = false;
        if(type.contains(Sign.TYPE)) {
            String direction = type.substring(Sign.TYPE.length());
            if(direction.equals(Sign.UP) || direction.equals(Sign.RIGHT) ||
            direction.equals(Sign.DOWN) || direction.equals(Sign.LEFT)) {
                isValid = true;
            }
        }else {
            for(String s : KEY_ARRAY) {
                if(s.equals(type)) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;

    }

    private void loadActors() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Scanner scanner = new Scanner(br);
            int i = 1;
            while(scanner.hasNext()) {
                // Split the csv by ","
                String[] columns = scanner.nextLine().split(",");
                // Check if each column is well-formatted
                if(!isValidColumn(columns)) {
                    System.out.println("error: in file \"" + filename + "\" at line " + i);
                    System.exit(-1);
                }
                String type = columns[0];
                int x = Integer.parseInt(columns[1]);
                int y = Integer.parseInt(columns[2]);
                Point p = new Point(x,y);
                switch(type) {
                    case Tree.TYPE:
                        new Tree(p);
                        break;
                    case GoldenTree.TYPE:
                        new GoldenTree(p);
                        break;
                    case Stockpile.TYPE:
                        orderOfStockpileAndHoard.add(new Stockpile(p));
                        break;
                    case Hoard.TYPE:
                        orderOfStockpileAndHoard.add(new Hoard(p));
                        break;
                    case Pad.TYPE:
                        new Pad(p);
                        break;
                    case Fence.TYPE:
                        new Fence(p);
                        break;
                    case Pool.TYPE:
                        new Pool(p);
                        break;
                    case Gatherer.TYPE:
                        new Gatherer(p);
                        break;
                    case Thief.TYPE:
                        new Thief(p);
                        break;
                    default:
                        break;
                }
                if(type.contains(Sign.TYPE)) {
                    new Sign(p, type.substring(4));
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("error: file \"" + filename + "\" not found");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("General Exception found in loadActors!");
            System.out.println(e.getMessage());
        }
    }
}
