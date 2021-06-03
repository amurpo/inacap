package cl.Inacap.Odiseo.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.Inacap.Odiseo.DAO.LibroDAO;
import cl.Inacap.Odiseo.DTO.Libro;

/**
 * Servlet implementation class ListarLibros
 */
@WebServlet("/ListarLibros.do")
public class ListarLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListarLibros() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		
		
		LibroDAO l=new LibroDAO();
		List<Libro> libroList=l.getAllLibros();		
				
		request.setAttribute("ListaLibros", libroList);
		
		request.getRequestDispatcher("site/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer Index= Integer.parseInt(request.getParameter("Id").toString());	
		new LibroDAO().deleteLibro(Index);
		
		
	}

}
