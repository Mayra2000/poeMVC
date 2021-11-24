
package controlador;
import java.sql.*;
import modelo.Alumno;

public class ControlBD {
   
    Connection conexion; //objeto de la clase connection para hacer vinculo con la base de datos
    PreparedStatement stInsertar; //objeto permite insertar una sentencia de sql
    PreparedStatement stConsulta;
    PreparedStatement stActualizar;
    PreparedStatement stEliminar;
    
    public ControlBD(){ //Constructor de la clase
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println("Error al cargar el driver");
            System.out.println(ex.getMessage());
        }  
    }
    
    public void abrir(){
        try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/poemvc?serverTimezone=GMT-5", "root","");
        stInsertar = conexion.prepareStatement("INSERT INTO Alumno VALUES (?,?,?,?,?,?,?,?,?)"); //el objeto ya tiene asociado la instruccion
        stConsulta = conexion.prepareStatement("SELECT * FROM Alumno WHERE codigo=?");
        stActualizar = conexion.prepareStatement("UPDATE Alumno set calProgra=?, calMate=?, calFisica=?, promedio=? WHERE codigo=?");
        stEliminar = conexion.prepareStatement("DELETE FROM Alumno WHERE codigo=?");
        }catch(SQLException ex){
            System.out.println("Error en abrir");
            System.out.println(ex.getMessage());
        }
    }
    
    public void cerrar(){
        try{
            conexion.close();
        }catch(SQLException ex){
            System.out.println("Error cerrar");
            System.out.println(ex.getMessage());
        }
    }
    
    public void insertarRegistro(Alumno objAl){
        try{
        stInsertar.setString(1, objAl.getNombre());
        stInsertar.setInt(2, objAl.getEdad());
        stInsertar.setString(3, objAl.getEmail());
        stInsertar.setString(4, objAl.getCodigo());
        stInsertar.setString(5, objAl.getCarrera());
        stInsertar.setDouble(6, objAl.getCalProgra());
        stInsertar.setDouble(7, objAl.getCalMate());
        stInsertar.setDouble(8, objAl.getCalFisica());
        stInsertar.setDouble(9, objAl.getPromedio());
        
        stInsertar.executeUpdate(); //update es de subir info
        
        }catch(SQLException ex){
            System.out.println("Error insertar en bd");
            System.out.println(ex.getMessage());
        }
    }

    public Alumno consultarRegistro(String codigo){
        Alumno objAl = null;
        ResultSet rs = null; //Clase que esta dentro del paquete de sql y sirve para almacenar la informacion que mande el gestor de datos
        
        try{
            
            stConsulta.setString(1, codigo);
            rs = stConsulta.executeQuery(); //query es de consulta y retorna un resultset
            
            if(rs.next()){//verificamos si existe el alumno
                objAl = new Alumno();
                objAl.setNombre(rs.getString("nombre"));
                objAl.setEdad(rs.getInt("edad"));
                objAl.setEmail(rs.getString("email"));
                objAl.setCodigo(rs.getString("codigo"));
                objAl.setCarrera(rs.getString("carrera"));
                objAl.setCalProgra(rs.getDouble("calProgra"));
                objAl.setCalMate(rs.getDouble("calMate"));
                objAl.setCalFisica(rs.getDouble("calFisica"));
                objAl.setPromedio(rs.getDouble("promedio"));
            }
            
        }catch(SQLException ex){
            System.out.println("Error en colsulta de alumno");
            System.out.println(ex.getMessage());
        }
        
        return objAl;
    }
    
    public void actualizarRegistro(Alumno objAl){
        
        try{
            stActualizar.setDouble(1, objAl.getCalProgra());
            stActualizar.setDouble(2, objAl.getCalMate());
            stActualizar.setDouble(3, objAl.getCalFisica());
            stActualizar.setDouble(4, objAl.getPromedio());
            stActualizar.setString(5, objAl.getCodigo());
            
            stActualizar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error al actualizar");
            System.out.println(ex.getMessage());
        }  
    }
    
    public void eliminarRegistro(Alumno objAl){
        try{
            stEliminar.setString(1, objAl.getCodigo());
            stEliminar.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error en eliminar");
            System.out.println(ex.getMessage());
        }
        
    }
}
