package Homework03_01;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    ArrayList<T> box = new ArrayList<>();

    public Box(T... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float currentWeight = 0.0f;
        for (int i = 0; i <box.size(); i++) {
            currentWeight += box.get(i).getWeight();
        }
        return currentWeight;
    }

    public boolean compare (Box<? extends Fruit> fullBox) {

        return Math.abs(getWeight()-fullBox.getWeight()) < 0.0001f;
    }

    public void replaceFruits (Box<T> replace) {
        replace.box.addAll(this.box);
        box.clear();

    }


}
