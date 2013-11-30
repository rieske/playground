package lt.rieske.showcase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(AnnotatedServlet.SERVLET_MAPPING)
public class AnnotatedServlet extends HttpServlet {

	private static final long serialVersionUID = 3664753015675814710L;

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedServlet.class);

	public static final String SERVLET_MAPPING = "/annotatedServlet";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("AnnotatedServlet.doGet({}, {})", request, response);
		response.getWriter().println(this.getClass().getName() + ".doGet()");
	}

}
