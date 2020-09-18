package it.gestioneCavalli.web.servlet.gravidanza;

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

import it.gestioneCavalli.dto.GravidanzaDTO;
import it.gestioneCavalli.model.Gravidanza;
import it.gestioneCavalli.service.GravidanzaService;

/**
 * Servlet implementation class ExecuteEliminaGravidanzaServlet
 */
@WebServlet("/eseEliminaGravidanzaSer")
public class ExecuteEliminaGravidanzaServlet extends HttpServlet {
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
	public ExecuteEliminaGravidanzaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("idGravidanza"));

		gravidanzaService.elimina(id);
		List<Gravidanza> gravidanze = gravidanzaService.cercaByExample(new GravidanzaDTO());

		request.setAttribute("listaGravidanzeAttr", gravidanze);
		request.setAttribute("messaggioConferma", "Eliminazione avvenuta con successo");
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/gravidanza/listaGravidanze.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
