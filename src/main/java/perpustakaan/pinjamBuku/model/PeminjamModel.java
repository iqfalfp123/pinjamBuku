package perpustakaan.pinjamBuku.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "peminjam")
public class PeminjamModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeminjam;

    @NotNull
    @Column(name = "nama_Peminjam", nullable = false)
    private String namaPeminjam;

    @NotNull
    @Size(max = 16)
    @Column(name = "nomor_KTP", nullable = false, unique = true)
    private String noKTP;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "status_pinjam", nullable = false)
    private Boolean statusPinjam;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "peminjam")
    private List<PinjamModel> listPinjam;
}