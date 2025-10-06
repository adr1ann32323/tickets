package domain;

public class User {
    private int id;
    private String nombre;
    private String email;
    private String rol; // REPORTER, ASSIGNEE, COORDINADOR

    public User (int id, String nombre, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }
    public User(String nombre, String email, String rol) {
        this(0,nombre,email,rol);
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return nombre; }
    public String getEmail() { return email; }
    public String getRol() { return rol; }
    @Override
    public String toString() {
        return id + " | " + nombre + " | " + email + " | " + rol;
    }
}
