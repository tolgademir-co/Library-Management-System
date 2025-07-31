import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // KULLANICIDAN VERİ ALMAK İÇİN--
        Library library = new Library(); // KÜTÜPHANE NESNESİ OLUŞTUR--

        while (true) {
            //ANA MENÜ && EKRAN ÇIKTISI--
            System.out.println("\nLütfen Bir Seçenek Seçin: ");
            System.out.println("1. Yeni Kitap Ekle");
            System.out.println("2. Tüm Kitapları Listele");
            System.out.println("3. Başlığa Göre Kitap Ara");
            System.out.println("4. Kitap Ödünç Al");
            System.out.println("5. Kitap İade Et");
            System.out.println("6. Çıkış");
            System.out.println(); // BİR SATIR BOŞLUK BIRAKIR--
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt(); // KULLANICI'NIN SEÇİMİNİ OKU--
            scanner.nextLine(); // BOŞ SATIR TEMİZLE 'nextINT 'den sonra nextLine şart'--

            switch (choice) {
                case 1:
                    // KİTAP EKLE--
                    System.out.print("Kitap Başlığı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar Adı: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Aranacak Başlık: ");
                    String searcTitle = scanner.nextLine();
                    library.searchByTitle(searcTitle); // BAŞLIĞI GÖRE ARA--
                    break;

                case 4:
                    System.out.print("Ödünç Alınacak Kitabın ISBN: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn); // KİTAP ÖDÜNÇ AL--
                    break;

                case 5:
                    System.out.print("İade Edilicek Kitabın ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn); // KİTAP İADE ET--
                    break;

                case 6:
                    System.out.print("Kütüphane Sistemini Kullandığın için Teşekkürler!!");
                    return; // PROGRAMDAN ÇIKIŞ--

                default:
                    System.out.println("Geçersiz Seçim. Tekrar Deneyiniz!!"); // HATALI GİRİŞ--

            }
        }
    }
}

