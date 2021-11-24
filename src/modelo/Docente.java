
package modelo;


public class Docente extends Persona{
    
    //Atributos exclusivos del Docente
    private int cantHoras;
    private double salario;

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void calcularSalario() {  //Pago x hora
        setSalario ( getCantHoras() * 120);
    }
    
    @Override
     public String mostrarDatos() {
        
         String info = super.mostrarDatos();
         
               info+= "Horas impartidas : " + getCantHoras() + "\n" +
                      "Salario semanal  : " + getSalario() + "\n";                   ;
                      
         return info;
    } 
     
    public void calificarAlumno(double calProgra, double calMate, 
                                double calFisica, Alumno al) {
        
        al.setCalProgra(calProgra);
        al.setCalMate(calMate);
        al.setCalFisica(calFisica);
    } 
}
