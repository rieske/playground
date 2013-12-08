package lt.rieske.showcase.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class AnnotatedServletContextListener implements ServletContextListener {

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedServletContextListener.class);

	private static final int THREAD_POOL_SIZE = 10;

	public static final String ATTR_EXECUTOR_SERVICE = "executorService";

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LOG.debug("AnnotatedServletContextListener.contextInitialized({})", servletContextEvent);
		ExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
		servletContextEvent.getServletContext().setAttribute(ATTR_EXECUTOR_SERVICE, executorService);

		LOG.debug("servletContext.getInitParameter(\"contextParam\"): {}", servletContextEvent.getServletContext().getInitParameter("contextParam"));
		LOG.debug("servletContext.getAttribute(\"contextParam\"): {}", servletContextEvent.getServletContext().getAttribute("contextParam"));
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		LOG.debug("AnnotatedServletContextListener.contextDestroyed({})", servletContextEvent);
		ExecutorService executorService = (ExecutorService) servletContextEvent.getServletContext().getAttribute(ATTR_EXECUTOR_SERVICE);
		executorService.shutdown();
	}

}
