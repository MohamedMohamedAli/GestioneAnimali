package it.gestioneCavalli.web.servlet.cavallo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.model.Animale;
import it.gestioneCavalli.service.CavalloService;

/**
 * Servlet implementation class DettaglioServlet
 */
@WebServlet("/dettaglioCavalloSer")
public class DettaglioCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CavalloService cavalloService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettaglioCavalloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		Animale animale = cavalloService.caricaConId(idCavallo);
		
		request.setAttribute("cavalloAttr", animale);
		request.getRequestDispatcher("/cavallo/dettaglioCavallo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
