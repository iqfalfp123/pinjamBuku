package perpustakaan.pinjamBuku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perpustakaan.pinjamBuku.DTO.BukuDTO;
import perpustakaan.pinjamBuku.model.BukuModel;
import perpustakaan.pinjamBuku.repository.BukuDb;

import javax.transaction.Transactional;

@Service
@Transactional
public class BukuServiceImpl implements BukuService{
    @Autowired
    BukuDb bukuDb;
    @Override
    public BukuModel addBuku(BukuDTO bukuDTO){
        BukuModel buku = new BukuModel();
        buku.setJudulBuku(bukuDTO.getJudulBuku());
        buku.setNoISBN(bukuDTO.getNoISBN());
        buku.setStok(bukuDTO.getStok());
        return bukuDb.save(buku);
    }

    @Override
    public BukuModel updateBuku(BukuDTO bukuDTO){
        BukuModel buku = bukuDb.findByNoISBN(bukuDTO.getNoISBN());
        if(bukuDTO.getJudulBuku() != null){
            buku.setJudulBuku(bukuDTO.getJudulBuku());
        }
        if(bukuDTO.getStok() != null) {
            buku.setStok(bukuDTO.getStok());
        }
        return bukuDb.save(buku);
    }
}
