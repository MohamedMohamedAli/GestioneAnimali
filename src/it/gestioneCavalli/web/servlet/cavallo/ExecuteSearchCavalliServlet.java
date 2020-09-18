package it.gestioneCavalli.web.servlet.cavallo;

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

import it.gestioneCavalli.dto.CavalloDTO;
import it.gestioneCavalli.model.Animale;
import it.gestioneCavalli.service.CavalloService;

/**
 * Servlet implementation class ExecuteSearchCavalliServlet
 */
@WebServlet("/eseCercaCavalliSer")
public class ExecuteSearchCavalliServlet extends HttpServlet {
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
	public ExecuteSearchCavalliServlet() {
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
		String nome = request.getParameter("nomeInput");
		String soprannome = request.getParameter("soprannomeInput");

		String tipo = request.getParameter("tipoInput");
		String daCorsa = request.getParameter("daCorsaInput");
		String sesso = request.getParameter("sessoInput");
		String puledro = request.getParameter("puledroInput");
		String rescue = request.getParameter("rescueInput");
		String fatrice = request.getParameter("fatriceInput");

		String dataDa = request.getParameter("dataDaInput");
		String dataA = request.getParameter("dataAInput");
		String proprietario = request.getParameter("proprietarioInput");
		String colore = request.getParameter("coloreInput");
		String padre = request.getParameter("padreInput");
		String madre = request.getParameter("madreInput");
		String microchip = request.getParameter("microchipInput");
		String passaporto = request.getParameter("passaportoInput");
		String riconoscimentoPassaporto = request.getParameter("ricPassaportoInput");
		String attivi = request.getParameter("attiviInput");
		String disabilitati = request.getParameter("disabilitatiInput");

		CavalloDTO cavalloDTO = new CavalloDTO(nome, soprannome, tipo, daCorsa, sesso, puledro, rescue, fatrice, dataDa, dataA, proprietario, colore,
				padre, madre, microchip, passaporto, riconoscimentoPassaporto, attivi, disabilitati);

		List<Animale> cavalli = cavalloService.cercaByExample(cavalloDTO);

		request.setAttribute("listaCavalliAttr", cavalli);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
