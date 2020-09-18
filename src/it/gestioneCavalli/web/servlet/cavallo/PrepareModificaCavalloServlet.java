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
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.service.CavalloService;
import it.gestioneCavalli.service.GravidanzaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class PrepareModificaCavalloServlet
 */
@WebServlet("/preModificaCavalloSer")
public class PrepareModificaCavalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private CavalloService cavalloService;
	@Autowired
	private GravidanzaService gravidanzaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareModificaCavalloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));

		Animale animale = cavalloService.caricaConId(idCavallo);
		Gravidanza gravidanza = gravidanzaService.cercaAttiviConIdCavallo(idCavallo);

		request.setAttribute("gravidanzaAttr", gravidanza);
		request.setAttribute("listaAnimaliAttr", Utils.ANIMALI);
		request.setAttribute("cavalloAttr", animale);
		request.getRequestDispatcher("/cavallo/modificaCavallo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
