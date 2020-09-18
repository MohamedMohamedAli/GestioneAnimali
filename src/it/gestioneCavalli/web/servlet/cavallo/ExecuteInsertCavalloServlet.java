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

import it.gestioneCavalli.model.Animale;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.service.CavalloService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteInsertCavalloServlet
 */
@WebServlet("/eseInserisciCavalloSer")
public class ExecuteInsertCavalloServlet extends HttpServlet {
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
	public ExecuteInsertCavalloServlet() {
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
		boolean daCorsa = Utils.getBooleanfromString(request.getParameter("daCorsaInput"));
		String sesso = request.getParameter("sessoInput");
		boolean puledro = Utils.getBooleanfromString(request.getParameter("puledroInput"));
		boolean rescue = Utils.getBooleanfromString(request.getParameter("rescueInput"));
		boolean fatrice = Utils.getBooleanfromString(request.getParameter("fatriceInput"));
		String stallonePadre = request.getParameter("stallonePadreInput");
		String dataNascita = request.getParameter("dataNascitaInput");
		String dataGravidanza = request.getParameter("dataGravidanzaInput");
		String proprietario = request.getParameter("proprietarioInput");
		String colore = request.getParameter("coloreInput");
		String padre = request.getParameter("padreInput");
		String madre = request.getParameter("madreInput");
		String microchip = request.getParameter("microchipInput");
		String passaporto = request.getParameter("passaportoInput");
		String riconoscimentoPassaporto = request.getParameter("ricPassaportoInput");
		String note = request.getParameter("noteInput");

		Gravidanza gravidanza = new Gravidanza();
		gravidanza.setDataInizio(Utils.parseDate(dataGravidanza));
		gravidanza.setStallonePadre(stallonePadre);
		gravidanza.setFatrice(nome);

		Animale animale = new Animale();
		animale.setNome(nome);
		animale.setSoprannome(soprannome);
		animale.setTipo(tipo);
		animale.setDaCorsa(daCorsa);
		animale.setRescue(rescue);
		animale.setPuledro(puledro);
		animale.setFatrice(fatrice);
		animale.setSesso(sesso);
		animale.setProprietario(proprietario);
		animale.setColore(colore);
		animale.setPadre(padre);
		animale.setMadre(madre);
		animale.setMicrochip(microchip);
		animale.setPassaporto(passaporto);
		animale.setRiconoscimentoPassaporto(riconoscimentoPassaporto);
		animale.setNote(note);
		animale.setAttivo(true);
		animale.setDataNascita(Utils.parseDate(dataNascita));
		animale.getGravidanze().add(gravidanza);
		System.out.println("_______________servlet________________");
		System.out.println("rescue: " + animale.isRescue());
		System.out.println("puledro: " + animale.isPuledro());
		System.out.println("fatrice: " + animale.isFatrice());
		cavalloService.inserisci(animale);
		List<Animale> cavalli = cavalloService.listAll();

		request.setAttribute("messaggioConferma", "Inserimento avvenuto con successo");
		request.setAttribute("listaCavalliAttr", cavalli);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
