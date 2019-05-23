package ru.geekbrains.lesson1.homework;

import ru.geekbrains.lesson1.homework.fruits.Apple;
import ru.geekbrains.lesson1.homework.fruits.Orange;

import java.util.ArrayList;
import java.util.List;


    public class Main {

        public static void main(String[] args) {
            List<String> arrlist;
            String [] strArr = {"asdas","DASFD","GFJHJ"};
            changeElements(0,1,strArr);
            arrlist = ArrayToList(strArr);
            System.out.println(arrlist);



            Box<Orange> orangeBox1 = new Box<>();
            Box<Orange> orangeBox2 = new Box<>();
            Box<Apple> appleBox1 = new Box<>();
            Box<Apple> appleBox2 = new Box<>();

            orangeBox1.addFruit(new Orange());
            orangeBox1.addFruit(new Orange());

            orangeBox2.addFruit(new Orange());

            appleBox1.addFruit(new Apple());
            appleBox1.addFruit(new Apple());
            appleBox1.addFruit(new Apple());

            System.out.println(appleBox1.compare(orangeBox1));

            appleBox2.moveFruits(appleBox1);

            System.out.println(appleBox2.getFruitsList());

        }
        public static <T> T printType(T val) {
            System.out.println(val.getClass().getName());
            return val;
        }
        private  static <T> T[] changeElements(int ind1, int ind2,T[] arr){
            T tmp;
            tmp = arr[ind1];
            arr[ind1] = arr[ind2];
            arr[ind2] = tmp;
            return arr;
        }

        private static <T> List<T> ArrayToList(T[] arr ) {
            List<T> arrList = new <T>ArrayList();
            for (T elem : arr) {
                arrList.add(elem);
            }
            return arrList;
        }

    

}
