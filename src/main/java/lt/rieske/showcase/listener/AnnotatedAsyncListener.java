package lt.rieske.showcase.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class AnnotatedAsyncListener implements AsyncListener {

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedAsyncListener.class);

	@Override
	public void onComplete(AsyncEvent asyncEvent) throws IOException {
		LOG.debug("AnnotatedAsyncListener.onComplete({})", asyncEvent);
	}

	@Override
	public void onError(AsyncEvent asyncEvent) throws IOException {
		LOG.debug("AnnotatedAsyncListener.onError({})", asyncEvent);
	}

	@Override
	public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
		LOG.debug("AnnotatedAsyncListener.onStartAsync({})", asyncEvent);
	}

	@Override
	public void onTimeout(AsyncEvent asyncEvent) throws IOException {
		LOG.debug("AnnotatedAsyncListener.onTimeout({})", asyncEvent);
		asyncEvent.getAsyncContext().getResponse().getWriter().println("Timeout in async processing");
	}

}
