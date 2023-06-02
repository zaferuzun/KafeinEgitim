package com.kafein.stream;

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

    public static void collectExample(){

    }

}
