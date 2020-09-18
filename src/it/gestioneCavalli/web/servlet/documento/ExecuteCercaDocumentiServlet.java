package it.gestioneCavalli.web.servlet.documento;

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

import it.gestioneCavalli.dto.DocumentoDTO;
import it.gestioneCavalli.model.Documento;
import it.gestioneCavalli.service.DocumentoService;

/**
 * Servlet implementation class ExecuteCercaDocumentiServlet
 */
@WebServlet("/eseCercaDocumentiSer")
public class ExecuteCercaDocumentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DocumentoService documentoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCercaDocumentiServlet() {
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
		String faldone = request.getParameter("faldoneInput");
		String documento = request.getParameter("documentoInput");

		DocumentoDTO doc = new DocumentoDTO(idCavallo, faldone, documento);
		List<Documento> documenti = documentoService.cercaByExample(doc);

		request.setAttribute("listaDocumentiAttr", documenti);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("idCavallo", idCavallo);
		request.getRequestDispatcher("/documento/listaDocumenti.jsp").forward(request, response);

	}

}
