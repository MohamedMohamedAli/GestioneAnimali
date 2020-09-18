package it.gestioneCavalli.web.servlet.visita;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.VisitaService;

/**
 * Servlet implementation class ListaVisiteServlet
 */
@WebServlet("/listaVisiteSer")
public class ListaVisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VisitaService visitaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaVisiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		List<Visita> visite= visitaService.listaConIdCavallo(idCavallo);
		
		request.setAttribute("listaVisiteAttr", visite);
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/visita/listaVisite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
