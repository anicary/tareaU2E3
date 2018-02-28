package mx.edu.ittepic.tdm_u2_e3;

/**
 * Created by Carolina Mondragon on 27/02/2018.
 */

public class Usuario {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getProy() {
        return proy;
    }

    public void setProy(String proy) {
        this.proy = proy;
    }

    public Usuario(int id, String nombre, String login, String proy) {

        this.id = id;
        this.nombre = nombre;
        this.login = login;
        this.proy = proy;
    }

    public Usuario(int id) {

        this.id = id;
    }

    String nombre,login,proy;
}
