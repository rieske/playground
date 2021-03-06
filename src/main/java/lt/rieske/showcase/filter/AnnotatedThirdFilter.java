package lt.rieske.showcase.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import lt.rieske.showcase.servlet.AnnotatedServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(AnnotatedServlet.SERVLET_MAPPING)
public class AnnotatedThirdFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(AnnotatedThirdFilter.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		LOG.debug("AnnotatedThirdFilter.init({})", config);
	}

	@Override
	public void destroy() {
		LOG.debug("AnnotatedThirdFilter.destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		LOG.debug("AnnotatedThirdFilter.doFilter({}, {}, {})", request, response, chain);
		response.getWriter().println(this.getClass().getName());
		chain.doFilter(request, response);
		response.getWriter().println(this.getClass().getName());
	}
}