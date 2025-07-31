import java.util.ArrayList;

public class Library { // KONSOL ÇIKTILARIN RENK KODLARI && BAŞARILAR 'YEŞİL' = BAŞARISIZLAR 'KIRMIZI'--
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private ArrayList<Book> books; // KİTAPLARI TUTAN LİSTE--

    public Library() {
        books = new ArrayList<Book>(); // BAŞLANGIÇTA BOŞ KİTAP LİSTESİ--
    }

    public void addBook(Book book) {
        books.add(book); // LİSTEYE KİTAP EKLER--
        System.out.println(ANSI_GREEN + " --Book added successfully!!" + ANSI_RESET);
        System.out.println(); // BİR SATIR BOŞLUK BIRAKIR--
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(ANSI_RED + " --Library is Empty!!" + ANSI_RESET);
        } else {
            System.out.println("\n All Books: ");

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);

                // HER KİTAP İÇİN AYRI ÇİZGİ ÇEKMEYE YARAR && ALT SATIR'A GEÇİNCE AYRAÇ GÖREVİ GÖRÜR--
                System.out.println("------------------------");

                // KİTAP BİLGİLERİNİ DÜZENLİ FORMATTA YAZDIRIR--
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
            }
            System.out.println("------------------------\n");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        ArrayList<Book> foundBooks = new ArrayList<>();

        for (Book book : books) { // TÜM EŞLESEN KİTAPLARI BUL--
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                // KISMİ EŞLEŞME İÇİN 'contains' KULLANILDI--
                foundBooks.add(book);
                found = true;
            }
        }

        if (found) {
            System.out.println("\nFound Books:");
            // BULUNAN KİTAPLARI ALT ALTA && DÜZENLİ FORMATTA GÖSTER--
            for (Book book : foundBooks) {
                System.out.println("------------------------");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
            }
            System.out.println("------------------------\n");
        } else {
            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_RED = "\u001B[31m";
            System.out.println(ANSI_RED + " --No Book Found with This Title!!" + ANSI_RESET);
        }
    }

    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) { // ISBN İLE EŞLEŞEN KİTAPLAR--
                if (book.isBorrowed()) {
                    final String ANSI_RESET = "\u001B[0m";
                    final String ANSI_RED = "\u001B[31m";
                    System.out.println(ANSI_RED + " --Book not found or already checked out!!" + ANSI_RESET);
                } else {
                    book.borrowBook(); // KİTABI ÖDÜNÇ AL--
                    final String ANSI_RESET = "\u001B[0m";
                    final String ANSI_RED = "\u001B[31m";
                    System.out.println(ANSI_GREEN + " --Book checked out successfully!!" + ANSI_RESET);
                }

                return;
            }
        }
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED + " --No Book Found with This ISBN Number!!" + ANSI_RESET);
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isBorrowed()) {
                    final String ANSI_RESET = "\u001B[0m";
                    final String ANSI_RED = "\u001B[31m";
                    System.out.println(ANSI_RED + " --This Book is Already in the Library!!" + ANSI_RESET);
                } else {
                    book.returnBook(); // KİTABI İADE ET--
                    final String ANSI_RESET = "\u001B[0m";
                    final String ANSI_RED = "\u001B[31m";
                    System.out.println(ANSI_GREEN + " --Book returned successfully!!" + ANSI_RESET);
                }

                return;
            }
        }
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED + " --No Book Found with This ISBN Number!!" + ANSI_RESET);
    }

    public boolean isBookExists(String title) {
        for (Book book : books) { // KİTAP LİSTESİNDEKİ HER KİTABI GEZER--
            if (book.getTitle().equalsIgnoreCase(title)) { // KİTAP İSMİ EŞLEŞİYORSA 'BÜYÜK & KÜÇÜK HARFE DUYARSIZ'--
                return true; // KİTAP ZATEN VAR--
            }
        }

        return false; // KİTAP YOK--
    }
}
