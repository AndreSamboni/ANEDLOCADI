package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import modelo.clientesDAO;
import modelo.clientesDTO;

/**
 * Servlet implementation class Servletclientes
 */
@WebServlet("/Servletclientes")
public class Servletclientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletclientes() {
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
		PrintWriter out=response.getWriter();
		int cedcli;
		String nombrecli, dircli, emailcli, telcli;
		clientesDTO clidto;
		clientesDAO clidao;
		clientesDTO concli;
		//Insertar un cliente
		if(request.getParameter("btnins")!=null) {
			boolean inscli;
			cedcli=Integer.parseInt(request.getParameter("cedula_cli"));
			nombrecli=request.getParameter("Nombre_cli");
			dircli=request.getParameter("direccion_cli");
			telcli=request.getParameter("Telefono_cli");
			emailcli=request.getParameter("email_cli");
			JOptionPane.showMessageDialog(null, cedcli + nombrecli + dircli + telcli + emailcli);
			clidto=new clientesDTO(cedcli, nombrecli, dircli, telcli, emailcli);
			clidao=new clientesDAO();
			inscli=clidao.insertarcliente(clidto);
			if(inscli==false) {
				JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
				response.sendRedirect("clientes.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Cliente no se registró");
				response.sendRedirect("clientes.jsp");			
			}
		}
		
		//Consultar un cliente
		if (request.getParameter("btncon")!=null) {
			int cod;
			String ncli, dcli, tcli, ecli;
			cedcli=Integer.parseInt(request.getParameter("cedula_cli"));
			clidto=new clientesDTO(cedcli);
			clidao=new clientesDAO();
			concli=clidao.consultarcliente(clidto);
			cod=concli.getCedcli();
			ncli=concli.getNombrecli();
			dcli=concli.getDircli();
			tcli=concli.getTelcli();
			ecli=concli.getEmailcli();
			JOptionPane.showMessageDialog(null, cod + ncli + dcli + tcli + ecli);
			response.sendRedirect("clientes.jsp?co="+cod+"&&no="+ncli+"&&dir="+dcli+"&&tel="+tcli+"&&em="+ecli);
		}
		//Actualizar un cliente
		if(request.getParameter("btnact")!=null){
			int dat;
			cedcli=Integer.parseInt(request.getParameter("cedula_cli"));
			nombrecli=request.getParameter("Nombre_cli");
			dircli=request.getParameter("direccion_cli");
			emailcli=request.getParameter("email_cli");
			telcli=request.getParameter("Telefono_cli");
			clidto=new clientesDTO(cedcli, nombrecli, dircli, emailcli, telcli);
			clidao=new clientesDAO();
			dat=clidao.actualizar(clidto);
			if(dat > 0){
				JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
				response.sendRedirect("clientes.jsp");
			
			}else {
				JOptionPane.showMessageDialog(null, "Cliente no actualizado");
				response.sendRedirect("clientes.jsp");
			}	
		}
		//Eliminar
		if(request.getParameter("btneli")!=null){
			int dat;
			cedcli=Integer.parseInt(request.getParameter("cedula_cli"));
			nombrecli=request.getParameter("Nombre_cli");
			dircli=request.getParameter("direccion_cli");
			emailcli=request.getParameter("email_cli");
			telcli=request.getParameter("Telefono_cli");
			clidto=new clientesDTO(cedcli);
			clidao=new clientesDAO();
			dat=clidao.eliminar(clidto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "Cliente eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "No se eliminó el cliente");
			}
			response.sendRedirect("clientes.jsp");
			}
		if(request.getParameter("btnconcli")!=null) {	
			
		}
		
		JOptionPane.showMessageDialog(null, "Gson");
		ArrayList<clientesDTO>lista=new ArrayList<>();
		clidao=new clientesDAO();
		lista=clidao.consultageneralcli();
		Gson gson=new Gson();
		out.print(gson.toJson(lista));
		}
}