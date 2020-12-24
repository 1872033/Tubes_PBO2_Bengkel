package Entity;

public class Jasa {
    private int idJasa;
    private String namaJasa;
    private int Tarif;

    public int getIdJasa() {
        return idJasa;
    }

    public void setIdJasa(int idJasa) {
        this.idJasa = idJasa;
    }

    public String getNamaJasa() {
        return namaJasa;
    }

    public void setNamaJasa(String namaJasa) {
        this.namaJasa = namaJasa;
    }

    public int getTarif() {
        return Tarif;
    }

    public void setTarif(int tarif) {
        Tarif = tarif;
    }

    @Override
    public String toString() {
        return "Jasa{" +
                "idJasa=" + idJasa +
                ", namaJasa='" + namaJasa + '\'' +
                ", Tarif=" + Tarif +
                '}';
    }
}

