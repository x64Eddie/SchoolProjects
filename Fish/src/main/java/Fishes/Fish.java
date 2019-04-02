package Fishes;
import javax.annotation.Nonnull;

/**
 * Represents all the fish that are going to be swimming in the water.
 */
abstract class Fish{
    abstract void draw();
    abstract void update(@Nonnull FishMovement movement);
}
/**
 * Represents the movements that the fish is going to perform.
 */
enum FishMovement{
    LEFT, RIGHT
}