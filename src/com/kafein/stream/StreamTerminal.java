package com.kafein.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTerminal {

    public static void main(String[] args) {
//        1. The allMatch() operation
//        2. The anyMatch() operation
//        3. The noneMatch() operation
//        4. The collect() operation
//        5. The count() operation
//        6. The forEach() operation
//        7. The min() operation
//        8. The max() operation
//        9. The reduce() operation

//        allMatchExample();
//        anyMatchExample();
//        noneMatchExample();
        //collect
//        collectExample1();
//        collectExample2();
//        collectExample3();

        //count
//        countExample();
        //forech
        //forenchExample();

        //min
//        minExample();
//        minExample2();
//        minExample3();

        //max
//        maxExample();
        maxExample2();

        //reduce
//        reduceExample();
//        reduceExample2();
    }

    public static void allMatchExample(){
        System.out.println("elemanların hepsi 3den büyük mü : " + Stream.of(1,2,3,4,5,6,7,8,9).allMatch(x->x>3));
        System.out.println("elemanların hepsi 10 dan küçük mü : " + Stream.of(1,2,3,4,5,6,7,8,9).allMatch(x->x<10));
        System.out.println("elemanların hepsi 0 dan büyük mü : " + Stream.of(1,2,3,4,5,6,7,8,9).allMatch(x->x>0));
        System.out.println("elemanların hepsi 3 mü : " + Stream.of(1,2,3,4,5,6,7,8,9).allMatch(x->x==3));
        System.out.println("elemanların kareleri 100den küçük mü: " + Stream.of(1,2,3,4,5,6,7,8,9).allMatch(x-> {
            int y= x*x;
            return y<100;
        }));

    }
    public static void anyMatchExample(){

        System.out.println("elemanların içinde 3den büyük elaman var mı : " + Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(x->x>3));
        System.out.println("elemanların içinde 10dan küçük eleman var mı: " + Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(x->x<10));
        System.out.println("elemanların hepsi 3 mü : " + Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(x->x==3));
        System.out.println("elemanların kareleri 100den küçük mü: " + Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(x-> {
            int y= x*x;
            return y<100;
        }));
        System.out.println("elemanların içinde mükemmel sayı var mı" + Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(StreamTerminal::isPerfect));

//        Stream.of(10,2,3,4,5,6,7,8,9).peek(x->{
//            System.out.println(x+ " eleman mükemmel sayi mi" +isPerfect(x));
//        }).anyMatch(StreamTerminal::isPerfect);

//        Stream.of(10,2,3,4,5,6,7,8,9).peek(x->{
//            System.out.println(x+ " eleman mükemmel sayi mi" +isPerfect(x));
//        }).count();

    }
    // Returns true if n is perfect
    static boolean isPerfect(int n)
    //Mükemmel Sayı = Kendisi hariç pozitif tam bölenlerinin toplamı kendisine eşit olan sayıdır.
    {
        // 1 is not a perfect number
        if (n == 1)
            return false;

        // sum will store the sum of proper divisors
        // As 1 is a proper divisor for all numbers
        // initialised sum with 1
        int sum = 1;

        // Looping through the numbers to check if they are
        // divisors or not
        for (int i = 2; i < n; i++) {

            if (n % i == 0) {
                sum += i;
            }

        }

        // If sum of divisors is equal to
        // n, then n is a perfect number
        if (sum == n)
            return true;

        return false;
    }



    public static void noneMatchExample(){
        System.out.println("elemanların içinde 3 yok : " + Stream.of(1,2,3,4,5,6,7,8,9).noneMatch(x->x==3));
        System.out.println("elemanların içinde 10 yok : " + Stream.of(1,2,3,4,5,6,7,8,9).noneMatch(x->x==10));
    }

    public static void collectExample1(){
        List<Integer> numberList = Arrays.asList(11, 3, 2, 3, 8, 9, 0, 7, 2, 3, 4, 6, 8, 9, 2, 3, 4, 5, 6, 8, 9, 21, 3, 5, 6);

        Set<Integer> collect = numberList.stream().collect(Collectors.toSet()); // Çıktı : 0 2 3 4 5 21 6 7 8 9 11
        collect.stream().forEach(System.out::println);
    }
    public static void collectExample2(){
        List<Integer> numberList = Arrays.asList(11, 3, 2, 3, 8, 9, 0, 7, 2, 3, 4, 6, 8, 9, 2, 3, 4, 5, 6, 8, 9, 21, 3, 5, 6);
        ArrayList<Integer> collect = (ArrayList<Integer>) numberList.stream().collect(Collectors.toList()); // Çıktı : 0 2 3 4 5 21 6 7 8 9 11
        collect.stream().forEach(System.out::println);
    }

    public static void collectExample3(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //Function.identity() her zaman giriş bağımsız değişkenini döndüren bir işlev
        Map<Integer, Integer> mapOddNumbers = numbers.stream().
                collect(Collectors.toMap( Function.identity(),x->x));
        System.out.println(mapOddNumbers);
    }

    public static void countExample(){
        long i =  Stream.of(1,2,3,4,5,6,7,8,9).filter(x-> x>5).count();
        System.out.println(i);
    }

    public static void forenchExample(){
        Stream.of(1,2,3,4,5,6,7,8,9).filter(x-> x>5).forEach(System.out::println);
    }

    public static void minExample(){
        Optional<Integer> i=Stream.of(1,2,3,4,5,6,7,8,9).min(Integer::compare);
        System.out.println(i.get());
    }
    public static void minExample2(){
        // creating an array of strings
        String[] array = { "Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz" };

        // The Comparator compares the strings
        // based on their last characters and returns
        // the minimum value accordingly.
        Optional<String> minWord = Arrays.stream(array).min((str1, str2) ->
                Character.compare(str1.charAt(str1.length() - 1),
                        str2.charAt(str2.length() - 1)));
        System.out.println(minWord.get());
    }

    public static void minExample3(){
        String[] array = { "Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz" };

        Optional<String> minWord = Arrays.stream(array).min(Comparator.comparing(x->x.length()));
        System.out.println(minWord.get());
    }
    public static class User {
        private long id;
        private String firstName;
        private String lastName;
        private int age;

        public User(long id, String firstName, String lastName, int age) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void setUser(){
        StreamFunction.User p1 = new StreamFunction.User(1,"Ahmet", "dd",10);
        StreamFunction.User p2 = new StreamFunction.User(2,"Ayşe", "dd",21);
        StreamFunction.User p3 = new StreamFunction.User(3,"Veli", "dd",35);
        StreamFunction.User p4 = new StreamFunction.User(4,"Ali", "dd",41);
        StreamFunction.User p5 = new StreamFunction.User(5,"Zuzu", "dd",26);

        List<StreamFunction.User> personList = Arrays.asList(p1, p2, p3, p4, p5);

    }

    public static void maxExample(){
        Optional<Integer> i=Stream.of(1,2,3,4,5,6,7,8,9).max(Integer::compare);
        System.out.println(i.get());
    }
    public static void maxExample2(){
        // creating an array of strings
        String[] array = { "Geeks", "for", "GeeksforGeeks",
                "GeeksQuiz" };

        // The Comparator compares the strings
        // based on their last characters and returns
        // the minimum value accordingly.
        Optional<String> minWord = Arrays.stream(array).max((str1, str2) ->
                Character.compare(str1.charAt(str1.length() - 1),
                        str2.charAt(str2.length() - 1)));
        System.out.println(minWord.get());
    }

    public static void reduceExample() {
//        Stream#reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir nesne kabul etmektedir.

        int result = IntStream
                .of(1, 2, 3, 4, 5)
                .reduce(0, (once, sonra) -> {
                    System.out.format("önceki eleman %d ile sonra ki eleman %d  toplandı ve diger işlemin ilk elemanı  = %d %n", once, sonra,once+sonra);
                    return once + sonra;
                });
        System.out.println(result);
    }
    public static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return this.age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        // getter, setter ve constructor metodları
    }

    public static void reduceExample2() {
        // map ve reduce işlemleri  birlikte kullanımı çok fazla tercih edilen iki operasyondur.

        Person p1 = new Person("Ahmet", 12);
        Person p2 = new Person("Ali", 20);
        Person p3 = new Person("Ayşe", 30);
        Person p4 = new Person("Murat", 51);
        Person p5 = new Person("Zeynep", 60);

        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);

        double averagePersonAge=personList
                .stream()
                .map(person -> person.getAge())
                .reduce(0, (a, b) -> (a + b)/2);

        System.out.println(averagePersonAge);

    }

}
