package it.gestioneCavalli.web.servlet.visita;

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

import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.VisitaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteModificaVisitaServlet
 */
@WebServlet("/eseModificaVisitaSer")
public class ExecuteModificaVisitaServlet extends HttpServlet {
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
	public ExecuteModificaVisitaServlet() {
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
		Long idVisita = Long.parseLong(request.getParameter("idVisita"));
		String veterinario = request.getParameter("veterinarioInput");
		String data = request.getParameter("dataInput");
		String causa = request.getParameter("causaInput");
		String trattamento = request.getParameter("trattamentoInput");
		String prezzo = request.getParameter("prezzoInput");
		String note = request.getParameter("noteInput");

		Visita visita = new Visita();
		Animale animale = new Animale();
		animale.setId(idCavallo);

		visita.setId(idVisita);
		visita.setVeterinario(veterinario);
		visita.setData(Utils.parseDate(data));
		visita.setCausa(causa);
		visita.setTrattamento(trattamento);
		visita.setPrezzo(Utils.parsePrezzo(prezzo));
		visita.setNote(note);
		visita.setAnimale(animale);

		visitaService.aggiorna(visita);
		List<Visita> visite = visitaService.listaConIdCavallo(idCavallo);
		request.setAttribute("listaVisiteAttr", visite);
		request.setAttribute("messaggioConferma", "Inserimento avvenuto con successo");
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/visita/listaVisite.jsp").forward(request, response);
	}

}
