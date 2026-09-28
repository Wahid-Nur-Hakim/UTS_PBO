# Sistem Penjualan Produk - Toko AlHafizh

## Nama  : Wahid Nur Hakim | NIM  : 2509116016 | Kelas  : Sistem Informasi A'25

## Deskripsi Program

<div align="justify">
Toko Al-Hafizh adalah aplikasi sistem penjualan produk berbasis Java console yang menyediakan empat kategori produk, yaitu makanan, minuman, handphone, dan aksesoris handphone. Setiap kategori memiliki atribut khusus, seperti tanggal kadaluarsa dan status halal untuk produk konsumsi, serta merek dan masa garansi untuk produk elektronik.

Program memiliki fitur CRUD lengkap untuk setiap kategori produk. Pengguna dapat menambahkan produk baru, melihat daftar produk, memperbarui data produk, dan menghapus produk. Sebelum update atau hapus, sistem menampilkan data produk terlebih dahulu. Pada proses hapus, sistem meminta konfirmasi ya atau tidak untuk mencegah penghapusan tidak sengaja.

Aplikasi juga menyediakan fitur simulasi pembelian. Pengguna dapat memilih produk, memasukkan jumlah pembelian, dan menentukan status member. Sistem akan memeriksa ketersediaan stok, menghitung total pembayaran dengan diskon sesuai jenis produk dan status member, mengurangi stok secara otomatis, serta menampilkan struk pembelian. Riwayat transaksi selama aplikasi berjalan juga disimpan dan dapat ditampilkan.

Program menerapkan konsep Object-Oriented Programming atau OOP, meliputi inheritance, polymorphism, encapsulation, constructor, dan method overloading. Struktur program menggunakan pola arsitektur Model–View–Controller atau MVC dengan package model, view, controller, dan entry point TokoAlHafizh.java.
</div>

## Fungsi dan Kegunaan Program

<div align="justify">
Program Toko Al-Hafizh berfungsi untuk mengelola data produk dan melakukan simulasi proses penjualan pada sebuah toko secara sederhana. Program membantu pengguna menyimpan serta mengatur produk berdasarkan empat kategori, yaitu makanan, minuman, handphone, dan aksesoris handphone.

Kegunaan utama program adalah:
* Menambahkan data produk baru ke dalam sistem.
* Menampilkan daftar produk yang tersedia pada setiap kategori.
* Memperbarui informasi produk, seperti nama, harga, stok, tanggal kadaluarsa, merek, garansi, dan atribut khusus lainnya.
* Menghapus data produk dengan konfirmasi ya atau tidak agar penghapusan tidak terjadi secara tidak sengaja.
* Memeriksa validitas input, seperti harga harus lebih dari nol, stok tidak boleh negatif, kode produk tidak boleh sama, dan tanggal kadaluarsa harus menggunakan format yang benar.
* Menampilkan seluruh produk dari semua kategori dalam satu menu.
* Melakukan simulasi pembelian produk.
* Memeriksa ketersediaan stok sebelum transaksi dilakukan.
* Menghitung subtotal, diskon produk, diskon member, dan total pembayaran.
* Mengurangi stok produk secara otomatis setelah pembelian berhasil.
* Menyimpan dan menampilkan riwayat transaksi selama aplikasi berjalan.

Program ini juga berguna sebagai penerapan konsep pemrograman berorientasi objek, seperti inheritance, polymorphism, encapsulation, method overriding, method overloading, percabangan, perulangan, ArrayList, validasi input, serta pola arsitektur MVC.
</div>
