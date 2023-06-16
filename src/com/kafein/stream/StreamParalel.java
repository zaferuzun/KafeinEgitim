package com.kafein.stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamParalel {

    public static long startTime= System.nanoTime();

    public static void main(String[] args) {

        //** Collection#stream() metoduyla ardışıl (sequential) , Collection#parallelStream() metoduyla da paralel Stream nesnesi elde edilmektedir.
        // Elde edilen paralel Stream nesnesiyle koşturulan işlemler paralel olarak koşabilmektedir.

//        ParalelGiris();

        //**Aynı zamanda bir ardışıl Stream nesnesinden paralel Stream nesnesi elde edilebilmektedir. Bunun için Stream#parallel metodu kullanılmaktadır.
//        ParalelGiris2();

//        **Aynı zamanda bir paralel Stream nesnesinden ardışıl Stream nesnesi de elde edilebilmektedir. Bunun için Stream#sequential metodu kullanılmaktadır.

//        ParalelGiris3();


        //Stream vs Forench
//        forenchExample();
//        streamExample();
//        paralelStreamExample();
//        paralelStreamExample2();
//        paralelStreamExample3();

        //Java’da paralel işletilen programlar yazmak giderek kolaylaşıyor gibi görünse de, bunu doğru ve yüksek performans alarak yapmak hiç de kolay değildir.
        // Thread güvenliği ve canlılık (liveness) ihlalleri paralel programlamanın doğasında olan sorunlardır ve paralel streamler de bunun bir istisnası değildir.

        //Stream hesaplamalarının paralelleştirilmesi kötü performansa sebep olabileceği gibi, programın yanlış sonuçlar üretmesine ve tutarsız davranmasına da sebep olabilir.
        //dolayısıyla rastgele paralelleştirme yapılmaması gerekir.
//        summaryForObjectParalel();
//        summaryForObjectArdısik();


        //Paralel performans için örnegimiz
//        ardisikPerformans();
//        paralelPerformans();
        forPrime();

        //Özetle, bir stream hattının doğru sonuçları üreteceğinden ve hız artışı sağlayacağından emin değilseniz paralel yapmaya kalkışmayın.
        // Yanlış durumda yapılan paralel işletimin programın çökmesi veya performansın yerlerde sürünmesi gibi etkileri olabileceğini unutmayın.
    }

    public static void ParalelGiris(){
        List ints = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

        Stream stream = ints.stream();
        Stream parallelStream = ints.parallelStream();
    }
    public static void ParalelGiris2(){
        List ints = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

        Stream stream = ints.stream(); // Ardışıl
        Stream parallelStream = (Stream) stream.parallel(); // Paralel
    }
    public static void ParalelGiris3(){
        List ints = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);

        Stream parallelStream = ints.parallelStream(); // Paralel
        Stream stream = (Stream) parallelStream.sequential(); // Ardışıl
    }
    public static long endTimer(){
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }
    public static void resetTimer(){
        startTime= System.nanoTime();
    }

    public static void forenchExample(){
        resetTimer();
        long sum = 0;
        for(int i =0; i<1000;i++){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println("forench " + endTimer()+" sürdü.");
    }
    public static void streamExample(){
        resetTimer();
        long sum = IntStream.range(0, 1000).reduce(0, (a, b) -> a + b);

        System.out.println(sum);
        System.out.println("stream " + endTimer()+" sürdü.");
    }
    public static void paralelStreamExample(){
        resetTimer();
        long sum = IntStream.range(0, 1000).parallel().reduce(0, (a, b) -> a + b);

        System.out.println(sum);
        System.out.println("paralel stream " + endTimer()+" sürdü.");
    }

    public static void paralelStreamExample2(){
        resetTimer();
        long summary = IntStream.range(0, 1000).parallel().asLongStream().sum();

        System.out.println(summary);
        System.out.println("paralel stream2 " + endTimer()+" sürdü.");
    }

    public static void paralelStreamExample3(){
        resetTimer();
        long summary = IntStream.range(0, 1000).asLongStream().sum();

        System.out.println(summary);
        System.out.println("paralel stream3 " + endTimer()+" sürdü.");
    }
    static class Summary{
        int summary;

        public int getSummary() {
            return summary;
        }

        public void setSummary(int summary) {
            this.summary = summary;
        }
    }

    public static void summaryForObjectParalel(){
        resetTimer();
        Summary summary = new Summary();
        IntStream.range(0, 1000).parallel().forEach(x-> {
            summary.setSummary(summary.getSummary()+x);
        });
        System.out.println(summary.getSummary());
        System.out.println("summaryForObjectParalel " + endTimer()+" sürdü.");
    }
    public static void summaryForObjectArdısik(){
        resetTimer();
        Summary summary = new Summary();
        IntStream.range(0, 1000).forEach(x-> {
            summary.setSummary(summary.getSummary()+x);
        });
        System.out.println(summary.getSummary());
        System.out.println("summaryForObjectArdısik " + endTimer()+" sürdü.");
    }


    public static void ardisikPerformans(){
        // Paralel streamlerin faydalı olabileceği bir hesaplama
        // 2 den 1000000 kadar olan asal sayıların sayısını verir
        resetTimer();
        long x= LongStream.rangeClosed(2, 1000000)
                    .mapToObj(BigInteger::valueOf)
                    .filter(i -> i.isProbablePrime(50))
                    .count();
        System.out.println(x);
        System.out.println("ardisikPerformans " + endTimer()+" sürdü.");
    }

    public static void paralelPerformans(){
        // Paralel streamlerin faydalı olabileceği bir hesaplama
        // 2 den 1000000 kadar olan asal sayıların sayısını verir
        resetTimer();
        long x= LongStream.rangeClosed(2, 1000000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
        System.out.println(x);
        System.out.println("paralelPerformans " + endTimer()+" sürdü.");

    }

    public static void forPrime(){
        resetTimer();
        int primeSize=0;
        for(int i=0; i<1000000;i++){
            BigInteger bigInteger= BigInteger.valueOf(i);
            if(bigInteger.isProbablePrime(50))
                primeSize++;
        }
        System.out.println(primeSize);
        System.out.println("forPrime " + endTimer()+" sürdü.");

    }


}
