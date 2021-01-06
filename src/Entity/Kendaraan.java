package Entity;

public class Kendaraan {
    private int idKendaraan;
    private String jeniskendaraan;
    private String nostnk;
    private  String noPlat;
    private String NamaUser;

    public Kendaraan(int idKendaraan,String jeniskendaraan,String nostnk,String noPlat,String NamaUser){
        this.setIdKendaraan(idKendaraan);
        this.setJeniskendaraan(jeniskendaraan);
        this.setNostnk(nostnk);
        this.setNoPlat(noPlat);
        this.setNamaUser(NamaUser);

    }

    public String getNamaUser() {
        return NamaUser;
    }

    private void setNamaUser(String namaUser) {
        this.NamaUser=namaUser;
    }


    public int getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getJeniskendaraan() {
        return jeniskendaraan;
    }

    public void setJeniskendaraan(String jeniskendaraan) {
        this.jeniskendaraan = jeniskendaraan;
    }

    public String getNostnk() {
        return nostnk;
    }

    public void setNostnk(String nostnk) {
        this.nostnk = nostnk;
    }

    public String getNoPlat() { return noPlat; }

    public void setNoPlat(String noPlat) { this.noPlat = noPlat; }

    @Override
    public String toString() {
        return
                "id = " + idKendaraan +
                " | jenis = " + jeniskendaraan;
    }
}
