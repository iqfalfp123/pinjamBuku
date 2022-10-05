package perpustakaan.pinjamBuku.service;

import perpustakaan.pinjamBuku.DTO.BukuDTO;
import perpustakaan.pinjamBuku.model.BukuModel;

public interface BukuService {
    BukuModel addBuku(BukuDTO bukuDTO);
    BukuModel updateBuku(BukuDTO pinjam);

}