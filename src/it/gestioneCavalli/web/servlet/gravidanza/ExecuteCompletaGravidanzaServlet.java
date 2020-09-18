package it.gestioneCavalli.web.servlet.gravidanza;

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

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.CavalloService;
import it.gestioneCavalli.service.GravidanzaService;
import it.gestioneCavalli.service.VisitaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteCompletaGravidanzaServlet
 */
@WebServlet("/eseCompletaGravidanzaSer")
public class ExecuteCompletaGravidanzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GravidanzaService gravidanzaService;
	@Autowired
	private CavalloService cavalloService;
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
	public ExecuteCompletaGravidanzaServlet() {
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
		Long id = Long.parseLong(request.getParameter("idGravidanza"));
		String puledro = request.getParameter("puledroInput");
		String veterinario = request.getParameter("veterinarioInput");
		String data = request.getParameter("dataInput");
		String causa = request.getParameter("causaInput");
		String trattamento = request.getParameter("trattamentoInput");
		String prezzo = request.getParameter("prezzoInput");
		String note = request.getParameter("noteInput");

		Gravidanza gravidanza = gravidanzaService.caricaEager(id);
		gravidanza.setCompletata(true);
		gravidanza.setDataFine(Utils.parseDate(data));
		gravidanza.setPuledro(puledro);

		if (Utils.isNotBlank(puledro)) {
			// INSERT PULEDRO
			Animale animale = new Animale();
			animale.setNome(puledro);
			animale.setDataNascita(Utils.parseDate(data));
			animale.setAttivo(true);
			animale.setPadre(gravidanza.getStallonePadre());
			animale.setMadre(gravidanza.getFatrice());
			animale.setPuledro(true);
			animale.setTipo("CAVALLO");

			cavalloService.inserisci(animale);
		}

		// INSERT CAVALLO MADRE
		Animale cavalloMadre = gravidanza.getCavallo();
		cavalloMadre.setFatrice(false);
		List<Gravidanza> gravidanze = new ArrayList<Gravidanza>();
		gravidanze.add(gravidanza);
		cavalloMadre.setGravidanze(gravidanze);
		cavalloService.aggiorna(gravidanza.getCavallo());

		// INSERT VISITA
		Visita visita = new Visita();
		visita.setVeterinario(veterinario);
		visita.setData(Utils.parseDate(data));
		visita.setCausa(causa);
		visita.setTrattamento(trattamento);
		visita.setPrezzo(Utils.parsePrezzo(prezzo));
		visita.setNote(note);
		visita.setAnimale(gravidanza.getCavallo());
		visitaService.inserisci(visita);

		// GET LISTA COMPLETA
		List<Gravidanza> listaGravidanzeAttr = gravidanzaService.cercaByExample(new GravidanzaDTO());

		request.setAttribute("listaGravidanzeAttr", listaGravidanzeAttr);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/gravidanza/listaGravidanze.jsp").forward(request, response);
	}

}
