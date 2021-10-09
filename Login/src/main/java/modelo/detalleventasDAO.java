package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import controlador.Conexion;

public class detalleventasDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection cnn=con.conexionbd();

	
	public boolean Inserta_Cliente(detalleventasDTO det){

		boolean resultado=false;
		//ClienteDTO usu=null;
		try{
		//usu=  buscarcliente(u);
		//if(usu!=null) {
			
			ps =cnn.prepareStatement("Insert Into detalle_venta(cod_venta,cant_producto,cod_producto,valor_venta,valor_iva, valor_total)   value(?,?,?,?,?,?);");
			ps.setInt(1, det.getCod_venta());
			ps.setLong(2, det.getCant_producto());
			ps.setLong(3, det.getCod_producto());
			ps.setDouble(4, det.getValor_venta());
			ps.setDouble(5, det.getValor_iva());
		ps.setDouble(6, det.getValor_total());
		resultado=ps.executeUpdate()>0;
		//}
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
}