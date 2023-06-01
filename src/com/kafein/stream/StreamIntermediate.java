package com.kafein.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamIntermediate {
    public static void main(String[] args) {
        //filterExample();
        //MapExample();
//        ArrayList<Book> bookArrayList =new ArrayList<>();
//        setBook(bookArrayList);
//        List<Integer> bookArrayList1 = bookArrayList.stream().map(e->e.id*2).collect(Collectors.toList());

       // int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();


    }


    static class Book{
        String name;
        int id;

        public Book(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void setBook(ArrayList arrayList){
        for (int i=0; i<10;i++)
            arrayList.add(new Book("deneme"+i,i));
    }




    public static void mapExample(){
        // map() Operation
        Stream strStream = Stream.of("Welcome", "To", "java", "blog");
        Stream subStream2 = strStream.map(string -> {
            if (string == "java")
                return "Java-W3schools";
            return string;
        });
        List welomeList = (List) subStream2.collect(Collectors.toList());
        System.out.println(welomeList);
    }
    public static void mapExample2(){
        // map() Operation
        Stream strStream = Stream.of("Welcome", "To", "java", "blog");
        Stream subStream2 = strStream.map(string -> {
            if (string == "java")
                return "Java-W3schools";
            return string;
        });
        List welomeList = (List) subStream2.collect(Collectors.toList());
        System.out.println(welomeList);
    }
    public static void filterExample(){
        Stream intStream = Stream.of(1, 2, 3, 4, 5);
        Stream subStream = intStream.filter(value -> {
            if ((int)value>2)
                return true;
            return false;
        });
        long count = subStream.count();
        System.out.println(count);
    }
    public static void distinctExample(){
        // distinct() Operation
        Stream fruitsStream = Stream.of("Apple", "Jack Fruit", "Water Melon", "Apple");
        Stream distinctStream = fruitsStream.distinct();
        distinctStream.forEach(name -> System.out.println(name));
    }
    public static void sortExample(){
        // sort() Operation
        Stream vegStream = Stream.of("tomoto", "Green Chilli", "Pototo", "Beet root");
        Stream sortedStream = vegStream.sorted();
        sortedStream.forEach(name -> System.out.println(name));
    }



}
