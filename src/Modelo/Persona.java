package Modelo;

public class Persona {
    int id;
    String nom;
    String correo;
    String tel;
    
    public Persona(){
    }

    public Persona(int id, String nom, String correo, String tel) {
        this.id = id;
        this.nom = nom;
        this.correo = correo;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nom=" + nom + ", correo=" + correo + ", tel=" + tel + '}';
    }
    
    
}
