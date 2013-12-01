package lt.rieske.showcase.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.rieske.showcase.async.AsyncContextRunner;
import lt.rieske.showcase.listener.AnnotatedAsyncListener;
import lt.rieske.showcase.listener.AnnotatedServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = AnnotatedAsyncServlet.SERVLET_MAPPING, asyncSupported = true)
public class AnnotatedAsyncServlet extends HttpServlet {

	private static final long serialVersionUID = -4820631585065659774L;

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedAsyncServlet.class);

	public static final String SERVLET_MAPPING = "/asyncServlet";

	private static final int ASYNC_TIMEOUT = 9000;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("AnnotatedAsyncServlet.doGet({}, {})", req, resp);
		long startTime = System.currentTimeMillis();

		String timeParam = req.getParameter("time");
		int msecs = 5000;
		if (timeParam != null) {
			msecs = Integer.valueOf(timeParam);
			if (msecs > 10000) { // max 10 secs
				msecs = 10000;
			}
		}
		
		AsyncContext asyncContext = req.startAsync();
		asyncContext.addListener(new AnnotatedAsyncListener());
		asyncContext.setTimeout(ASYNC_TIMEOUT);
		ExecutorService executorService = (ExecutorService) getServletContext().getAttribute(AnnotatedServletContextListener.ATTR_EXECUTOR_SERVICE);
		executorService.execute(new AsyncContextRunner(asyncContext, msecs));

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		LOG.debug("leaving AnnotatedAsyncServlet.doGet({}, {}), elapsed time: {}ms.", req, resp, elapsedTime);
	}
}
