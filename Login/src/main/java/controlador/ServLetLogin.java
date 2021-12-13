package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.LogeoDAO;
import modelo.usuariosDTO;

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
		if(request.getParameter("btnlog")!=null){
			
			String u,c;
			usuariosDTO usdto;
			u=request.getParameter("usuario");
			c=request.getParameter("password");
			usuariosDTO lo=new usuariosDTO(u, c);
			LogeoDAO lodao=new LogeoDAO();
			usdto=lodao.login(lo);

			String y="admininicial";
			sesion.setAttribute("llevadat",y );
             
              if(usdto.getUser().equals(u) && usdto.getPassword().equals(c)){
                 JOptionPane.showMessageDialog(null, "Datos correctos");
                 String uss=usdto.getNombreusu(); 
                 JOptionPane.showMessageDialog(null, uss);
                 // sesion.setAttribute("vsusuario",lo.getUsuario());
                 sesion.setAttribute("llevadato",uss );
                 sesion.setAttribute("vs",usdto);
                 request.getRequestDispatcher("Principal.jsp").forward(request, response);
           
              }else{
            	   JOptionPane.showMessageDialog(null, "Datos incorrectos");
            	   response.sendRedirect("index.jsp");
        }

}
	}
}