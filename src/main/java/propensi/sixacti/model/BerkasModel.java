package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "berkas")
public class BerkasModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Column(name = "fileName", nullable = false)
    private String fileName;

    @NotNull
    @Column(name = "data", nullable = false)
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] data;

//    @ManyToOne
//    @JoinColumn(name="idLamaran")
//    @JsonIgnore
//    private LamaranModel lamaranModel;

    public BerkasModel() {

    }

    public BerkasModel(@NotNull String fileName, @NotNull byte[] data) {
        this.fileName = fileName;
        this.data = data;
    }

//    @ManyToOne
//    @JoinColumn(name = "lamaranId")
//    @JsonIgnore
//    private LamaranModel lamaran;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lamaranId", referencedColumnName = "id")
    private LamaranModel lamaran;

    public LamaranModel getLamaran() {
        return lamaran;
    }

    public void setLamaran(LamaranModel lamaran) {
        this.lamaran = lamaran;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

//    public LamaranModel getLamaranModel() {
//        return lamaranModel;
//    }
//
//    public void setLamaranModel(LamaranModel lamaranModel) {
//        this.lamaranModel = lamaranModel;
//    }
//}
//
