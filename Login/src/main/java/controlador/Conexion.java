package controlador;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import javax.swing.JOptionPane;

public class Conexion {

		Connection cx;
		
		public Connection conexionbd() {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				try {
					cx=DriverManager.getConnection("jdbc:mysql://localhost/bd_tienda_g","root","samboni1");
					//JOptionPane.showMessageDialog(null, "Conexión exitosa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cx;
	}
}

