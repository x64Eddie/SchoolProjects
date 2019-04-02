package Fishes;
import Fishes.*;

/**
 * Represents a type of fish
 */
class Nemo extends Fish{

    private int x, y;

    Nemo(){
        this(50,50);
    }

    Nemo(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        
    }

    @Override
    public void update(FishMovement movement) {

    }

}