package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.Conexion;

public class ventasDAO {
	PreparedStatement ps=null;
	ResultSet rs=null;
	Conexion con= new Conexion();
	Connection cx=con.conexionbd();
	ventasDTO ven;
	
	public boolean insertarventa(ventasDTO ven){
		

		boolean resultado=false;
		
		try{
	    ps =cx.prepareStatement("Insert Into ventas(cedula_cli,cedula_usu,valor_venta,iva_venta,total_venta) value(?,?,?,?,?)");
		ps.setInt(1, ven.getCedula_cli());
		ps.setInt(2, ven.getCedula_usu());
		ps.setDouble(3, ven.getValorventa());
		ps.setDouble(4, ven.getIvaventa());
		ps.setDouble(5, ven.getTotalventa());
		resultado=ps.executeUpdate()>0;
		
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
public ventasDTO consultarcodventa() {
	try {
		ps=cx.prepareStatement("SELECT MAX(cod_venta),cedula_cli,cedula_usu,valor_venta,iva_venta,total_venta AS id FROM ventas");
		rs=ps.executeQuery();
		if(rs.next()) {
			 ven=new ventasDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ven;
	}
}