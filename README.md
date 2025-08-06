# 📚 Kütüphane Yönetim Sistemi – Java Konsol Uygulaması

Bu proje, Java dili kullanılarak geliştirilen temel bir **Kütüphane Yönetim Sistemi** uygulamasıdır. Konsol tabanlı bu sistem ile kullanıcı kitap ekleyebilir, görüntüleyebilir, arayabilir, ödünç alabilir ve iade işlemlerini gerçekleştirebilir.

---

## 👨‍💻 Geliştirici
Bu proje bir Java Backend Developer patika.dev öğrencisi tarafından nesne tabanlı programlama temellerini 
öğrenmek ve pratik yapmak amacıyla geliştirilmiştir.

---

## 🎯 Amaç

- Nesne tabanlı programlamayı (OOP) pekiştirmek
- ArrayList, sınıflar ve metotları kullanarak modüler yapı kurmak
- Kullanıcı etkileşimi ve hata yönetimi konularını öğrenmek
- Renkli terminal çıktıları ile kullanıcı deneyimini geliştirmek

---

## 🧩 Proje Yapısı

### `Book.java`

- Kitap nesnesini temsil eder
- Özellikler:
    - `title`, `author`, `isbn`, `isBorrowed`
- Metotlar:
    - `borrowBook()`, `returnBook()`
    - Getter'lar

***

### `Library.java`

- Kitap listesini (`ArrayList<Book>`) tutar
- Tüm işlem mantığını içerir
- Özellikler:
    - Kitap ekleme
    - Kitap listeleme
    - Başlığa göre arama (kısmi eşleşme)
    - ISBN ile ödünç alma ve iade etme
- Renkli terminal çıktısı desteği (ANSI kodları)

---

### `Main.java`

- Ana menü ve kullanıcı arayüzü
- `Scanner` ile kullanıcıdan seçim alınır
- `try-catch` ile geçersiz giriş kontrolü yapılır
- Döngü ile kullanıcıya sürekli işlem yapma imkânı sağlanır

---

## 📌 Özellikler

- [x] Kitap ekleme
- [x] Tüm kitapları listeleme
- [x] Kitap başlığına göre arama
- [x] ISBN ile kitap ödünç alma
- [x] ISBN ile kitap iade etme
- [x] Renkli konsol çıktısı (başarılı/başarısız işlem farkı)

---

## 🧪 Kullanım Talimatları

1. Projeyi bir Java IDE (IntelliJ, Eclipse vb.) ile açın veya terminalde derleyin.
2. `Main.java` dosyasını çalıştırın.
3. Konsoldaki menüden işlem seçin.

```bash
javac Main.java
java Main
