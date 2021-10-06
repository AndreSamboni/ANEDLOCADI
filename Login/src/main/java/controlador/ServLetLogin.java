package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServLetLogin")
public class ServLetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServLetLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		String u,c;
		u=request.getParameter("usu");
		c=request.getParameter("pass");
		if(u.equals("admininicial")&& c.equals("admin123456")){
			JOptionPane.showInternalMessageDialog(null, "Datos correctos");
			
			// sesion.setAttribute("vsusuario",lo.getUsuario());
            sesion.setAttribute("llevadato",u );
            
			response.sendRedirect("Principal.jsp?dato="+u);
	}
		else {
			JOptionPane.showInternalMessageDialog(null, "Datos incorrectos");
			response.sendRedirect("index.jsp");
		}
	}
}
