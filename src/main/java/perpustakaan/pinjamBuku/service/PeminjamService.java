package perpustakaan.pinjamBuku.service;

import perpustakaan.pinjamBuku.DTO.PeminjamDTO;
import perpustakaan.pinjamBuku.model.PeminjamModel;

public interface PeminjamService {
    PeminjamModel addPeminjam(PeminjamDTO peminjamDTO);
    PeminjamModel updatePeminjam(PeminjamDTO peminjamDTO);

}