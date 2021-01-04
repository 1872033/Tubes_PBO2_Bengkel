package Entity;

public class DetailReparasi {
    private int idReparasi;
    private int idSparapart;
    private int IdJasa;
    private int Jumlah;
    private int HargaCustomer;

    public DetailReparasi(int idReparasi,int idSparapart,int idJasa,int jumlah,int hargacustomer){
        this.setIdReparasi(idReparasi);
        this.setIdSparapart(idSparapart);
        this.setIdJasa(idJasa);
        this.setJumlah(jumlah);
        this.setHargaCustomer(hargacustomer);

    }

    public int getIdReparasi() { return idReparasi;
    }

    public void setIdReparasi(int idReparasi) {
        this.idReparasi = idReparasi;
    }

    public int getIdSparapart() {
        return idSparapart;
    }

    public void setIdSparapart(int idSparapart) {
        this.idSparapart = idSparapart;
    }

    public int getIdJasa() {
        return IdJasa;
    }

    public void setIdJasa(int idJasa) {
        IdJasa = idJasa;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int jumlah) {
        Jumlah = jumlah;
    }

    public int getHargaCustomer() {
        return HargaCustomer;
    }

    public void setHargaCustomer(int hargaUCustomer) {
        HargaCustomer = hargaUCustomer;
    }

    @Override
    public String toString() {
        return "DetailReparasi{" +
                "idReparasi=" + idReparasi +
                ", idSparapart=" + idSparapart +
                ", IdJasa=" + IdJasa +
                ", Jumlah=" + Jumlah +
                ", HargaCustomer=" + HargaCustomer +
                '}';
    }
}
