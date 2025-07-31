import java.util.Scanner;

public class Main {

    private static String author;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // KULLANICIDAN VERİ ALMAK İÇİN--
        Library library = new Library(); // KÜTÜPHANE NESNESİ OLUŞTUR--

        while (true) {
            //ANA MENÜ && EKRAN ÇIKTISI--
            System.out.println("\nPlease select an option: ");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.println(); // BİR SATIR BOŞLUK BIRAKIR--

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine(); // SEÇİMİ SATIR OLARAK AL 'TRY-CATCH METHODU İÇİN GEREKLİ'

            int choice;
            try { // MENÜ SEÇİMİNİ HATALARDAN KORUMAK İÇİN KULLANILIR
                choice = Integer.parseInt(input.trim()); // GİRİŞ SATIRINI OKUYUP TAMSAYIYA ÇEVİR--
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Number!!"); // HATALI GİRİŞ MESAJ ÇIKTISI--
                continue; // DÖNGÜ BAŞINA DÖN & TEKRAR MENÜYÜ GÖSTER
            }

            switch (choice) {
                case 1:
                    // KİTAP EKLE--
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine(); // KİTAP BAŞLIĞINI GİR--
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine(); // KİTAP YAZAR ADINI GİR--
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine(); // ISBN'Nİ GİR--
                    Book book = new Book(title, author, isbn); // YENİ KİTAP OLUŞTUR--
                    library.addBook(book); // KÜTÜPHANEYE EKLE--
                    break; // BU CASE'İ BİTİRİR VE SWITCH BLOĞUNDAN ÇIKAR

                case 2: // TÜM KİTAPLARI LİSTELE--
                    library.displayBooks();
                    break; // SWITCH BLOĞUNDAN ÇIKAR VE DÖNGÜ DEVAM EDER

                case 3: // BAŞLIĞA GÖRE ARAMA YAP--
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchByTitle(searchTitle); // BAŞLIĞI GÖRE ARA--
                    break; // BU SEÇENEĞİ TAMAMLAR VE ANA MENÜYE DÖNER

                case 4: // KİTAP ÖDÜNÇ AL--
                    System.out.print("Enter the ISBN of the book you want to check out: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn); // KİTAP ÖDÜNÇ AL--
                    break; // İŞLEM BİTER, DÖNGÜ YENİDEN BAŞLAR

                case 5: // KİTAP İADE ET--
                    System.out.print("Enter the ISBN of the book you want to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn); // KİTAP İADE ET--
                    break; // BU İŞLEM TAMAMLANDIKTAN SONRA MENÜ YENİDEN GÖSTERİLİR--

                case 6: // PROGRAMDAN ÇIKIŞ--
                    final String ANSI_RESET = "\u001B[0m";
                    final String ANSI_GREEN = "\u001B[32m";
                    System.out.print(ANSI_GREEN + "Thank you for using Library Management System!!" + ANSI_RESET);
                    System.out.println(); // BİR SATIR BOŞLUK BIRAKIR--
                    return;

                default: // GEÇERSİZ SEÇİM
                    System.out.println("Invalid Selection. Please Try Again!!");

            }
        }
    }
}

