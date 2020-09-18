package it.gestioneCavalli.web.servlet.vaccino;

import java.io.IOException;
import java.util.ArrayList;
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

import it.gestioneCavalli.dto.VaccinoDTO;
import it.gestioneCavalli.model.Vaccino;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.CavalloService;
import it.gestioneCavalli.service.VaccinoService;
import it.gestioneCavalli.service.VisitaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteCompltaVaccinoServlet
 */
@WebServlet("/eseCompletaVaccinoSer")
public class ExecuteCompltaVaccinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private VaccinoService vaccinoService;
	@Autowired
	private VisitaService visitaService;
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
	public ExecuteCompltaVaccinoServlet() {
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
		Long idVaccino = Long.parseLong(request.getParameter("idVaccino"));
		String cercaVaccini = request.getParameter("cercaVaccini");

		String veterinario = request.getParameter("veterinarioInput");
		String data = request.getParameter("dataInput");
		String causa = request.getParameter("causaInput");
		String trattamento = request.getParameter("trattamentoInput");
		String prezzo = request.getParameter("prezzoInput");
		String note = request.getParameter("noteInput");

		Visita visita = new Visita();
		Animale animale = cavalloService.caricaConId(idCavallo);

		visita.setVeterinario(veterinario);
		visita.setData(Utils.parseDate(data));
		visita.setCausa(causa);
		visita.setTrattamento(trattamento);
		visita.setPrezzo(Utils.parsePrezzo(prezzo));
		visita.setNote(note);
		visita.setAnimale(animale);

		visitaService.inserisci(visita);

		int month = 0;
		int year = 0;
		if (animale.isDaCorsa() && trattamento.toUpperCase().equals("IT")) {
			month = 6;
		} else {
			year = 1;
		}

		data = Utils.incrementDate(data, month, year);

		Vaccino vaccino = new Vaccino();
		vaccino.setTipo(trattamento);
		vaccino.setData(Utils.parseDate(data));
		vaccino.setAnimale(animale);

		vaccinoService.inserisci(vaccino);
		vaccinoService.elimina(idVaccino);

		List<Vaccino> vaccini = new ArrayList<Vaccino>();
		String path = "";

		boolean vaiElencoRicerca = Utils.getBooleanfromString(cercaVaccini);
		System.out.println(vaiElencoRicerca);
		if (vaiElencoRicerca) {
			VaccinoDTO vaccinoDTO = new VaccinoDTO("", "", "");
			vaccini = vaccinoService.cercaPerExample(vaccinoDTO);
			path = "/vaccino/resultCercaVaccini.jsp";

			System.out.println("idCavallo: " + vaccini.get(0).getAnimale().getId());
			System.out.println("idCavallo: " + vaccini.get(0).getAnimale().getNome());
		} else {
			vaccini = vaccinoService.listaConIdCavallo(idCavallo);
			path = "/vaccino/listaVaccini.jsp";
		}

		request.setAttribute("listaVacciniAttr", vaccini);
		request.setAttribute("messaggioConferma", "Vaccinazione registrata con successo");
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
