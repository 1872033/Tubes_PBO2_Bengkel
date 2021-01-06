package Entity;

public class User {
    private int idUser;
    private String nama;
    private String username;
    private String password;

    public User(int idUser,String nama,String username,String password){
        this.setIdUser(idUser);
        this.setNama(nama);
        this.setUsername(username);
        this.setPassword(password);

    }

    public User() {

    }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return nama;
    }
}
