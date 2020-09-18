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

import it.gestioneCavalli.model.Documento;
import it.gestioneCavalli.service.DocumentoService;

/**
 * Servlet implementation class ExecuteModificaDocumentoServlet
 */
@WebServlet("/eseModificaDocumentoSer")
public class ExecuteModificaDocumentoServlet extends HttpServlet {
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
	public ExecuteModificaDocumentoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idCavallo = Long.parseLong(request.getParameter("idCavallo"));
		String nomeCavallo = request.getParameter("nomeCavallo");
		Long idDocumento = Long.parseLong(request.getParameter("idDocumento"));
		String faldone = request.getParameter("faldoneInput");
		String documento = request.getParameter("documentoInput");
		String note = request.getParameter("noteInput");
		Documento doc = new Documento();
		doc.setId(idDocumento);
		doc.setFaldone(faldone);
		doc.setDocumento(documento);
		doc.setNote(note);

		documentoService.aggiorna(doc);
		List<Documento> documenti = documentoService.listaConIdCavallo(idCavallo);

		request.setAttribute("listaDocumentiAttr", documenti);
		request.setAttribute("messaggioConferma", "Modifica avvenuto con successo");
		request.setAttribute("idCavallo", idCavallo);
		request.setAttribute("nomeCavallo", nomeCavallo);
		request.setAttribute("listAll", true);
		request.getRequestDispatcher("/documento/listaDocumenti.jsp").forward(request, response);

	}

}
