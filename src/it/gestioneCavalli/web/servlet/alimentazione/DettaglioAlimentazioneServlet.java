package it.gestioneCavalli.web.servlet.alimentazione;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.service.AlimentazioneService;

/**
 * Servlet implementation class DettaglioVisitaServlet
 */
@WebServlet("/dettaglioAlimentazioneSer")
public class DettaglioAlimentazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AlimentazioneService alimentazioneService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DettaglioAlimentazioneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		Long idVisita = Long.parseLong(request.getParameter("idVisita"));

//		Visita visita = visitaService.caricaConId(idVisita);

//		request.setAttribute("visitaAttr", visita);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.getRequestDispatcher("/alimentazione/dettaglioAlimentazione.jsp").forward(request, response);

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
