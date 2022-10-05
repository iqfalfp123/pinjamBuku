package perpustakaan.pinjamBuku.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "buku")
public class BukuModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuku;

    @NotNull
    @Column(name = "judul_buku", nullable = false)
    private String judulBuku;

    @NotNull
    @Column(name = "nomor_ISBN", nullable = false, unique = true)
    private String noISBN;

    @NotNull
    @Column(name = "stok")
    private int stok;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "buku")
    private List<PinjamModel> listPinjam;
}