# Minpro-2-PBO-ManajemenProyekStartUp

Program ini dibuat menggunakan Java untuk membantu sebuah startup mencatat dan mengelola proyek-proyeknya. Program ini bisa menyimpan, menampilkan, mengubah, dan menghapus data proyek atau biasa disebut operasi CRUD (Create, Read, Update, Delete).

Program ini mengelola dua jenis proyek yang berbeda, yaitu:
- Proyek Internal: proyek yang dikerjakan untuk kebutuhan perusahaan sendiri
- Proyek Klien: proyek yang dikerjakan untuk klien/perusahaan luar

Kedua jenis proyek ini memiliki data umum yang sama (ID, nama, deadline), tetapi juga memiliki data tambahan yang berbeda sesuai kebutuhannya masing-masing.

---

## 1. Penjelasan Alur Program

### Langkah 1: Program dimulai
> <img width="400" alt="image" src="https://github.com/user-attachments/assets/e1b7f560-e365-4c74-ab1b-7773e2674b2e" />
Tampilan awal program saat pertama kali dijalankan menampilkan banner SISTEM MANAJEMEN PROYEK STARTUP, kemudian muncul menu utama dengan 5 pilihan, yaitu Tambah Proyek, Tampilkan Semua Proyek, Update Proyek, Hapus Proyek, dan Keluar. Pengguna dapat memilih menu dengan memasukkan angka pada bagian "Pilih menu:".

### Langkah 2: Program menjalankan pilihan menu
Disini pengguna diarahkan ke menu sesuai dengan angka yang dimasukkan. Setiap menu memiliki fungsi yang berbeda untuk mengelola data proyek. Berikut adalah penjelasan dari setiap menu yang tersedia pada program:

- **Menu 1: Tambah Proyek**
  > <img width="550" alt="image" src="https://github.com/user-attachments/assets/9744da08-0178-4e33-86de-82afee726ed2" />
  Pengguna pertama-tama memilih jenis proyek yaitu Internal atau Klien. Setelah itu, program meminta data satu per satu yang terdiri dari ID, nama, deadline, dan data khusus sesuai jenis proyeknya. Jika semua data valid, proyek baru dibuat dan disimpan.
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/da0f6ed9-4193-40f4-b96b-9364a6f5e073" />
  Gambar diatas merupakan tampilan semua proyek yang menunjukkan bahwa proyek berhasil ditambahkan.

- **Menu 2: Tampilkan Semua Proyek**
  > <img width="380" alt="image" src="https://github.com/user-attachments/assets/6ce7fc00-e7b3-4bf5-98b7-50c211e0fb46" />
  Program menampilkan seluruh data yang tersimpan, lengkap dengan nomor urut dan jenis proyeknya.

- **Menu 3: Update Proyek**
  > <img width="550" alt="image" src="https://github.com/user-attachments/assets/ef0b50c2-bb0d-498f-a63e-e56fa0423961" />
  Pengguna memasukkan ID proyek yang ingin diubah lalu program akan mencari proyek tersebut. Setelah ditemukan, data lama ditampilkan terlebih dahulu sebagai pembanding, kemudian pengguna diminta memasukkan data baru. Program otomatis mendeteksi apakah proyek tersebut jenis Internal atau Klien, sehingga pertanyaan yang muncul menyesuaikan.
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/610041e0-9804-47fc-9c07-1aec346f4726" />
  Gambar diatas merupakan tampilan semua proyek yang menunjukkan bahwa proyek berhasil diupdate.

- **Menu 4: Hapus Proyek**
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/b2f6d86a-237e-45f2-952c-29ebae89d447" />
  Pengguna diarahkan untuk memasukkan ID proyek yang ingin dihapus, lalu data langsung dihapus dari daftar dan program memberi konfirmasi.
  > <img width="400" alt="image" src="https://github.com/user-attachments/assets/743c96c3-cfbc-42de-ba21-f2d5ab84dab9" />
  Gambar diatas merupakan tampilan semua proyek yang menunjukkan bahwa proyek berhasil dihapus.

- **Menu 5 – Keluar**
  > <img width="550" alt="image" src="https://github.com/user-attachments/assets/e04a5ae1-9523-4c89-bca1-bdebb3fd85dc" />
  Program akan menghentikan perulangan dan menampilkan pesan penutup, kemudian `Scanner` ditutup agar program berakhir dengan baik.

### Langkah 3: Kembali ke menu
> <img width="350" alt="image" src="https://github.com/user-attachments/assets/c229be53-2fe9-4750-8ac2-07dbee9ac59d" />
  Setelah satu aksi selesai, program otomatis kembali menampilkan menu utama. Siklus ini terus berulang sampai pengguna memilih menu "Keluar".

---

## 2. Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation 
Encapsulation diterapkan dengan menyembunyikan data di dalam kelas dan hanya mengizinkan akses melalui method tertentu, bukan langsung dari luar.

Semua atribut pada kelas `Proyek` dideklarasikan sebagai `private`, sehingga tidak bisa diakses atau diubah langsung dari kelas lain:

```java
public class Proyek {
    private String idProjek;
    private String namaProjek;
    private String deadline;
    ...
}
```

Untuk membaca atau mengubah data tersebut, harus melalui method getter dan setter yang bersifat `public`. Setiap setter juga tidak langsung menyimpan data yang diberikan, melainkan memanggil kelas `Validasi` terlebih dahulu untuk memeriksa kevalidannya. Contohnya pada `setDeadline()`:

```java
public void setDeadline(String deadline) {
    if (Validasi.isDeadlineValid(deadline)) {
        this.deadline = deadline;
    } else {
        System.out.println("Format deadline tidak valid!");
    }
}
```

Jika deadline yang dimasukkan tidak sesuai format `dd-mm-yyyy`, maka nilai baru tidak akan disimpan dan data lama tetap dipertahankan. Pola yang sama juga diterapkan pada `setNamaProjek()` di `Proyek`, serta pada `setDivisiPeminta()`/`setTujuanProjek()` di `ProyekInternal` dan `setNamaKlien()`/`setJenisKebutuhan()` di `ProyekKlien`. Semuanya memvalidasi data lebih dulu sebelum benar-benar disimpan. Dengan cara ini, data proyek selalu terjaga kualitasnya dan tidak bisa diisi dengan nilai yang kosong atau salah format.

### Inheritance
Inheritance diterapkan pada relasi antar kelas model, di mana satu kelas menurunkan atribut dan method-nya ke kelas lain.

`Proyek` berperan sebagai **superclass** yang menyimpan hal-hal yang dimiliki semua jenis proyek: ID, nama, deadline, serta method umum `getJenisProjek()` dan `cetakData()`:

```java
public class Proyek {
    ...
    public String getJenisProjek() {
        return "Umum";
    }

    public void cetakData() {
        System.out.println("Jenis Projek : " + getJenisProjek());
        System.out.println("ID Proyek    : " + idProjek);
        System.out.println("Nama Proyek  : " + namaProjek);
        System.out.println("Deadline     : " + deadline);
    }
}
```

`ProyekInternal` dan `ProyekKlien` adalah **subclass** yang meng-*extend* `Proyek`. Keduanya otomatis mendapatkan seluruh atribut dan method milik `Proyek`, lalu menambahkan atribut khas miliknya sendiri. Saat atribut subclass dibuat, konstruktornya memanggil `super(idProjek, namaProjek, deadline)` untuk mengisi data umum lewat kelas induk, sehingga kode tidak perlu ditulis dua kali:

```java
// ProyekInternal.java
public class ProyekInternal extends Proyek {
    private String divisiPeminta;
    private String tujuanProjek;

    public ProyekInternal(String idProjek, String namaProjek, String deadline,
                           String divisiPeminta, String tujuanProjek) {
        super(idProjek, namaProjek, deadline);
        setDivisiPeminta(divisiPeminta);
        setTujuanProjek(tujuanProjek);
    }
}
```

```java
// ProyekKlien.java
public class ProyekKlien extends Proyek {
    private String namaKlien;
    private String jenisKebutuhan;

    public ProyekKlien(String idProjek, String namaProjek, String deadline,
                        String namaKlien, String jenisKebutuhan) {
        super(idProjek, namaProjek, deadline);
        setNamaKlien(namaKlien);
        setJenisKebutuhan(jenisKebutuhan);
    }
}
```

Dengan inheritance, penambahan jenis proyek baru menjadi lebih mudah, cukup dengan membuat subclass baru yang meng-*extend* `Proyek`.

---

## 4. Penerapan Nilai Tambah

### a. Struktur MVC (Model-View-Controller)
Program ini menerapkan struktur **MVC (Model View Controller)**, yaitu struktur yang memisahkan program menjadi tiga peran utama yaitu Data (Model), Tampilan (View), dan Pengatur Alur (Controller), ditambah satu package `main` sebagai titik masuk program. Berikut struktur package pada program ini:

```
Source Packages/
├── main/
│   └── MainApp.java          → Titik masuk program, menjalankan menu utama
│
├── controller/
│   ├── ProyekController.java → Mengatur data proyek yaitu tambah, cari, update dan hapus
│   └── Validasi.java         → Kumpulan aturan pengecekan input pengguna
│
├── model/
│   ├── Proyek.java           → Superclass, berisi data umum sebuah proyek
│   ├── ProyekInternal.java   → Subclass, khusus untuk proyek internal
│   └── ProyekKlien.java      → Subclass, khusus untuk proyek klien
│
└── view/
    └── ProyekView.java       → Menampilkan menu dan berinteraksi langsung dengan pengguna
```

Penjelasan penerapan MVC pada setiap package:

- **`model`**: Berisi kelas `Proyek`, `ProyekInternal`, dan `ProyekKlien`. Package ini merepresentasikan bagian **Model** dalam MVC, yaitu bagian yang menyimpan struktur data proyek beserta aturan validasinya. Model tidak ada hubungannya dengan tampilan menu atau logika CRUD, tugasnya murni menjaga data tetap konsisten.

- **`view`**: Berisi kelas `ProyekView`, yang merepresentasikan bagian **View** dalam MVC. Tugasnya menampilkan menu ke layar dan menerima input dari pengguna. View tidak menyimpan data sendiri, ia hanya meneruskan input pengguna ke controller dan menampilkan hasil yang diberikan controller.

- **`controller`**: Berisi kelas `ProyekController` dan `Validasi`, yang merepresentasikan bagian **Controller** dalam MVC. `ProyekController` menjadi penghubung antara `view` dan `model`, ia menerima permintaan dari view, memproses logikanya seperti menyimpan, mencari, mengubah, atau menghapus data di `model`, lalu mengembalikan hasilnya. `Validasi` mendukung controller dengan memastikan setiap input pengguna sudah benar sebelum diproses lebih lanjut.

- **`main`**: Berisi kelas `MainApp` yang menjadi titik masuk program. Kelas ini menghubungkan `view` dan `controller` lalu menjalankan siklus menu dari awal sampai program ditutup.

Dengan pembagian ini, setiap bagian program bisa dikembangkan atau diperbaiki secara terpisah. Misalnya, jika tampilan menu ingin diubah, cukup edit file di `view` — tanpa perlu menyentuh logika penyimpanan data di `model` atau `controller`. Hal ini membuat program lebih rapi, mudah dibaca, dan mudah dikembangkan lebih lanjut di kemudian hari.

### b. Polymorphism (Method Overriding)
Polymorphism artinya method dengan nama yang sama bisa memberikan hasil berbeda tergantung objek yang memanggilnya. Dalam program ini, polymorphism diterapkan lewat **method overriding** pada method `getJenisProjek()` dan `cetakData()`.

Di kelas induk `Proyek`, kedua method ini didefinisikan secara umum:

```java
// Proyek.java
public String getJenisProjek() {
    return "Umum";
}

public void cetakData() {
    System.out.println("Jenis Projek : " + getJenisProjek());
    System.out.println("ID Proyek    : " + idProjek);
    System.out.println("Nama Proyek  : " + namaProjek);
    System.out.println("Deadline     : " + deadline);
}
```

Kedua method tersebut kemudian ditulis ulang (di-*override*) oleh `ProyekInternal`:

```java
// ProyekInternal.java
@Override
public String getJenisProjek() {
    return "Internal";
}

@Override
public void cetakData() {
    super.cetakData();
    System.out.println("Divisi Peminta : " + divisiPeminta);
    System.out.println("Tujuan Proyek  : " + tujuanProjek);
}
```

dan juga oleh `ProyekKlien`, dengan isi yang berbeda sesuai kebutuhannya:

```java
// ProyekKlien.java
@Override
public String getJenisProjek() {
    return "Klien";
}

@Override
public void cetakData() {
    super.cetakData();
    System.out.println("Nama Klien      : " + namaKlien);
    System.out.println("Jenis Kebutuhan : " + jenisKebutuhan);
}
```

Pada `cetakData()` di kedua subclass, program tetap memanggil `super.cetakData()` terlebih dahulu (agar data umum tetap tercetak), lalu menambahkan baris cetak untuk atribut khususnya sendiri, sehingga kode tidak diulang percuma.

Penerapan paling terlihat ada di `ProyekController`: seluruh proyek — baik Internal maupun Klien — disimpan bersama dalam satu wadah `ArrayList<Proyek>`. Ketika program memanggil `p.cetakData()` untuk setiap item dalam daftar, Java secara otomatis menjalankan versi `cetakData()` milik `ProyekInternal` atau `ProyekKlien`, sesuai jenis objek yang sebenarnya — bukan berdasarkan tipe `Proyek` yang tertulis di deklarasi. Inilah yang disebut *polymorphism saat runtime*.
