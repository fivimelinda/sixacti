package propensi.sixacti.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "kk")
public class KkModel implements Serializable {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lamaranId", referencedColumnName = "id")
    @JsonIgnore
    private LamaranModel lamaran;

    public KkModel (){

    }

    public KkModel(@NotNull String fileName, @NotNull byte[] data) {
        this.fileName = fileName;
        this.data = data;
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

    public LamaranModel getLamaran() {
        return lamaran;
    }

    public void setLamaran(LamaranModel lamaran) {
        this.lamaran = lamaran;
    }
}
