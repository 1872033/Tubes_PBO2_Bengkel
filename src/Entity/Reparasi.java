package Entity;

import java.util.Date;

public class Reparasi {
    private int idReparasi;
    private String tglreparasi;
    private String jenisreparasi;
    private String idKendaraan;
    private String NamaPemilik;

    public String getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(String idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getNamaPemilik() {
        return NamaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        NamaPemilik = namaPemilik;
    }

    public Reparasi(int idReparasi, String tglreparasi, String jenisreparasi, String idKendaraan, String NamaPemilik){
        this.setIdReparasi(idReparasi);
        this.setTglreparasi(tglreparasi);
        this.setJenisreparasi(jenisreparasi);
        this.setIdKendaraan(idKendaraan);
        this.setNamaPemilik(NamaPemilik);

    }

    public int getIdReparasi() {
        return idReparasi;
    }

    public void setIdReparasi(int idReparasi) {
        this.idReparasi = idReparasi;
    }

    public String getTglreparasi() {
        return tglreparasi;
    }

    public void setTglreparasi(String tglreparasi) {
        this.tglreparasi = tglreparasi;
    }



    public String getJenisreparasi() {
        return jenisreparasi;
    }

    public void setJenisreparasi(String jenisreparasi) {
        this.jenisreparasi = jenisreparasi;
    }


    @Override
    public String toString() {
        return
                "id=" + idReparasi ;
    }
}
