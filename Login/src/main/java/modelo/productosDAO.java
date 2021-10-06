package modelo;
	
import java.sql.*;
import javax.swing.JOptionPane;
import controlador.Conexion;

	public class productosDAO {
		Conexion con=new Conexion();
		Connection cx=con.conexionbd();
		PreparedStatement ps;
		
		public boolean cargarproductos(String URL) {
			JOptionPane.showMessageDialog(null,"en dao"+URL);
			boolean resul=false;
			try {
			
			ps=cx.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ',' lines terminated by '\r\n';");
			resul=ps.executeUpdate()>0;
				
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Error al registrar productos: "+e);
				//e.printStackTrace();
		}
			return resul;
		}
	}
		