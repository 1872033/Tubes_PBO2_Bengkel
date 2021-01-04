package Entity;

public class Kendaraan {
    private int idKendaraan;
    private String jeniskendaraan;
    private String nostnk;
    private  String noPlat;
    private User idUser;

    public Kendaraan(int idKendaraan,String jeniskendaraan,String nostnk,String noPlat,User idUser){
        this.setIdKendaraan(idKendaraan);
        this.setJeniskendaraan(jeniskendaraan);
        this.setNostnk(nostnk);
        this.setNoPlat(noPlat);
        this.setIdUser(idUser);

    }

    public Kendaraan(int idKendaraan, String jeniskendaraan, String nostnk, String noPlat) {
        this.setIdKendaraan(idKendaraan);
        this.setJeniskendaraan(jeniskendaraan);
        this.setNostnk(nostnk);
        this.setNoPlat(noPlat);
        this.setIdUser(idUser);
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

    public User getIdUser() { return idUser; }

    public void setIdUser(User idUser) { this.idUser = idUser; }

    @Override
    public String toString() {
        return "Kendaraan{" +
                "idKendaraan=" + idKendaraan +
                ", jeniskendaraan='" + jeniskendaraan + '\'' +
                ", nostnk='" + nostnk + '\'' +
                ", noPlat='" + noPlat + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
