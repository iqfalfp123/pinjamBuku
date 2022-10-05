package perpustakaan.pinjamBuku.service;

import perpustakaan.pinjamBuku.DTO.PinjamDTO;
import perpustakaan.pinjamBuku.model.PinjamModel;

public interface PinjamService {
    String addPinjam(PinjamDTO pinjamDTO);
    String kembalikanPinjaman(PinjamDTO pinjam);

}