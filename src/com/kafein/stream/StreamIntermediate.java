package com.kafein.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamIntermediate {
    public static void main(String[] args) {

        //filter(Predicate<T>)
        //filterExample();

        //map(Function<T>) (mapToInt,mapToLong,mapToDouble)
        //MapExample();

        ArrayList<Book> bookArrayList =new ArrayList<>();
//        setBook(bookArrayList);
//        List<Integer> bookArrayList1 = bookArrayList.stream().map(e->e.id*2).collect(Collectors.toList());

//        setBookStream(bookArrayList);
//        mapExample2(bookArrayList);
//        mapExample3();
//        mapWithSetBookStream();
        //flatmap()
//        flatMapExample1();
//        flatMapExample2();

//        flatMapVsMapExample();
//        flatMapVsMapExample2();
//        peek()
//        peekExample();
//        peekExample2();
//        peekExample3();
        //distinct()
        //        distinctExample();
        //limit()
//        limitExample();
        //skip()
//        skipExample();

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
    public static void setBookStream(ArrayList<Book> arrayList){
        int[] array = IntStream.range(1,11).limit(10).toArray();
        Arrays.stream(array).forEach((a)->{
            arrayList.add(new Book("deneme"+a,a));
        });
        printArrayList(arrayList);
        //extend
//        Arrays.stream(IntStream.range(1,11).limit(10).toArray()).forEach((a)->{
//            bookArrayList.add(new Book("deneme"+a,a));
//        });
    }
    public static void printArrayList(ArrayList<Book> bookArrayList){
        bookArrayList.stream().forEach((bookStream)->{
            System.out.println(bookStream.getId()+" "+bookStream.getName());
        });
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
    public static void mapExample2(ArrayList<Book> arrayList){
        //return bookArrayList
//        ArrayList<String> bookName = (ArrayList<String>) arrayList.stream().map(book -> {
//            return book.getName();
//        }).collect(Collectors.toList());
        arrayList.stream().map(book -> {
            return book.getName();
        }).forEach(System.out::println);
    }
    public static void mapExample3(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> squares =  numbers.stream().map(i-> i*i).collect(Collectors.toList());
        squares.forEach(System.out::println);
    }
    public static void mapWithSetBookStream(){

//        int[] array = IntStream.range(1,11).limit(10).toArray();
//        Arrays.stream(array).mapToObj(a->{
//            return new Book("deneme"+a,a);
//        }).collect(Collectors.toList());

        int[] array = IntStream.range(1,11).limit(10).toArray();
        ArrayList<Book> bookArrayList= (ArrayList<Book>) Arrays.stream(array).mapToObj(a->{
            return new Book("deneme"+a,a);
        }).collect(Collectors.toList());
        printArrayList(bookArrayList);

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
        Stream vegStream = Stream.of("tomoto", "Green Chilli", "potato", "Beet root");
        Stream sortedStream = vegStream.sorted();
        sortedStream.forEach(name -> System.out.println(name));
    }
    public static  void flatMapExample1(){

        List<String> list = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");
        list.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::println);
    }
    public static  void flatMapExample2(){

        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<ArrayList<String>> arrayList3 = new ArrayList<>();
        Stream<ArrayList<String>> streamArrayList2 = arrayList3.stream();
        Stream<String> stream = streamArrayList2.flatMap(Collection::stream);

    }
    public static void flatMapVsMapExample(){
        //mapExample3();

        List<List<Integer>> numbers = new ArrayList<>();
        numbers.add(Arrays.asList(1, 2));
        numbers.add(Arrays.asList(3,4,5,6));
        numbers.add(Arrays.asList(7,8,9,0));
        //compiler error
//        List<Integer> squares =  numbers.stream().map(i-> i*i).collect(Collectors.toList());
//        squares.forEach(System.out::println);
        List<Integer> squares = numbers.stream()
                .flatMap(l -> l.stream())
                .map(i -> i * i).collect(Collectors.toList());

        //null olursa nasıl kontrol edebiliriz
//        List<Integer> squares = numbers.stream().filter(Objects::nonNull)
//                .flatMap(l -> l.stream())
//                .map(i -> i * i).collect(Collectors.toList());

        squares.forEach(System.out::println);
    }
    public static void flatMapVsMapExample2() {
    class Book{
        String bookName;
        String soldNumber;

        public Book(String bookName, String soldNumber) {
            this.bookName = bookName;
            this.soldNumber = soldNumber;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getSoldNumber() {
            return soldNumber;
        }

        public void setSoldNumber(String soldNumber) {
            this.soldNumber = soldNumber;
        }
    }
    class Author{
        String authorName;
        ArrayList<Book> book;

        public Author(String authorName) {
            this.authorName = authorName;
        }

        public Author(String authorName, ArrayList<Book> book) {
            this.authorName = authorName;
            this.book = book;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public ArrayList<Book> getBook() {
            return book;
        }

        public void setBook(ArrayList<Book> book) {
            this.book = book;
        }
    }

    Author author = new Author("Ali");
    ArrayList<Book> bookArrayList = new ArrayList<>();
    bookArrayList.add(new Book("denemeler","50"));
    bookArrayList.add(new Book("denemeler2","100"));
    bookArrayList.add(new Book("denemeler3","40"));
    bookArrayList.add(new Book("denemeler4","60"));
    author.setBook(bookArrayList);
    ArrayList<Author> authorArrayList = new ArrayList<>();
    authorArrayList.add(author);
//    List<String> authorBookName = authorArrayList.stream().map((x)->{
//        return x.getBook().getBookName();
//    });
//        ArrayList<Book> bookArrayList1= (ArrayList<Book>) authorArrayList.stream().flatMap(x->x.getBook().stream()).collect(Collectors.toList());
//        List<ArrayList<Book>> bookArrayList2=  authorArrayList.stream().map(x->x.getBook()).collect(Collectors.toList());

//        authorArrayList.stream().flatMap(x->x.getBook().stream()).map(Book::getBookName).forEach(System.out::println);
//        authorArrayList.stream().flatMap(x->x.getBook().stream()).forEach(System.out::println);

    }
    public static void peekExample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> squares =  numbers.stream().filter(x->x>3).peek(
                x->{
                    System.out.println("Filtered array : " + x );
                }
        ).map(i-> i*i).peek(y->{
            System.out.println("Filtered square array: " + y);
        }).collect(Collectors.toList());
    }
    public static void peekExample2(){
        List<Integer> list
                = Arrays.asList(0, 2, 4, 6, 8, 10);
        //akış içerisinde ki işlemleri görmek için kullanıldıgı için tek başına bi anlam ifade etmiyor
        list.stream().peek(System.out::println);
//        list.stream().peek(System.out::println).count();

    }
    public static void peekExample3(){
        //Alternatif olarak, map() işlevini kullanabilirdik  , ancak öğeyi değiştirmek istemediğimiz için peek() daha uygundur.

        Stream<Book> bookStream = Stream.of(new Book("Book1",1), new Book("Book2",2), new Book("Book3",3));
        bookStream.forEach(x->{
            System.out.println(x.getName());
        });
        System.out.println("--------------------------------------");

//        ArrayList<Book> bookArrayList = (ArrayList<Book>) bookStream.peek(u -> {
//                    System.out.println(u.getName().toLowerCase());
//        })
//                .collect(Collectors.toList());
//        bookArrayList.stream().map(x->x.getName()).forEach(System.out::println);

//        ArrayList<Book> bookArrayList= (ArrayList<Book>) bookStream.peek(u -> u.setName(u.getName().toLowerCase())).collect(Collectors.toList());
//        bookArrayList.forEach(x->{
//            System.out.println(x.getName());
//        });
        System.out.println("--------------------------------------");
        Stream<Book> bookStream2 = Stream.of(new Book("Book1",1), new Book("Book2",2), new Book("Book3",3));
        bookStream2.map(u->u.getName().toLowerCase())
                .forEach(System.out::println);
    }
    public static void limitExample(){
        List<Integer> list
                = Arrays.asList(0, 2, 4, 6, 8, 10);

        list.stream().limit(3).peek(System.out::println).count();
    }
    public static void skipExample(){
        //        Stream<Integer> intArray = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .skip(5)
                .forEach(i -> System.out.print(i + " "));
    }

}
