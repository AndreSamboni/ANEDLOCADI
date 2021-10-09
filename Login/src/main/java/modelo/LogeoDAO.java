package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.Conexion;

public class LogeoDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection conecta=con.conexionbd();
	
	 public usuariosDTO login(usuariosDTO us){
	  
		    usuariosDTO u=null;
		    
		    try{
		    String sql="select * from usuarios where usuario=? and password_usuario=?";
		    
		    ps =conecta.prepareStatement(sql);
		    ps.setString(1, us.getUser());
			ps.setString(2, us.getPassword());
			res=ps.executeQuery();
		    
		    if(res.next()){

		       u= new usuariosDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));

		     }
		    }catch(SQLException ex){
		     JOptionPane.showMessageDialog(null,"Error al Consultar" +ex);
		    }
		    return u;
		    }
}