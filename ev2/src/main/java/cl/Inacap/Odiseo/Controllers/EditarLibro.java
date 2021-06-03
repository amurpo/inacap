package cl.Inacap.Odiseo.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.Inacap.Odiseo.DAO.LibroDAO;
import cl.Inacap.Odiseo.DTO.*;

/**
 * Servlet implementation class EditPersona
 */
@WebServlet("/EditLibro.do")
public class EditarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDAO ps= new LibroDAO();
		
		int Iden=Integer.parseInt(request.getParameter("Iden"));
		
		request.setAttribute("Persona", ps.getLibrobyID(Iden));
		request.setAttribute("IdentificadorLibro", Iden);
		
		request.getRequestDispatcher("site/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre=request.getParameter("nombre").toString();	
		String autor=request.getParameter("autor").toString();	
		int numpag=Integer.parseInt(request.getParameter("numpag").toString());
		Boolean.parseBoolean(request.getParameter("Destacado")); 
		String portada=request.getParameter("Portada").toString();	
		int index=Integer.parseInt(request.getParameter("index").toString());
		int estrellas=Integer.parseInt(request.getParameter("estrellas").toString());

		
		Libro l=new Libro();
		l.setNombre(nombre);
		l.setAutor(autor);
		l.setNumpag(numpag);
		l.setDestacado(true);
		l.setPortada(portada);
		l.setEstrellas(estrellas);
		
		LibroDAO ldao=new LibroDAO();
		
		ldao.updateLibro(l,index);
		
		
		response.sendRedirect("ListarLibros.do");
		
		
		
		PrintWriter out=response.getWriter();
		out.println("Servlet de editar libro");
		
	}

}
