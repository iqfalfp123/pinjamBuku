package perpustakaan.pinjamBuku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perpustakaan.pinjamBuku.DTO.BukuDTO;
import perpustakaan.pinjamBuku.DTO.PeminjamDTO;
import perpustakaan.pinjamBuku.model.BukuModel;
import perpustakaan.pinjamBuku.model.PeminjamModel;
import perpustakaan.pinjamBuku.repository.PeminjamDb;

import javax.transaction.Transactional;

@Service
@Transactional
public class PeminjamServiceImpl implements PeminjamService{
    @Autowired
    PeminjamDb peminjamDb;
    @Override
    public PeminjamModel addPeminjam(PeminjamDTO peminjamDTO){
        PeminjamModel peminjam = new PeminjamModel();
        peminjam.setNamaPeminjam(peminjamDTO.getNamaPeminjam());
        peminjam.setNoKTP(peminjamDTO.getNoKTP());
        peminjam.setEmail(peminjamDTO.getEmail());
        peminjam.setStatusPinjam(false);
        return peminjamDb.save(peminjam);
    }
    @Override
    public PeminjamModel updatePeminjam(PeminjamDTO peminjamDTO){
        PeminjamModel peminjam = peminjamDb.findByNoKTP(peminjamDTO.getNoKTP());
        if(peminjamDTO.getNamaPeminjam() != null){
            peminjam.setNamaPeminjam(peminjamDTO.getNamaPeminjam());
        }
        if(peminjamDTO.getEmail() != null) {
            peminjam.setEmail(peminjamDTO.getEmail());
        }
        return peminjamDb.save(peminjam);
    }
}
