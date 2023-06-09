package com.kafein.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGiris {
    public static void main(String[] args) {


        //base stream
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("ddede");
//        arrayList.add("ddede");
//        //  arrayList.add("deneme");
//        arrayList.stream().filter(x->x.equals("deneme")).forEach(s -> System.out.println(s));
//        //Akış oluşturma
//        Stream<String> streamArrayList = arrayList.stream();
//
//        //Ara eleman kısmı, ara elemanlar stream objesini bozmazlar her eklenen ara eleman bir stream objsi oluştururlar
//        Stream<String> stringStreamList = arrayList.stream().filter(x->x.equals("deneme")).limit(2);
//        streamArrayList=streamArrayList.sorted();
//        streamArrayList=streamArrayList.distinct();

//
//        //Bitirici eleman kısmı bundan sonra akış sonlanacaktır
//        ArrayList<String> arrayList1= (ArrayList<String>) streamArrayList.collect(Collectors.toList());
//        ArrayList<String> arrayList2= (ArrayList<String>) streamArrayList.collect(Collectors.toList());
//        ArrayList<String> arrayList3= (ArrayList<String>) arrayList.stream().filter(x->x.equals("deneme")).collect(Collectors.toList());
//        arrayList.stream().filter(x->x.equals("deneme")).forEach(s -> System.out.println(s));

//        streamAcikBirakilirsa();
//        streamKapatma();
//        mapGiris();
//        arrayListGiris();
//        intStreamOrnek();
        intStreamOrnek2();


    }
    public static void intStreamOrnek(){
        //IntStreamOrnek //DoubleStream // LongStream

        int[] arr = IntStream.generate(()
                -> { return (int)(Math.random() * 10); }).limit(10).toArray();

        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void intStreamOrnek2(){
        //IntStreamOrnek //DoubleStream // LongStream

        IntStream.generate(()
                -> { return (int)(Math.random() * 10); }).limit(10).forEach(
                (a) -> {
                    System.out.print(a+"'nın karesi: ");
                    a= a*a;
                    System.out.println(a);
                }
        );
//        ArrayList<Integer> integers= (ArrayList<Integer>) IntStream.generate(()
//                -> { return (int)(Math.random() * 10); }).limit(10).peek(x-> System.out.println(x)).mapToObj(
//                (a) -> {
//                    return a= a*a;
//                }
//        ).collect(Collectors.toList());
//        System.out.println("------------------------");
//        integers.stream().forEach(System.out::println);
    }
    public static void mapGiris(){
        Map<String, Integer>  map = new HashMap<>();
        map.put("1",2);
        map.put("2",3);
        map.put("3",4);
        map.put("4",5);
        map.put("5",6);
        Map<String,Integer> map2=map.entrySet().stream().filter(x->x.getValue()>5).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        map2.entrySet().stream().forEach(System.out::println);
    }
    public static void arrayListGiris(){
        ArrayList<String> arrayList1 =new ArrayList<>();
        arrayList1.add("Geeks");
        arrayList1.add("For");
        arrayList1.add("Example");
        arrayList1.add("A");
        System.out.println("---------------BASE---------------");
        arrayList1.stream().forEach(System.out::println);
        System.out.println("---------------SORTED---------------");
        List<String> strinArrayList= arrayList1.stream().sorted().collect(Collectors.toList());

        System.out.println("--------------EXTEND----------------");
//        arrayList1.stream().limit(2).forEach((s)->{
//            s= s+"deneme";
//            System.out.println(s);
//        });
        strinArrayList.stream().limit(2).forEach((s)->{
            s= s+"deneme";
            System.out.println(s);
        });
    }
    public static void streamKapatma(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        Stream<String> streamOfArrayList = arrayList.stream();

        System.out.println("collection:" + arrayList);
        System.out.println("streamOfCollection:" + streamOfArrayList.collect(Collectors.toList()));

        //stream kapatıldı
        try {
            System.out.println("streamOfCollection:" + streamOfArrayList.collect(Collectors.toList()));
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void streamAcikBirakilirsa(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cc");
        arrayList.add("ee");
        arrayList.add("dd");

        Stream<String> streamOfArrayList = arrayList.stream();

        System.out.println("Base collection:" + arrayList);
        streamOfArrayList= streamOfArrayList.filter(x->x.length()==1);
        streamOfArrayList = streamOfArrayList.map(x->x+"deneme");

        arrayList.add("a");
        System.out.println("Extend collection:" + arrayList);

        //kapatılmadı
        System.out.println("streamOfCollection:" + streamOfArrayList.collect(Collectors.toList()));
    }


}
