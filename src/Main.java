import java.util.Scanner;

public class Main {

    private static String author;

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
            String input = scanner.nextLine(); // SEÇİMİ SATIR OLARAK AL 'TRY-CATCH METHODU İÇİN GEREKLİ'

            int choice;
            try { // MENÜ SEÇİMİNİ HATALARDAN KORUMAK İÇİN KULLANILIR
                choice = Integer.parseInt(input.trim()); // GİRİŞ SATIRINI OKUYUP TAMSAYIYA ÇEVİR--
            } catch (NumberFormatException e) {
                System.out.println("Lütfen Geçerli Bir Sayı Giriniz!"); // HATALI GİRİŞ MESAJ ÇIKTISI--
                continue; // DÖNGÜ BAŞINA DÖN & TEKRAR MENÜYÜ GÖSTER
            }

            switch (choice) {
                case 1:
                    // KİTAP EKLE--
                    System.out.print("Kitap Başlığı: ");
                    String title = scanner.nextLine(); // KİTAP BAŞLIĞINI GİR--
                    System.out.print("Yazar Adı: ");
                    String author = scanner.nextLine(); // KİTAP YAZAR ADINI GİR--
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine(); // ISBN'Nİ GİR--
                    Book book = new Book(title, author, isbn); // YENİ KİTAP OLUŞTUR--
                    library.addBook(book); // KÜTÜPHANEYE EKLE--
                    break; // BU CASE'İ BİTİRİR VE SWITCH BLOĞUNDAN ÇIKAR

                case 2: // TÜM KİTAPLARI LİSTELE--
                    library.displayBooks();
                    break; // SWITCH BLOĞUNDAN ÇIKAR VE DÖNGÜ DEVAM EDER

                case 3: // BAŞLIĞA GÖRE ARAMA YAP--
                    System.out.print("Aranacak Başlık: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle); // BAŞLIĞI GÖRE ARA--
                    break; // BU SEÇENEĞİ TAMAMLAR VE ANA MENÜYE DÖNER

                case 4: // KİTAP ÖDÜNÇ AL--
                    System.out.print("Ödünç Alınacak Kitabın ISBN: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn); // KİTAP ÖDÜNÇ AL--
                    break; // İŞLEM BİTER, DÖNGÜ YENİDEN BAŞLAR

                case 5: // KİTAP İADE ET--
                    System.out.print("İade Edilicek Kitabın ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn); // KİTAP İADE ET--
                    break; // BU İŞLEM TAMAMLANDIKTAN SONRA MENÜ YENİDEN GÖSTERİLİR--

                case 6: // PROGRAMDAN ÇIKIŞ--
                    System.out.print("Kütüphane Sistemini Kullandığın için Teşekkürler!!");
                    return;

                default: // GEÇERSİZ SEÇİM
                    System.out.println("Geçersiz Seçim. Tekrar Deneyiniz!!");

            }
        }
    }
}

