package it.gestioneCavalli.web.servlet.visita;

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

import it.gestioneCavalli.dto.VisitaDTO;
import it.gestioneCavalli.model.Visita;
import it.gestioneCavalli.service.VisitaService;

/**
 * Servlet implementation class ExecuteCercaVisiteServlet
 */
@WebServlet("/eseCercaVisiteSer")
public class ExecuteCercaVisiteServlet extends HttpServlet {
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
	public ExecuteCercaVisiteServlet() {
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
		String veterinario = request.getParameter("veterinarioInput");
		String dataDa = request.getParameter("dataDaInput");
		String dataA = request.getParameter("dataAInput");
		String causa = request.getParameter("causaInput");
		String trattamento = request.getParameter("trattamentoInput");
		String prezzoDa = request.getParameter("prezzoDaInput");
		String prezzoA = request.getParameter("prezzoAInput");

		VisitaDTO visita = new VisitaDTO(idCavallo, veterinario, dataDa, dataA, causa, trattamento, prezzoDa, prezzoA);
		List<Visita> visite = visitaService.cercaByExample(visita);

		request.setAttribute("listaVisiteAttr", visite);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("idCavallo", idCavallo);
		request.getRequestDispatcher("/visita/listaVisite.jsp").forward(request, response);

	}

}
