package Entity;

import java.util.Date;

public class Reparasi {
    private int idReparasi;
    private Date tglreparasi;
    private String jenisreparasi;
    private Kendaraan idKendaraan;
    private User idUser;

    public Reparasi(int idReparasi,Date tglreparasi,String jenisreparasi,Kendaraan idKendaraan,User idUser){
        this.setIdReparasi(idReparasi);
        this.setTglreparasi(tglreparasi);
        this.setJenisreparasi(jenisreparasi);
        this.setIdKendaraan(idKendaraan);
        this.setIdUser(idUser);

    }

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

    public User getIdUser() { return idUser; }

    public void setIdUser(User idUser) { this.idUser = idUser; }

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
                "idReparasi=" + idReparasi +
                ", tglreparasi=" + tglreparasi +
                ", jenisreparasi='" + jenisreparasi + '\'' +
                ", idKendaraan=" + idKendaraan +
                ", idUser=" + idUser +
                '}';
    }
}
