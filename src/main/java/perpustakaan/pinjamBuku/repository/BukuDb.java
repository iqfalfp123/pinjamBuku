package perpustakaan.pinjamBuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perpustakaan.pinjamBuku.model.BukuModel;
import perpustakaan.pinjamBuku.model.PeminjamModel;

@Repository
public interface BukuDb extends JpaRepository<BukuModel, Long> {
BukuModel findByNoISBN(String noISBN);
}
