package perpustakaan.pinjamBuku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perpustakaan.pinjamBuku.model.PeminjamModel;
import perpustakaan.pinjamBuku.model.PinjamModel;

@Repository
public interface PinjamDb extends JpaRepository<PinjamModel, Long> {
    @Query(value = "select * from pinjam where id_peminjam= :idPeminjam and id_buku= :idBuku and status_pengembalian = 0 order by id_pinjam desc LIMIT 1", nativeQuery = true)
PinjamModel findByIdPeminjamAndIdBuku(@Param("idPeminjam") Long idPeminjam, @Param("idBuku") Long idBuku);
}
