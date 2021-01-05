package Entity;

public class UserView {
    private String NoPlat;
    private String JenisKendaraan;
    private  String NamaPemilik;
    private String Tanggal;
    private String JenisReparasi;

    public UserView(String noPlat, String jenisKendaraan, String namaPemilik, String tanggal, String jenisReparasi) {
        NoPlat = noPlat;
        JenisKendaraan = jenisKendaraan;
        NamaPemilik = namaPemilik;
        Tanggal = tanggal;
        JenisReparasi = jenisReparasi;
    }



    @Override
    public String toString() {
        return "UserView{" +
                "NoPlat='" + NoPlat + '\'' +
                ", JenisKendaraan='" + JenisKendaraan + '\'' +
                ", NamaPemilik='" + NamaPemilik + '\'' +
                ", Tanggal='" + Tanggal + '\'' +
                ", JenisReparasi='" + JenisReparasi + '\'' +
                '}';
    }

    public String getNoPlat() {
        return NoPlat;
    }

    public void setNoPlat(String noPlat) {
        NoPlat = noPlat;
    }

    public String getJenisKendaraan() {
        return JenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        JenisKendaraan = jenisKendaraan;
    }

    public String getNamaPemilik() {
        return NamaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        NamaPemilik = namaPemilik;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJenisReparasi() {
        return JenisReparasi;
    }

    public void setJenisReparasi(String jenisReparasi) {
        JenisReparasi = jenisReparasi;
    }
}
