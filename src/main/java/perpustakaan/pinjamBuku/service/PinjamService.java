package perpustakaan.pinjamBuku.service;

import perpustakaan.pinjamBuku.DTO.PinjamDTO;
import perpustakaan.pinjamBuku.DTO.PinjamNewDataDTO;
import perpustakaan.pinjamBuku.model.PinjamModel;

public interface PinjamService {
    String addPinjam(PinjamDTO pinjamDTO);
    String kembalikanPinjaman(PinjamDTO pinjam);
    String addPinjamNewPeminjam(PinjamNewDataDTO pinjam);
}