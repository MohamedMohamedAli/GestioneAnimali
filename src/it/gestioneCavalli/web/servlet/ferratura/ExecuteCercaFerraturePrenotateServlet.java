package it.gestioneCavalli.web.servlet.ferratura;

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

import it.gestioneCavalli.dto.FerraturaDTO;
import it.gestioneCavalli.model.Ferratura;
import it.gestioneCavalli.service.FerraturaService;

/**
 * Servlet implementation class ExecuteCercaFerraturePrenotateServlet
 */
@WebServlet("/eseCercaFerraturePrenotateSer")
public class ExecuteCercaFerraturePrenotateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FerraturaService ferraturaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCercaFerraturePrenotateServlet() {
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
		String dataDa = request.getParameter("dataDaInput");
		String dataA = request.getParameter("dataAInput");
		String tipo = request.getParameter("tipoInput");

		FerraturaDTO ferratura = new FerraturaDTO();
		ferratura.setDataDa(dataDa);
		ferratura.setDataA(dataA);
		ferratura.setTipo(tipo);
		List<Ferratura> ferrature = ferraturaService.cercaByExamplePrenotate(ferratura);

		request.setAttribute("listaFerratureAttr", ferrature);
		request.getRequestDispatcher("/ferratura/ferraturePrenotate.jsp").forward(request, response);
	}

}
