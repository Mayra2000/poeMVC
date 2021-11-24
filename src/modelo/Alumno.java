
package modelo;


public class Alumno extends Persona{
    
    //Atributos exclusivos del Alumno
    private String carrera;
    private double calProgra;
    private double calMate;
    private double calFisica;
    private double promedio;

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getCalProgra() {
        return calProgra;
    }

    public void setCalProgra(double calProgra) {
        this.calProgra = calProgra;
    }

    public double getCalMate() {
        return calMate;
    }

    public void setCalMate(double calMate) {
        this.calMate = calMate;
    }

    public double getCalFisica() {
        return calFisica;
    }

    public void setCalFisica(double calFisica) {
        this.calFisica = calFisica;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

        
    public void calcularPromedio() {
        
        setPromedio ( (getCalProgra() + getCalMate() + getCalFisica()) /3 );
    }
    
    @Override
     public String mostrarDatos() {
        
         String info = super.mostrarDatos();
         
               info+= "Carrera        : " + getCarrera() + "\n" +
                      "Programación   : " + getCalProgra() + "\n" +
                      "Matemáticas    : " + getCalMate() + "\n" +
                      "Física         : " + getCalFisica() + "\n"+
                      "Promedio       : " + getPromedio() + "\n";
                      
         return info;
    }  
    
    
}
