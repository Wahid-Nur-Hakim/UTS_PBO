# Sistem Penjualan Produk - Toko AlHafizh

## Nama  : Wahid Nur Hakim | NIM  : 2509116016 | Kelas  : Sistem Informasi A'25

## Deskripsi Program

<div align="justify">

Toko Al-Hafizh adalah aplikasi sistem penjualan produk berbasis Java console yang menyediakan empat kategori produk, yaitu makanan, minuman, handphone, dan aksesoris handphone. Setiap kategori memiliki atribut khusus, seperti tanggal kadaluarsa dan status halal untuk produk konsumsi, serta merek dan masa garansi untuk produk elektronik.
  
Program memiliki fitur CRUD lengkap untuk setiap kategori produk. Pengguna dapat menambahkan produk baru, melihat daftar produk, memperbarui data produk, dan menghapus produk. Sebelum update atau hapus, sistem menampilkan data produk terlebih dahulu. Pada proses hapus, sistem meminta konfirmasi ya atau tidak untuk mencegah penghapusan tidak sengaja.

Aplikasi juga menyediakan fitur simulasi pembelian. Pengguna dapat memilih produk, memasukkan jumlah pembelian, dan menentukan status member. Sistem akan memeriksa ketersediaan stok, menghitung total pembayaran dengan diskon sesuai jenis produk dan status member, mengurangi stok secara otomatis, serta menampilkan struk pembelian. Riwayat transaksi selama aplikasi berjalan juga disimpan dan dapat ditampilkan.

Program menerapkan konsep Object-Oriented Programming atau OOP, meliputi inheritance, polymorphism, encapsulation, constructor, dan method overloading. Struktur program menggunakan pola arsitektur Model–View–Controller atau MVC dengan package model, view, controller, dan entry point TokoAlHafizh.

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

## Alur Program

<div align="justify">
  
Program dimulai dengan menampilkan menu utama kepada pengguna. Pengguna dapat memilih fitur untuk mengelola makanan, minuman, handphone, aksesoris handphone, melihat seluruh produk, atau melakukan simulasi pembelian.

Jika pengguna memilih salah satu kategori produk, sistem menampilkan menu CRUD yang terdiri dari tambah, lihat, update, hapus, dan kembali. Pada proses tambah, pengguna memasukkan data produk sesuai kategori. Sistem melakukan validasi, seperti memastikan kode produk belum digunakan, harga lebih dari nol, stok tidak negatif, dan format tanggal kadaluarsa benar.

Pada proses lihat, sistem menampilkan data produk dalam bentuk tabel. Pada proses update, sistem menampilkan daftar dan detail produk terlebih dahulu sebelum pengguna mengubah data. Pengguna juga dapat menekan Enter untuk mempertahankan data lama. Pada proses hapus, sistem menampilkan produk yang akan dihapus dan meminta konfirmasi ya atau tidak.

Pada simulasi pembelian, pengguna memilih kategori produk, memilih produk, memasukkan jumlah pembelian, dan menentukan status member. Sistem memeriksa stok, menghitung harga, menerapkan diskon sesuai jenis produk dan status member, mengurangi stok setelah transaksi berhasil, serta menampilkan struk dan riwayat transaksi.

Program menggunakan perulangan sehingga pengguna dapat kembali ke menu utama dan memakai fitur lain sampai memilih menu keluar.

</div>

## Tampilan Alur Program

**1. Menu Utama**\

<div align="justify">
Gambar ini menunjukkan tampilan awal aplikasi Toko Al-Hafizh. Pada menu utama, pengguna dapat memilih untuk mengelola makanan, minuman, handphone, aksesoris handphone, menampilkan seluruh produk, melakukan simulasi pembelian, atau keluar dari program.
</div>

**2. Sub Menu Kategori Produk**\

<div align="justify">
Submenu setelah pengguna memilih salah satu kategori produk. Pada submenu tersedia pilihan untuk menambah produk, melihat data produk, memperbarui data produk, menghapus data produk, atau kembali ke menu utama.
</div>

**3. Tambah produk**\

<div align="justify">
Proses penambahan data produk baru, pengguna memasukkan data produk sesuai kategori yang dipilih, seperti kode produk, nama produk, harga, stok, dan atribut khusus lainnya. Setelah data valid, sistem menyimpan produk ke dalam daftar produk.
</div>

**4. Lihat Data Produk**\

<div align="justify">
Menunjukkan daftar produk yang tersimpan pada sistem. Data produk ditampilkan dalam bentuk tabel agar informasi seperti kode produk, nama, harga, stok, dan atribut khusus produk dapat dilihat dengan rapi.
</div>

**5. Update Produk**\

<div align="justify">
Proses pembaruan data produk, sistem menampilkan daftar produk terlebih dahulu, kemudian pengguna memilih nomor produk yang ingin diperbarui. Pengguna dapat memasukkan nilai baru atau menekan Enter untuk mempertahankan nilai lama.
</div>

**6. Hapus Produk**\

<div align="justify">
Proses penghapusan data produk, sistem menampilkan daftar produk dan detail produk yang dipilih, kemudian meminta konfirmasi ya atau tidak. Jika pengguna memilih ya, data produk dihapus. Jika pengguna memilih tidak, penghapusan dibatalkan.
</div>

**7. Tampilan Seluruh Produk**\

<div align="justify">
Fitur untuk menampilkan seluruh produk Toko Al-Hafizh. Sistem menampilkan produk makanan, minuman, handphone, dan aksesoris handphone secara berurutan dalam satu tampilan.
</div>
 
**8. Simulasi Pembelian**\

<div align="justify">
Proses pemilihan produk pada simulasi pembelian, pengguna memilih kategori produk, menentukan produk yang ingin dibeli, memasukkan jumlah pembelian, dan memilih status member atau bukan member.
</div>

**9. Struk Pembelian**\

<div align="justify">
Gambar di atas menunjukkan hasil transaksi pembelian. Struk menampilkan jenis produk, nama produk, jumlah pembelian, harga satuan, subtotal, status member, jumlah diskon, dan total pembayaran. Setelah transaksi berhasil, stok produk berkurang sesuai jumlah pembelian.
</div>

**10. Riwayat Transaksi**\

<div align="justify">
Gambar ini menunjukkan daftar riwayat transaksi yang dilakukan selama program berjalan. Riwayat transaksi berisi nama produk, kode produk, jumlah pembelian, dan total pembayaran dari setiap transaksi.
</div>

**11. Validasi Input**\
* Validasi pilihan menu

<div align="justify">
Sistem memastikan pengguna memasukkan angka sesuai batas menu yang tersedia. Jika pengguna memasukkan huruf atau nomor yang tidak tersedia, sistem menampilkan pesan kesalahan dan meminta input ulang.
</div>

* Validasi input data produk

<div align="justify">
Sistem memastikan bahwa data wajib tidak kosong, harga harus lebih dari nol, dan stok tidak boleh bernilai negatif. Jika data tidak sesuai, pengguna diminta memasukkan ulang data yang benar.
</div>

* Validasi kode produk dan tanggal kadaluarsa

<div align="justify">
Gambar ini menunjukkan validasi kode produk dan tanggal kadaluarsa. Sistem memastikan setiap produk memiliki kode yang unik. Sistem juga memastikan tanggal kadaluarsa menggunakan format YYYY-MM-DD serta merupakan tanggal yang valid.
</div>

* Validasi konfirmasi hapus

<div align="justify">
Sistem hanya menerima jawaban ya atau tidak. Jawaban ya digunakan untuk melanjutkan penghapusan, sedangkan jawaban tidak digunakan untuk membatalkan proses hapus.
</div>

* Validasi jumlah pembelian dan stok

<div align="justify">
Gambar ini menunjukkan validasi stok saat transaksi pembelian. Sistem membandingkan jumlah produk yang ingin dibeli dengan stok yang tersedia. Jika jumlah pembelian lebih besar daripada stok, transaksi dibatalkan dan stok tidak akan berkurang.
</div>
