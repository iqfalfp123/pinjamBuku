package perpustakaan.pinjamBuku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perpustakaan.pinjamBuku.DTO.PeminjamDTO;
import perpustakaan.pinjamBuku.DTO.PinjamDTO;
import perpustakaan.pinjamBuku.DTO.PinjamNewDataDTO;
import perpustakaan.pinjamBuku.model.BukuModel;
import perpustakaan.pinjamBuku.model.PeminjamModel;
import perpustakaan.pinjamBuku.model.PinjamModel;
import perpustakaan.pinjamBuku.repository.BukuDb;
import perpustakaan.pinjamBuku.repository.PeminjamDb;
import perpustakaan.pinjamBuku.repository.PinjamDb;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Transactional
public class PinjamServiceImpl implements PinjamService{
    @Autowired
    PeminjamDb peminjamDb;
    @Autowired
    PinjamDb pinjamDb;
    @Autowired
    BukuDb bukuDb;
    @Override
    public String addPinjam(PinjamDTO pinjamDTO) {
        PeminjamModel peminjam = peminjamDb.findByNoKTP(pinjamDTO.nomorKTP);
        BukuModel buku = bukuDb.findByNoISBN(pinjamDTO.nomorISBN);
        String response ="";
        long daysBetween = DAYS.between(LocalDate.now(), pinjamDTO.getDeadlinePengembalian());
        if (buku == null){
            response = "buku tidak tersedia";
        } else if (peminjam == null) {
            response = "data peminjam belum ada pada database";
        } else if (buku.getStok() == 0) {
            response = "stok buku habis";
        } else if (peminjam.getStatusPinjam() == true) {
            response = "Peminjam sedang melakukan peminjaman buku";
        }else if(daysBetween > 30){
                response = "Peminjam tidak boleh meminjam buku lebih lama dari 30 (tiga puluh) hari";
        }else if(pinjamDTO.getDeadlinePengembalian().isBefore(LocalDate.now())){
            response = "Masukkan deadline pengembalian buku yang valid!";
        }
        else{
            PinjamModel pinjam = new PinjamModel();
            pinjam.setPeminjam(peminjam);
            pinjam.setWaktuPinjam(LocalDate.now());
            pinjam.setBuku(buku);
            pinjam.setStatusPengembalian(false);
            pinjam.setWaktuPengembalian(LocalDate.now());
            pinjam.setDeadlinePengambalian(pinjamDTO.getDeadlinePengembalian());
            buku.setStok(buku.getStok() - 1);
            peminjam.setStatusPinjam(true);
            pinjamDb.save(pinjam);
            response = "peminjaman buku " + buku.getJudulBuku() + " berhasil";
        }
        return response;
    }
    @Override
    public String kembalikanPinjaman(PinjamDTO pinjamDTO) {
        String response = "";
        String status= "";
        PeminjamModel peminjam = peminjamDb.findByNoKTP(pinjamDTO.nomorKTP);
        BukuModel buku = bukuDb.findByNoISBN(pinjamDTO.nomorISBN);
        if (peminjam == null) {
            response = "Data peminjam tidak valid";
        } else if (buku == null) {
            response = "Data buku tidak valid";
        } else {
            PinjamModel pinjam = pinjamDb.findByIdPeminjamAndIdBuku(peminjam.getIdPeminjam(), buku.getIdBuku());
            if (pinjam == null) {
                response = "Peminjam belum meminjam buku";
            } else {
                pinjam.setStatusPengembalian(true);
                pinjam.setWaktuPengembalian(LocalDate.now());
                peminjam.setStatusPinjam(false);
                buku.setStok(buku.getStok() + 1);
                pinjamDb.save(pinjam);

                if (pinjam.getWaktuPengembalian().isAfter(pinjam.getDeadlinePengambalian())) {
                    long daysBetween = DAYS.between(pinjam.getDeadlinePengambalian(), pinjam.getWaktuPengembalian());
                    status = " telat selama " + daysBetween + " hari";
                } else {
                    status = " tepat waktu";
                }
                response = peminjam.getNamaPeminjam() + " berhasil mengembalikan buku dengan judul "
                        + buku.getJudulBuku() + status;
            }
        }
        return response;
    }
    public String addPinjamNewPeminjam(PinjamNewDataDTO pinjam) {
        PeminjamModel peminjam = new PeminjamModel();
        if(peminjamDb.findByNoKTP(pinjam.getNomorKTP()) == null) {
            peminjam.setNamaPeminjam(pinjam.getNamaPeminjam());
            peminjam.setNoKTP(pinjam.getNomorKTP());
            peminjam.setEmail(pinjam.getEmail());
            peminjam.setStatusPinjam(false);
        }
        else {
            peminjam = peminjamDb.findByNoKTP(pinjam.getNomorKTP());
        }
        BukuModel buku = bukuDb.findByNoISBN(pinjam.getNomorISBN());
        String response ="";
        long daysBetween = DAYS.between(LocalDate.now(), pinjam.getDeadlinePengembalian());
        if (buku == null){
            response = "buku tidak tersedia";
        }else if (buku.getStok() == 0) {
            response = "stok buku habis";
        }else if (peminjam.getStatusPinjam() == true) {
            response = "Peminjam sedang melakukan peminjaman buku";
        }else if(daysBetween > 30){
            response = "Peminjam tidak boleh meminjam buku lebih lama dari 30 (tiga puluh) hari";
        }else if(pinjam.getDeadlinePengembalian().isBefore(LocalDate.now())){
            response = "Masukkan deadline pengembalian buku yang valid!";
        }
        else{
            peminjamDb.save(peminjam);
            PinjamModel newPinjam = new PinjamModel();
            newPinjam.setPeminjam(peminjam);
            newPinjam.setWaktuPinjam(LocalDate.now());
            newPinjam.setBuku(buku);
            newPinjam.setStatusPengembalian(false);
            newPinjam.setWaktuPengembalian(LocalDate.now());
            newPinjam.setDeadlinePengambalian(pinjam.getDeadlinePengembalian());
            buku.setStok(buku.getStok() - 1);
            peminjam.setStatusPinjam(true);
            pinjamDb.save(newPinjam);
            response = "peminjaman buku " + buku.getJudulBuku() + " berhasil";
        }
        return response;
    }
}
