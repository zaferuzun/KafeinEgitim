package com.kafein.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFunction {

    private static List<User> userArrayList;

    public static void main(String[] args) {
        //Predicate<T>
        //boolean döndüren bir functional interface
        //lambda
//        predicateExample();
//        //method
//        predicateExample2();

        //Function<? super T
        //Bir bağımsız değişken alan ve bir sonuç üreten bir işlevi temsil eder.
        //lambda
//        functionExample();
        //method
//        functionExample2();

//        Comparator<T>
        //Kullanıcı tanımlı sınıfların nesnelerini sıralamak için bir karşılaştırma arabirimi kullanılır. Karşılaştırma nesnesi, aynı sınıftaki iki nesneyi karşılaştırabilir
//        Pozitif (> 0) tamsayı => geçerli nesne> geçirilen nesne parametresi.
//                Negatif (mevcut nesne
//                        Sıfır (= 0) => geçerli nesne ve belirtilen nesnenin her ikisi de eşittir.

//        comparatorExample();
    }

    public static void predicateExample(){
        Predicate<Integer> pr = a -> (a > 18); // Creating predicate
        System.out.println(pr.test(20));    // Calling Predicate method

    }
    public static void predicateExample2(){
        // Using Predicate interface
        Predicate<Integer> predicate =  StreamFunction::checkAge;
        // Calling Predicate method
        boolean result = predicate.test(25);
        System.out.println(result);

    }
    static Boolean checkAge(int age){
        if(age>17)
            return true;
        else return false;
    }

    public static void functionExample(){
        Function<Integer, Double> half = a -> a / 2.0;

        System.out.println(half.apply(10));
    }
    public static void functionExample2(){
        Function<Integer, Double> half = StreamFunction::half;

        System.out.println(half.apply(20));
    }
    static Double half(int number){
        return number/2.0;
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
        User p1 = new User(1,"Ahmet", "dd",10);
        User p2 = new User(2,"Ayşe", "dd",21);
        User p3 = new User(3,"Vel", "dd",35);
        User p4 = new User(4,"Ali", "dd",41);
        User p5 = new User(5,"Zuzu", "dd",26);

        userArrayList = Arrays.asList(p1, p2, p3, p4, p5);

    }
    public static void comparatorExample(){
        setUser();
        ArrayList<User> str = (ArrayList<User>) userArrayList.stream().
                sorted(Comparator.comparing(User::getFirstName))
                .collect(Collectors.toList());

//        str.stream().forEach(x-> System.out.println(x.getFirstName()));



//        ArrayList<User> userArrayList1= (ArrayList<User>) userArrayList.stream().sorted((p1, p2) -> {
//            return p1.getFirstName().compareTo(p2.getFirstName());
//        }).collect(Collectors.toList());
//        userArrayList1.stream().forEach(x-> System.out.println(x.getFirstName()));


//        Optional<User> user = userArrayList.stream().max((u1, u2)->{
//            if(u1.getFirstName().length()>u2.getFirstName().length())
//                return 1;
//            else if (u1.getFirstName().length()==u2.getFirstName().length())
//                return 0;
//            else
//                return -1;
//        });
//
//        System.out.println(user.get().getFirstName());

//        Optional<User> user = userArrayList.stream().min((u1, u2)->{
//            if(u1.getFirstName().length()>u2.getFirstName().length())
//                return 1;
//            else
//                return -1;
//        });
//        System.out.println(user.get().getFirstName());

        Optional<User> user = userArrayList.stream().min((u1, u2)->{
            if(u1.getFirstName().length()<2 && u2.getFirstName().length()<2)
                return 1;
            else
                return -1;
        });
        System.out.println(user.get().getFirstName());
    }


}
