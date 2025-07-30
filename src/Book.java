public class Book {

    private String title;           // KİTAP BAŞLIĞI--
    private String author;          // KİTAP YAZAR--
    private String isbn;            // KİTABIN BENZERSİZ ISBN NUMARASI--
    private boolean isBorrowed;     // KİTABIN ÖDÜNÇ ALINIP ALINMADIĞI BİLGİSİ--

    // KURUCU METHOD --> KİTAP NESNESİ OLUŞTURURKEN BİLGİLERİ ATANIR--
    public Book(String title, String author, String isbn) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false; // YENİ KİTAP EKLENİNCE ÖDÜNÇ ALINMAMIŞ OLARAK BAŞLAR--
    }

    public String getTitle() {
        return title; // KİTAP BAŞLIĞINI DÖNER--
    }

    public String getAuthor() {
        return author; // KİTAP YAZARINI DÖNER--
    }

    public String getIsbn() {
        return isbn; // KİTAP ISBN'İNİ DÖNER--
    }

    public boolean isBorrowed() {
        return isBorrowed; // KİTAP ÖDÜNÇTE Mİ KONTROL EDER--
    }

    public void borrowBook() {
        isBorrowed = true; // KİTAP ÖDÜNÇ ALINDI OLARAK İŞARETLER--
    }

    public void returnBook() {
        isBorrowed = false; // KİTAP İADE EDİLDİ OLARAK İŞARETLENİR--

    }
}