package apap.uts.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table
public class PustakawanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nip", nullable = false, unique = true, length = 16)
    private String nip;

    @NotNull
    @Column(name="nama", nullable = false, length = 50)
    private String nama;

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenisKelamin;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_lahir", nullable = false, columnDefinition = "DATE")
    private Date tanggalLahir;

    @NotNull
    @Column(name="alamat", nullable = false, length = 100)
    private String alamat;

    @NotNull
    @Column(name="no_hp", nullable = false, length = 20)
    private String noHp;

    @NotNull
    @Column(name="spesialisasi", nullable = false, length = 20)
    private String spesialisasi;

    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    public String toStringJenisKelamin(){
        if(jenisKelamin == 1) return "laki-laki";
        else if(jenisKelamin == 2) return "perempuan";
        return "undefined";
    }

    public String toStringStatus(){
        if(status == 1) return "full-time";
        else if(status == 2) return "part-time";
        return "undefined";
    }

    public String toStringTanggalLahir() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        cal.setTime(getTanggalLahir());
        String year = String.format("%04d", cal.get(Calendar.YEAR));
        String month = String.format("%02d", cal.get(Calendar.MONTH)+1);
        String day = String.format("%02d",cal.get(Calendar.DAY_OF_MONTH));

        return year+"-"+month+"-"+day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}