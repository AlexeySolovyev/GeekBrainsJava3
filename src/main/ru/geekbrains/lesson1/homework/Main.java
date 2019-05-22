package ru.geekbrains.lesson1.homework;

import java.util.ArrayList;
import java.util.List;


    public class Main {

        public static void main(String[] args) {
            List<String> arrlist;
            String [] strArr = {"asdas","DASFD","GFJHJ"};
            changeElements(0,1,strArr);
            arrlist = ArrayToList(strArr);
            System.out.println(arrlist);

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
