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
import it.gestioneCavalli.utils.Utils;

/**
 * Servlet implementation class ExecuteCercaGravidanzeServlet
 */
@WebServlet("/eseCercaGravidanzeSer")
public class ExecuteCercaGravidanzeServlet extends HttpServlet {
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
	public ExecuteCercaGravidanzeServlet() {
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
		String stallonePadre = request.getParameter("stallonePadreInput");
		String fatrice = request.getParameter("fatriceInput");
		String puledro = request.getParameter("puledroInput");
		String inizioDa = request.getParameter("dataInizioDaInput");
		String inizioA = request.getParameter("dataInizioAInput");
		String partoDa = request.getParameter("dataPartoDaInput");
		String partoA = request.getParameter("dataPartoAInput");
		System.out.println("data cerca: "+inizioDa+"-------------->"+Utils.parseDate(inizioDa));
		GravidanzaDTO gravidanzaDTO = new GravidanzaDTO(stallonePadre, fatrice, puledro, inizioDa, inizioA, partoDa,
				partoA);

		List<Gravidanza> gravidanze = gravidanzaService.cercaByExample(gravidanzaDTO);
		System.out.println("dimensione lista gravidanze: " + gravidanze.size());
		request.setAttribute("listaGravidanzeAttr", gravidanze);
		request.getRequestDispatcher("/gravidanza/listaGravidanze.jsp").forward(request, response);
	}

}
