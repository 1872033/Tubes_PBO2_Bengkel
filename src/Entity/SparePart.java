package Entity;

public class SparePart {
    private int idSparepart;
    private String namaSparepart;
    private int hargaBeli;
    private int hargaJual;
    private int stok;
    private int idRep;


    public SparePart(int idSparepart, String namaSparepart, int hargaBeli, int hargaJual, int stok, int idRep){
        this.setIdSparepart(idSparepart);
        this.setNamaSparepart(namaSparepart);
        this.setHargaBeli(hargaBeli);
        this.setHargaJual(hargaJual);
        this.setStok(stok);
        this.setIdRep(idRep);

    }
    public int getIdRep() { return idRep; }

    public void setIdRep(int idRep) { this.idRep = idRep; }

    public int getIdSparepart() {
        return idSparepart;
    }

    public void setIdSparepart(int idSparepart) {
        this.idSparepart = idSparepart;
    }

    public String getNamaSparepart() {
        return namaSparepart;
    }

    public void setNamaSparepart(String namaSparepart) {
        this.namaSparepart = namaSparepart;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "idSparepart=" + idSparepart +
                ", namaSparepart='" + namaSparepart + '\'' +
                ", hargaBeli=" + hargaBeli +
                ", hargaJual=" + hargaJual +
                ", stok=" + stok +
                '}';
    }
}
