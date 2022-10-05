package perpustakaan.pinjamBuku.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PinjamDTO {
    public String nomorKTP;
    public String nomorISBN;
    public LocalDate deadlinePengembalian;
  
}