# Kafein Egitim

Giriş: lambda expression ve Stream Kütüphanesinin Kullanılması


##Lambda Expression:

###Lambda İfadesi Nedir ?

*   Tek bir soyut metoda sahip bir arayüzü gerçekleştiren ifadedir

*   Lambda ifadesi, pratikte arayüz tipinde bir fonksiyon değerine  karşılık gelir
    -   Dolayısıyla tipi vardır
    -   Gerçekleştirdiği arayüz tipinden bir değişkene atanabilir, parametre olarak metoda geçilebilir ya da metottan geri
        döndürülebilir
    -   Lambda ifadeleri, alternatifi olduğu isimsiz sınıflardan çok daha kısa,
        pratik ve anlaşılırdır
        
###Lambda İfadesinin Yapısı
-   Bir lambda ifadesi şu parçalardan oluşur:
    *   Parantez içinde virgül ile ayrılmış formal parametre listesi
        +   Parametre listesi tabi olarak, lambda ifadesinin gerçekleştirdiği arayüzdeki metodun parametreleriyle aynı sayıda ve uyumlu tipte olmalıdı
        +   Parametreler otomatik olarak yükseltilebilen tipte olabilir
    *   `->` ve
    *   Tek bir ifade ya da {} ile bir blok
        +   Tek bir ifade varsa bloğa gerek yoktur
        +   Birden fazla ifade var ya da return kullanıyorsa blok gereklidir
    
-   İstenirse parantez içindeki parametre listesinde tipler düşürülebilir
    *   Eğer tek bir parametre varsa, parantezler de () düşürülebilir.
   
-   Bir lambda ifadesinde ->’den sonra blok {} yok ise ve dönüş tipi varsa, JVM ilk ifadenin sonucunu geri döndürecektir 
    *   Bu durumda return gerekli değildir
    
-   Metodun döndürdüğü bir tip varsa ve blok kullanılıyorsa bu durumda return zorunludur


###Lambda Syntax

`parameter -> expression`

`(parameter1, parameter2) -> expression`

`(parameter1, parameter2) -> { code block }`

###Fonksiyonel Arayüz

-   Tek bir soyut metoda sahip arayüzlere fonksiyonel arayüz (functional interface) denir 
-   Lambda ifadelerinin tipi, fonksiyonel arayüz olmak zorundadır
-   default ve static metotların gerçekleştirmeleri zaten yine fonksiyonel arayüz üzerinde olduğundan, bu metotlar arayüzün  “fonksiyonel” olmasına bir zarar vermez
    
-   ####@FunctionalInterface
    *   Fonksiyonel olması beklenen arayüzde @FunctionalInterface kulanılması, arayüze birden fazla metot yazılması engellenir.
    *   Zorunlu değildir, bilgi vermek ve hatadan korumak için kullanılır.

###Lambda İfadelerinin Özellikleri
-   Lambda ifadeleri içinde bulundukları kapsamdaki (scope) değişkenlere erişebilir.
-   Lambda ifadeleri statik kapsama (static scope) sahiptir.
    *   Dolayısıyla gerçekledikleri arayüzden herhangi bir değişken devralamaz,
    * İçinde bulundukları kapsamdaki değişkenleri tekrar tanımlayamazlar,
    * Dolayısıyla herhangi bir gölgeleme (shadowing) de söz konusu değildir
    
-   Eğer bir lambda ifadesi, içinde bulunduğu kapsamdaki bir yerel değişkene ulaşırsa, bu yerel değişkenin final ya da effectively final olması gereklidir
-   Lambda ifadeleri, içinde bulunduğu kapsamdaki üye değişkenlere yani statik ve nesne değişkenlerine ulaşabilir
-   Üzerinde değişkenlerine ulaştığı nesnenin, yerel değişken olmasından dolayı, final ya da effectively final olduğunu unutmayın!
-   Kendilerine parametre olarak geçilenler dışında hiç bir yerel değişkeni değiştirememektedir
    *   Ama aynı durum üye değişkenlerde geçerli değildir, lambda ifadeleri nesne ve sınıf değişkenlerinin değerini değiştirebilir

###java.util.function
-   İçerisinde birçok hazır fonksiyonel arayüz bulunmakta kullanılabilir.

##Stream

###Stream Nedir
-   Akış bir veri yapısı değildir, elemanları depolamaz, sadece kendisinden
    üretildiği kaynaktaki elemanlara işaret eder (point), işlemleri elemanlara
    iletir (convey)
    
-   Akış, fonksiyonel bir tabiattadır, yani kaynağını değiştirmez. üzerinde
    çalıştığı elemanları ve elemanların içinde olduğu yapıyı değiştirmez,
    sadece işler gerekirse yeni elemanlar üretir
    
-   Akış, işlemlerini gerektikçe yapar (lazy), gerekmedikçe yapmaz

-   ####Hedef
    *   Bir bir dizi (array), torba (collection), üretici bir fonksiyon (generator function), dosya ya da soket (socket) gibi bir girişçıkış kanalı (I/O channel) olabilir

###Strem Akış
-   Kaynaktan akışın oluşturulması
-   Akışın işlemler vasıtasıyla sıfır ya da daha fazla kere işlenmesi
-   Ve akışın bitirici bir son işlemle kapatılması
-   Akışı işleyen işlemcilere ara işlemci (intermediate operation), akışı
    kapatan işlemciye ise son işlemci ya da bitirici işlemci (terminal
    operation) denir
    
###Ara İşlemler
-   Ara işlemler (intermediate operations), akışlar üzerinde tanımlanmış ve
    akışın temsil ettiği kaynaktaki elemanları işleyen, yüksek-seviyeli
    metotlardır
    
-   Akış, kaynaktaki elemanları değiştirmez, onları eleyebilir, onlardan yeni
    elemanlar üretebilir ya da hesaplamalar yoluyla sonuçlar çıkarabilir
    ama elemanların kendisini değiştirmez
    
    https://farukgenc.com/java/java-8-yenilikleri-bolum-3.html
    
###Bitirici İşlem
-   Ara işlemlerden sonra akışı bitiren, son-bitirici işlem (terminal
    operation) gelir.
-   Son işlemler akış üretmez, işlemin tabiatına göre void ya da bir
    tipte sonuç döndürebilir, ya da bir torba nesne oluşturabilir, vs

https://www.codejava.net/java-core/collections/java-8-stream-terminal-operations-examples
    



        
