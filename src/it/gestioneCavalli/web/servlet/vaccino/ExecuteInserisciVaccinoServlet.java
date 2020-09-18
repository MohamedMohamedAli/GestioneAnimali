package it.gestioneCavalli.web.servlet.vaccino;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestioneCavalli.model.Animale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.model.Vaccino;
import it.gestioneCavalli.service.VaccinoService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteInserisciVaccinoServlet
 */
@WebServlet("/eseInserisciVaccinoSer")
public class ExecuteInserisciVaccinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VaccinoService vaccinoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteInserisciVaccinoServlet() {
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
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		String tipo = request.getParameter("tipoInput");
		String data = request.getParameter("dataInput");
		String note = request.getParameter("noteInput");

		Vaccino vaccino = new Vaccino();
		Animale animale = new Animale();
		animale.setId(idCavallo);

		vaccino.setTipo(tipo);
		vaccino.setData(Utils.parseDate(data));
		vaccino.setNote(note);
		vaccino.setAnimale(animale);

		vaccinoService.inserisci(vaccino);
		List<Vaccino> vaccini = vaccinoService.listaConIdCavallo(idCavallo);
		request.setAttribute("listaVacciniAttr", vaccini);
		request.setAttribute("messaggioConferma", "Inserimento avvenuto con successo");
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/vaccino/listaVaccini.jsp").forward(request, response);
	}

}
