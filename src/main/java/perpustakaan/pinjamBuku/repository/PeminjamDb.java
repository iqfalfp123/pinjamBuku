package perpustakaan.pinjamBuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import perpustakaan.pinjamBuku.model.PeminjamModel;

import java.util.List;

@Repository
public interface PeminjamDb extends JpaRepository<PeminjamModel, Long> {
PeminjamModel findByNoKTP(String noKTP);
}
