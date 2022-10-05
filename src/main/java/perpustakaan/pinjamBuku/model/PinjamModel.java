package perpustakaan.pinjamBuku.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pinjam")
public class PinjamModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPinjam;

    @NotNull
    @Column(name = "waktu_pinjam", nullable = false)
    private LocalDate waktuPinjam;

    @NotNull
    @Column(name = "deadline_pengembalian", nullable = false)
    private LocalDate deadlinePengambalian;

    @NotNull
    @Column(name = "waktu_pengembalian", nullable = true)
    private LocalDate waktuPengembalian;

    @NotNull
    @Column(name = "status_pengembalian", nullable = false)
    private Boolean statusPengembalian;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idPeminjam", referencedColumnName = "idPeminjam", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PeminjamModel peminjam;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idBuku", referencedColumnName = "idBuku", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BukuModel buku;

}