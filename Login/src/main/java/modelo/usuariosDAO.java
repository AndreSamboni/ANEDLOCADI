package modelo;
	
import java.sql.*;
import java.util.ArrayList;
import controlador.Conexion;

	public class usuariosDAO {
		Conexion con=new Conexion();
		Connection cx=con.conexionbd();
		PreparedStatement ps;
		ResultSet rs;
		usuariosDTO usudto;
		//Insertar usuario
		public boolean insertarusuario(usuariosDTO usu) {
			int c;
			boolean dat=false;
		
		try {
			ps=cx.prepareStatement("INSERT INTO usuarios Values(?,?,?,?,?,?,?)");
			ps.setInt(1, usu.getCedusu());
			ps.setString(2, usu.getNombreusu());
			ps.setString(3, usu.getEmailusu());
			ps.setString(4, usu.getUser());
			ps.setString(5, usu.getPassword());
			ps.setString(6, usu.getCiudad());
			ps.setString(7, usu.getRol());
			ps.executeUpdate();
			c=ps.executeUpdate();
			if(c>0) {
				dat=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
		}
		//Consultar usuario
		public usuariosDTO consultarusuario(usuariosDTO usu) {
			try {
			ps=cx.prepareStatement("SELECT * FROM usuarios WHERE cedula_usu=?");
			ps.setInt(1, usu.getCedusu());
			rs=ps.executeQuery();
			if(rs.next()) {
			usu=new usuariosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
			}
			else {
				return null;
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
		}
	
	//Actualizar usuario
		public int actualizar(usuariosDTO usu) {
			int  x=0;
			
				try {
					ps=cx.prepareStatement("UPDATE usuarios SET nombre_usu=?,email_usu=?, usuario=?, password=?,ciudad=?,rol=? WHERE cedula_usu=?");
					ps.setString(1, usu.getNombreusu());
					ps.setString(2, usu.getEmailusu());
					ps.setString(3, usu.getUser());
					ps.setString(4, usu.getPassword());
					ps.setString(5, usu.getCiudad());
					ps.setString(6, usu.getRol());
					ps.setInt(7, usu.getCedusu());
					x=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			return x;
		}
		
		//Eliminar cliente
		public int eliminar (usuariosDTO usu) {
			int x=0;
			try {
				ps=cx.prepareStatement("DELETE FROM usuarios WHERE cedula_usu=?");
				ps.setInt(1, usu.getCedusu());
				//ps.setString(2, usu.getNombreusu());
				//ps.setString(3, usu.getEmailusu());
				//ps.setString(4, usu.getUser());
				//ps.setString(5, usu.getPassword());
				//ps.setString(6, usu.getCiudad());
				//ps.setString(7, usu.getRol());
				x=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO  Auto-generated catch block
				e.printStackTrace();
			}
			
			return x;
		}
		//Consulta general usuarios
		public ArrayList<usuariosDTO> consultageneralusu(){
			ArrayList<usuariosDTO>lista=new ArrayList<usuariosDTO>();
			try {
				ps=cx.prepareStatement("SELECT * FROM usuarios");
				rs=ps.executeQuery();
				while(rs.next()) {
					usudto=new usuariosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
					lista.add(usudto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}
		

	}
