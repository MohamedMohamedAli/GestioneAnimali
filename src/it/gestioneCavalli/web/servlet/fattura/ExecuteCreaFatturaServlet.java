package it.gestioneCavalli.web.servlet.fattura;

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

import it.gestioneCavalli.model.Ferratura;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.FerraturaService;
import it.gestioneCavalli.service.VisitaService;

/**
 * Servlet implementation class ExecuteCreaFatturaServlet
 */
@WebServlet("/eseCreaFatturaSer")
public class ExecuteCreaFatturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VisitaService visitaService;
	@Autowired
	private FerraturaService ferraturaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCreaFatturaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipoFattura = request.getParameter("tipoFattura");
		System.out.println(tipoFattura);
		String dataDa = "";
		String dataA = "";
		String path = "";
		Double totale = 0.0;
		switch (tipoFattura) {
		case "VISITE":
			System.out.println("CASO => VISITE");
			dataDa = request.getParameter("dataVisiteDaInput");
			dataA = request.getParameter("dataVisiteAInput");
			List<Visita> visite = visitaService.caricaCavalliConDataVisita(dataDa, dataA);

			for (Visita v : visite) {
				totale += v.getPrezzo();
			}
			path = "/fattura/fatturaVisite.jsp";
			request.setAttribute("listaVisiteAttr", visite);
			break;
		case "FERRATURE":
			System.out.println("CASO => FERRATURE");
			dataDa = request.getParameter("dataFerratureDaInput");
			dataA = request.getParameter("dataFerratureAInput");
			List<Ferratura> ferrature = ferraturaService.caricaCavalliConDataFerratura(dataDa, dataA);
			for (Ferratura f : ferrature) {
				totale += f.getPrezzo();
			}
			path = "/fattura/fatturaFerrature.jsp";
			request.setAttribute("listaFerratureAttr", ferrature);
		}

		request.setAttribute("totaleAttr", totale);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
