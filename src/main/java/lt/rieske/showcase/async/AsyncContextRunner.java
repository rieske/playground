package lt.rieske.showcase.async;

import java.io.IOException;

import javax.servlet.AsyncContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncContextRunner implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(AsyncContextRunner.class);

	private final AsyncContext asyncContext;
	private final int processingTime;

	public AsyncContextRunner(AsyncContext asyncContext, int processingTime) {
		this.asyncContext = asyncContext;
		this.processingTime = processingTime;
	}

	@Override
	public void run() {
		LOG.debug("AsyncContextRunner.run()");

		longProcessing();

		try {
			LOG.debug("AsyncContextRunner printing to response output");
			asyncContext.getResponse().getWriter().println("AsyncContextRunner processing done for " + processingTime + " milliseconds");
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}
		asyncContext.complete();
	}

	private void longProcessing() {
		try {
			Thread.sleep(processingTime);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
