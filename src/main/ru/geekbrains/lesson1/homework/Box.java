package ru.geekbrains.lesson1.homework;

import ru.geekbrains.lesson1.homework.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private List <T>fruitsList  = new ArrayList<>();

    public void addFruit (T fruit){
        fruitsList.add(fruit);
    };

    public List<T> getFruitsList() {
        return this.fruitsList;
    }

    public float getWeight() {
        float weight = 0;
        for (Fruit fruit : fruitsList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void moveFruits(Box<T> box) {
        this.fruitsList.addAll(box.fruitsList);
        box.fruitsList.clear();
    }

    public boolean compare(Box<? extends Fruit> fruitBox) {
        return Math.abs(this.getWeight() - fruitBox.getWeight()) < 0.001;
    }

}
