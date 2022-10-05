package perpustakaan.pinjamBuku.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PinjamNewDataDTO {
    public String namaPeminjam;
    public String nomorKTP;
    public String email;
    public String namaBuku;
    public String nomorISBN;
    public LocalDate deadlinePengembalian;
  
}