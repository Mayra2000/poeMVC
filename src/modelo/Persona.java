
package modelo;


public class Persona {
    
    //Atributos comunes para Docente y Alumno
    private String nombre;
    private int edad;
    private String email;
    private String codigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String mostrarDatos() {
        
        String info = "Nombre : " + getNombre() + "\n" +
                      "Edad   : " + getEdad() + "\n" +
                      "Email  : " + getEmail() + "\n" +
                      "Código :" + getCodigo() + "\n";
                      
         return info;
    }  
    
   
    
}
