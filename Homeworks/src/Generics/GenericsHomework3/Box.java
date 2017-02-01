package Generics.GenericsHomework3;

import java.util.ArrayList;


/**
 * Created by Anton on 26.01.2017.
 */
public class Box<T extends Fruit> {
    T fruitObject;
    int piecesInBox;
    float weightOfFruit;

    ArrayList<T> fruitStorage = new ArrayList<T>();

    public Box(T obj, int piecesInBox, float weightOfFruit) {
        this.fruitObject = obj;
        this.piecesInBox = piecesInBox;
        this.weightOfFruit = weightOfFruit;
        for (int i = 0; i < piecesInBox; i++) {
            fruitStorage.add(fruitObject);
        }
    }

    public float getWeight() {
        return fruitStorage.size() * weightOfFruit;
    }

    public boolean compare(Box otherBox) {
        if (otherBox.getWeight() == this.getWeight()) {return true;}
        return false;
    }

    public void moveFruitsToOtherBox (int quantityOfFruitsToMove, Box<T> inWhichBoxToMove) {
        if (quantityOfFruitsToMove > piecesInBox) {
            System.out.println("Wrong quantity of transferred fruits!");
            System.exit(0);
        } else {
            for (int i = 0; i < quantityOfFruitsToMove; i++) {
                inWhichBoxToMove.fruitStorage.add(fruitObject);
            }
            for (int i = quantityOfFruitsToMove; i > 0; i--) {
                fruitStorage.remove(fruitStorage.size() - 1);
            }
        }
    }

    public void addFruitToBox(int quantityOfFruitsToAdd) {
        if (quantityOfFruitsToAdd <= 0) {
            System.out.println("Wrong quantity entered");
            System.exit(0);
        } else {
            for (int i = 0; i < quantityOfFruitsToAdd; i++) {
                fruitStorage.add(fruitObject);
            }
         }
    }
}
