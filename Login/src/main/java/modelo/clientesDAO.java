package modelo;
	
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

	public class clientesDAO {
		Conexion con=new Conexion();
		Connection cx=con.conexionbd();
		PreparedStatement ps;
		ResultSet rs;
		clientesDTO clidto=null;
		//Insertar cliente
		public boolean insertarcliente(clientesDTO cli) {
			int c;
			boolean dat=false;
		
		try {
			ps=cx.prepareStatement("INSERT INTO clientes Values(?,?,?,?,?)");
			ps.setInt(1, cli.getCedcli());
			ps.setString(2, cli.getNombrecli());
			ps.setString(3, cli.getDircli());
			ps.setString(4, cli.getTelcli());
			ps.setString(5, cli.getEmailcli());
			ps.executeUpdate();
			c=ps.executeUpdate();
			if(c>0) {
				dat=true;
			}
			else {
				dat=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
		}
		//Consultar cliente
		public clientesDTO consultarcliente(clientesDTO cli) {
			try {
			ps=cx.prepareStatement("SELECT * FROM clientes WHERE cedula_cli=?");
			ps.setInt(1, cli.getCedcli());
			rs=ps.executeQuery();
			if(rs.next()) {
			cli=new clientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			else {
				return null;
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cli;
		}
	
	//Actualizar cliente
		public int actualizar(clientesDTO cli) {
			int  x=0;
			
				try {
					ps=cx.prepareStatement("UPDATE clientes SET Nombre_cli=?,direccion_cli=?,Telefono_cli=?,email_cli=? WHERE cedula_cli=?");
					ps.setString(1, cli.getNombrecli());
					ps.setString(2, cli.getDircli());
					ps.setString(3, cli.getTelcli());
					ps.setString(4, cli.getEmailcli());
					ps.setInt(5, cli.getCedcli());
					x=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			return x;
		}
		
		//Eliminar cliente
		public int eliminar (clientesDTO cli) {
			int x=0;
			try {
				ps=cx.prepareStatement("DELETE FROM clientes WHERE cedula_cli=?");
				ps.setInt(1, cli.getCedcli());
				//ps.setString(2, cli.getNombrecli());
				//ps.setString(3, cli.getDircli());
				//ps.setString(4, cli.getTelcli());
				//ps.setString(5, cli.getEmailcli());
				x=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO  Auto-generated catch block
				e.printStackTrace();
			}
			
			return x;
		}
		//Consulta general clientes
		public ArrayList<clientesDTO> consultageneralcli(){
			ArrayList<clientesDTO>lista=new ArrayList<clientesDTO>();
			try {
				ps=cx.prepareStatement("SELECT * FROM clientes");
				rs=ps.executeQuery();
				while(rs.next()) {
					clidto=new clientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					lista.add(clidto);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lista;
		}

	}
