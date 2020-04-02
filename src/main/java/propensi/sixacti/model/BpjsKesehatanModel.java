package propensi.sixacti.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "bpjsKesehatan")
public class BpjsKesehatanModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @Column(name = "fileName", nullable = false)
    private String fileName;

    @NotNull
    @Column(name = "data", nullable = false)
    @Lob
    private byte[] data;

    public BpjsKesehatanModel(){
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lamaranId", referencedColumnName = "id")
    private LamaranModel lamaran;

    public BpjsKesehatanModel(@NotNull String fileName, @NotNull byte[] data) {
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