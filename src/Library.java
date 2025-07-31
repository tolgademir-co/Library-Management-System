import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    private ArrayList<Book> books; // KİTAPLARI TUTAN LİSTE--

    public Library() {
        books = new ArrayList<Book>(); // BAŞLANGIÇTA BOŞ KİTAP LİSTESİ--
    }

    public void addBook(Book book) {
        books.add(book); // LİSTEYE KİTAP EKLER--
        System.out.println("Kitap Başarıyla Eklendi!!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Kütüphane Boş!!");
        } else {
            for (Book book : books) {
                System.out.println("Başlık: " + book.getTitle() +
                        " | Yazar: " + book.getAuthor() +
                        " | ISBN: " + book.getIsbn() +
                        " | Durum: " + (book.isBorrowed() ? "Ödünç Alındı" : "Musait"));
            }
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { // BAŞLIĞA GÖRE ARAMA 'BÜYÜK & KÜÇÜK HARFE DUYARSIZ'--
                System.out.println("Bulundu: " + book.getTitle() +
                        " | Yazar: " + book.getAuthor() +
                        " | ISBN: " + book.getIsbn());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Bu Başlığa Sahip Kitap Bulunamadı!!");
        }
    }

    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) { // ISBN İLE EŞLEŞEN KİTAPLAR--
                if (book.isBorrowed()) {
                    System.out.println("Bu Kitap zaten Ödünç Alınmış!!");
                } else {
                    book.borrowBook(); // KİTABI ÖDÜNÇ AL--
                    System.out.println("Kitap Başarıyla Ödünç Alındı!!");
                }
                return;
            }
        }
        System.out.println("Bu ISBN Numarasına Sahip Kitap Bulunamadı!!");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isBorrowed()) {
                    System.out.println("Bu Kitap zaten Kütüphanede!!");
                } else {
                    book.returnBook(); // KİTABI İADE ET--
                    System.out.println("Kitap İade Edildi!!");
                }
                return;
            }
        }
        System.out.println("Bu ISBN Numarasına Sahip Kitap Bulunamadı!!");
    }

    public boolean isBookExixsts(String title) {
        for (Book book : books) { // KİTAP LİSTESİNDEKİ HER KİTABI GEZER--
            if (book.getTitle().equalsIgnoreCase(title)) { // KİTAP İSMİ EŞLEŞİYORSA 'BÜYÜK & KÜÇÜK HARFE DUYARSIZ'--
                return true; // KİTAP ZATEN VAR--
            }
        }
        return false; // KİTAP YOK--

    }
}
