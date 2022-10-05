package perpustakaan.pinjamBuku.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BukuDTO {
    public String judulBuku;
    public String noISBN;
    public Integer stok;
  
}