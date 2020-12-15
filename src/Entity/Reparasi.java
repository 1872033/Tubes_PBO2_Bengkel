package Entity;

import java.util.Date;

public class Reparasi {
    private int idReparasi;
    private Date tglreparasi;
    private String noplat;
    private String jenisreparasi;
    private Kendaraan idKendaraan;

    public int getIdReparasi() {
        return idReparasi;
    }

    public void setIdReparasi(int idReparasi) {
        this.idReparasi = idReparasi;
    }

    public Date getTglreparasi() {
        return tglreparasi;
    }

    public void setTglreparasi(Date tglreparasi) {
        this.tglreparasi = tglreparasi;
    }

    public String getNoplat() {
        return noplat;
    }

    public void setNoplat(String noplat) {
        this.noplat = noplat;
    }

    public String getJenisreparasi() {
        return jenisreparasi;
    }

    public void setJenisreparasi(String jenisreparasi) {
        this.jenisreparasi = jenisreparasi;
    }

    public Kendaraan getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Kendaraan idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    @Override
    public String toString() {
        return "Reparasi{" +
                "tglreparasi=" + tglreparasi +
                ", noplat='" + noplat + '\'' +
                ", jenisreparasi='" + jenisreparasi + '\'' +
                '}';
    }
}
