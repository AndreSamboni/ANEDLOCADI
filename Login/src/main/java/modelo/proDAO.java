package modelo;
	
import java.sql.*;
import javax.swing.JOptionPane;
import controlador.Conexion;

	public class proDAO {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Conexion con= new Conexion();
		Connection cx=con.conexionbd();
		productosDTO prodto;
		
		public productosDTO consultarproducto(productosDTO pro) {
			try {
				ps=cx.prepareStatement("SELECT * FROM productos WHERE cod_producto=?");
				ps.setInt(1, pro.getCodproducto());
				rs=ps.executeQuery();
				if(rs.next()){
				 prodto=new productosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					  
			return prodto;  
		  }
}
		