package Entity;

public class Reparasi {
    private int idReparasi;
    private String tglreparasi;
    private String jenisreparasi;
    private Kendaraan idKendaraan;
    private User idPemilik;

    public Reparasi() {

    }

    public User getIdPemilik() {
        return idPemilik;
    }

    public void setIdPemilik(User idPemilik) {
        this.idPemilik = idPemilik;
    }

    public Kendaraan getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(Kendaraan idKendaraan) {
        this.idKendaraan = idKendaraan;
    }


    public Reparasi(int idReparasi, String tglreparasi, String jenisreparasi, Kendaraan idKendaraan ,User idPemilik){
        this.setIdReparasi(idReparasi);
        this.setTglreparasi(tglreparasi);
        this.setJenisreparasi(jenisreparasi);
        this.setIdKendaraan(idKendaraan);
        this.setIdPemilik(idPemilik);

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
