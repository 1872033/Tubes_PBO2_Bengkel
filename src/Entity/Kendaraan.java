package Entity;

public class Kendaraan {
    private int idKendaraan;
    private String jeniskendaraan;
    private String namapemilik;
    private String nostnk;
    private User idUser;

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

    public String getNamapemilik() {
        return namapemilik;
    }

    public void setNamapemilik(String namapemilik) {
        this.namapemilik = namapemilik;
    }

    public String getNostnk() {
        return nostnk;
    }

    public void setNostnk(String nostnk) {
        this.nostnk = nostnk;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Kendaraan{" +
                "jeniskendaraan='" + jeniskendaraan + '\'' +
                ", namapemilik='" + namapemilik + '\'' +
                ", nostnk='" + nostnk + '\'' +
                '}';
    }
}
