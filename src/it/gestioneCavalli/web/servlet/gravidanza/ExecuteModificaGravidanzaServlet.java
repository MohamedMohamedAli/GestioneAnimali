package it.gestioneCavalli.web.servlet.gravidanza;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.service.GravidanzaService;
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteModificaGravidanzaServlet
 */
@WebServlet("/eseModificaGravidanzaSer")
public class ExecuteModificaGravidanzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	public ExecuteModificaGravidanzaServlet() {
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
		String stallonePadre = request.getParameter("padreInput");
		String fatrice = request.getParameter("fatriceInput");
		Date dataInizio = Utils.parseDate(request.getParameter("dataInizioInput"));
		Date dataFine = Utils.parseDate(request.getParameter("dataFineInput"));
		String puledro = request.getParameter("puledroInput");
		
		Gravidanza gravidanza = gravidanzaService.caricaConId(id);
		gravidanza.setStallonePadre(stallonePadre);
		gravidanza.setFatrice(fatrice);
		gravidanza.setDataInizio(dataInizio);
		gravidanza.setDataFine(dataFine);
		gravidanza.setPuledro(puledro);
		gravidanzaService.aggiorna(gravidanza);
		
		List<Gravidanza> gravidanze = gravidanzaService.cercaByExample(new GravidanzaDTO());
		request.setAttribute("listaGravidanzeAttr", gravidanze);
		request.setAttribute("messaggioConferma", "Modifica avvenuta con successo");
		request.getRequestDispatcher("/gravidanza/listaGravidanze.jsp").forward(request, response);
	}

}
