package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.usuariosDAO;
import modelo.usuariosDTO;

/**
 * Servlet implementation class Servletusuarios
 */
@WebServlet("/Servletusuarios")
public class Servletusuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletusuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Insertar un usuario
				boolean insusu;
				int cedusu;
				String nombreusu, emailusu, usuario, password;
				usuariosDTO usudto;
				usuariosDAO usudao;
				usuariosDTO conusu;
				
				if(request.getParameter("btnins")!=null) {		
					cedusu=Integer.parseInt(request.getParameter("cedula_usu"));
					nombreusu=request.getParameter("nombre_usu");
					emailusu=request.getParameter("email_usu");
					usuario=request.getParameter("usuario");
					password=request.getParameter("password");
					usudto=new usuariosDTO(cedusu, nombreusu, emailusu, usuario, password);
					usudao=new usuariosDAO();
					insusu=usudao.insertarusuario(usudto);
					if(insusu==false) {
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
						response.sendRedirect("usuarios.jsp");
					}
					else {
						JOptionPane.showMessageDialog(null, "Usuario no se registró");
						response.sendRedirect("usuarios.jsp");			
					}
				}
				
				//Consultar un usuario
				if (request.getParameter("btncon")!=null) {
					int cod;
					String nusu, eusu, usu, pass;
					cedusu=Integer.parseInt(request.getParameter("cedula_usu"));
					usudto=new usuariosDTO(cedusu);
					usudao=new usuariosDAO();
					conusu=usudao.consultarusuario(usudto);
					cod=conusu.getCedusu();
					nusu=conusu.getNombreusu();
					eusu=conusu.getEmailusu();
					usu=conusu.getUser();
					pass=conusu.getPassword();
					JOptionPane.showMessageDialog(null, cod + nusu + eusu + usu + pass);
					response.sendRedirect("usuarios.jsp?co="+cod+"&&no="+nusu+"&&eu="+eusu+"&&us="+usu+"&&pa="+pass);
				}
				//Actualizar un usuario
				if(request.getParameter("btnact")!=null){
					int dat;
					cedusu=Integer.parseInt(request.getParameter("cedula_usu"));
					nombreusu=request.getParameter("nombre_usu");
					emailusu=request.getParameter("email_usu");
					usuario=request.getParameter("usuario");
					password=request.getParameter("password");
					usudto=new usuariosDTO(cedusu, nombreusu, emailusu, usuario, password);
					usudao=new usuariosDAO();
					dat=usudao.actualizar(usudto);
					if(dat > 0){
						JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente");
						response.sendRedirect("usuarios.jsp");
					
					}else {
						JOptionPane.showMessageDialog(null, "Usuario no actualizado");
						response.sendRedirect("usuarios.jsp");
					}	
				}
				//Eliminar
				if(request.getParameter("btneli")!=null){
					int dat;
					cedusu=Integer.parseInt(request.getParameter("cedula_usu"));
					nombreusu=request.getParameter("nombre_usu");
					emailusu=request.getParameter("email_usu");
					usuario=request.getParameter("usuario");
					password=request.getParameter("password");
					usudto=new usuariosDTO(cedusu);
					usudao=new usuariosDAO();
					dat=usudao.eliminar(usudto);
					if(dat>0) {
						JOptionPane.showMessageDialog(null, "Usuario eliminado");
					}else {
						JOptionPane.showMessageDialog(null, "No se eliminó el usuario");
					}
					response.sendRedirect("usuarios.jsp");
				}
			}
		}
