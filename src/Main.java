import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // Ilk olarak ürünler üzerinden stream
        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products("Çikolatalı Gofret",15.00,10.00,LocalDate.of(2025,6,6),500));
        productsList.add(new Products("Meyveli Gofret",15.00,10.00,LocalDate.of(2025,6,6),400));
        productsList.add(new Products("Laptop",25000.00,20000.00,LocalDate.of(2035,8,7),100));
        productsList.add(new Products("Deterjan",120.00,100.00,LocalDate.of(2035,12,10),600));

        // ciro hesaplama
        System.out.println("Toplam ciro:");
        double result = productsList.stream().filter(p->p.getExpDate().isAfter(LocalDate.now())).map(p->p.getQuantity()*(p.getPrice()-p.getBuyPrice())).reduce(0.0,(add,val)->add+val);
        System.out.println(result);
        System.out.println("*********");

        // max fiyat urun ismi ve fiyati
        System.out.println("Maksimum ürün fiyatı:");
        Optional<Products> mostexp = productsList.stream().max((p1,p2) -> Double.compare(p1.getPrice(),p2.getPrice()));
        mostexp.stream().forEach(p->System.out.println(p.getName()+"="+p.getPrice()));;
        System.out.println("*********");

        // min fiyat urun ismi ve fiyati
        System.out.println("Minimum ürün fiyatı:");
        Optional<Products> minexp = productsList.stream().min((p1,p2) -> Double.compare(p1.getPrice(),p2.getPrice()));
        minexp.stream().forEach(p->System.out.println(p.getName()+"="+p.getPrice()));;
        System.out.println("*********");

        // icinde "Gofret" barindirani filtreleme
        System.out.println("Gofret barındıran ürünler:");
        productsList.stream().filter(p->p.getName().contains("Gofret")).forEach(p->System.out.println(p.getName()));
        System.out.println("*********");

        // dropwhile metodu ile gofretleri bırakma
        System.out.println("Gofret barındıran  ürünleri dropWhile ile bırakma:");
        productsList.stream().dropWhile(p->p.getName().contains("Gofret")).forEach(p->System.out.println(p.getName()));
        System.out.println("*********");

        // skip metodu ile isminde 'e' içerin  ürünleri atlama
        System.out.println("Skip metodu ile içinde 'e' içerin ürünlerde  ürün atlama:");
        productsList.stream().filter(p->p.getName().contains("e")).skip(1).forEach(p->System.out.println(p.getName()));

        // LIST üzerinden stream :
        List<String> names = new ArrayList<>();
        names.add("Furkan");
        names.add("Ahmet");
        names.add("Mehmet");
        names.add("Ayşe");
        names.add("Sümeyra");
        names.add("Furkan");

        // 'A' ile baslayan isimleri filtreleme
        // Daha temiz bir output almak icin yeni degiskenler olusturup degerler atadim.
        List<String> filtrelenmisIsimler = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println("A ile başlayan isimler: " + filtrelenmisIsimler);
        System.out.println("*********");

        // Isimleri alfabeye gore siralama
        List<String> siralanmis_isimler = names.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted names: " + siralanmis_isimler);
        System.out.println("*********");

        // Ayn isimleri kaldirma
        List<String> farkli_isimler = names.stream().distinct().collect(Collectors.toList());
        System.out.println("Farli isimler: " + farkli_isimler);
        System.out.println("*********");

        // Sadece ilk üc ismi alacak sekilde limitleme
        List<String> limitlenmis_isimler = names.stream().limit(3).collect(Collectors.toList());
        System.out.println("Ilk 3 isim: " + limitlenmis_isimler);
        System.out.println("*********");

        // Isimlerin adetini sayma
        long nameCount = names.stream().count();
        System.out.println("Toplam isim sayisi: " + nameCount);
        System.out.println("*********");

        // 'C' ile baslayan herhangi bir isim var mi diye kontrol etme
        boolean hasCName = names.stream().anyMatch(name -> name.startsWith("C"));
        System.out.println("'C' : " + hasCName);
        System.out.println("*********");

        // Ornek integer listesi
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("*********");

        // Sayilarin toplami
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);
        System.out.println("*********");

        // 36'dan buyuk sayilari siralama
        List<Integer> buyuk = numbers.stream().filter(num -> num > 36).map(num -> num * num).collect(Collectors.toList());
        System.out.println("36'dan büyük sayılar: " + buyuk);
        System.out.println("*********");

        // Ilk cift sayiyi bulma
        numbers.stream().filter(num -> num % 2 == 0).findFirst().ifPresent(num -> System.out.println("Ilk cift sayi: " + num));
        System.out.println("*********");

        // Buyukten kucuge siralama
        List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sıralanmış sayılar: " + sortedNumbers);
    }
}
