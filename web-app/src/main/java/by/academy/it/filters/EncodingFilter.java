/**
 * 
 */
package by.academy.it.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author shevchenko
 *
 */
public class EncodingFilter implements Filter{

	
	@Override
	public void destroy() {}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
  //Set character encoding as UTF-8
  request.setCharacterEncoding("UTF-8");
  filterChain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {	}

}