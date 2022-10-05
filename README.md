API untuk menambahkan data buku
**URL**: http://localhost:8080/api/perpustakaan/add-buku
**METHOD**: POST
**JSON FORMAT**:
{
    "judulBuku": "Madilog",
    "noISBN": "112234KJ9443N",
    "stok": 100
    }
 
API untuk update data buku
**URL**: http://localhost:8080/api/perpustakaan/update-data-buku
**METHOD**: PUT
**JSON FORMAT**:
{
    "judulBuku": "Madilog", //optional
    "noISBN": "112234KJ9443N",
    "stok": 50 //optional
    }
Asumsi: nomor ISBN hanya dapat diupdate langsung melalui database

API untuk menambahkan data peminjam
**URL**: http://localhost:8080/api/perpustakaan/add-peminjam
**METHOD**: POST
**JSON FORMAT**:
{
    "namaPeminjam" : "Fazrial",
    "noKTP": "00002677488282",
    "email": "fazrial12@gmail.com" 
}
API untuk update data peminjam
**URL**: http://localhost:8080/api/perpustakaan/update-data-peminjam
**METHOD**: PUT
**JSON FORMAT**:
{
    "namaPeminjam" : "Fazrial", //optional
    "noKTP": "00002677488282",
    "email": "fazrial12345@gmail.com"  //optional
}
Asumsi: nomor KTP hanya dapat diupdate langsung melalui database

API untuk meminjam buku dengan kondisi data peminjam sudah terdaftar
**URL**: http://localhost:8080/api/perpustakaan/pinjam-buku
**METHOD**: POST
**JSON FORMAT**:
 
{
    "nomorKTP": "00002677488282",
    "nomorISBN": "112234KJ9443N",
    "deadlinePengembalian": "2022-10-09"
}
 
API untuk meminjam buku dengan kondisi data peminjam belum terdaftar
**URL**: http://localhost:8080/api/perpustakaan/pinjam-buku/new-data-peminjam
**METHOD**: POST
**JSON FORMAT**:
{
    "namaPeminjam": "Pramudya",
    "nomorKTP": "00002677488290",
    "email": "pramudya@gmail.com",
    "nomorISBN": "112234KJ9443N",
    "deadlinePengembalian": "2022-11-03"
}
 
API untuk mengembalikan buku yang telah dipinjam oleh peminjam
**URL**: http://localhost:8080/api/perpustakaan/kembalikan-buku
**METHOD**: POST
**JSON FORMAT**:
{
    "nomorKTP": "00002677488290",
    "nomorISBN": "112234KJ9443N"
}

