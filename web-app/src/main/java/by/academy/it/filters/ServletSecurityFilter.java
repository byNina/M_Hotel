/**
 *
 */
package by.academy.it.filters;

import by.academy.it.services.UserService;
import by.academy.it.constants.Parameters;
import by.academy.it.constants.AccessLevel;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author shevchenko
 */
public class ServletSecurityFilter implements Filter {
    private static Logger log = Logger.getLogger(UserService.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.debug("In filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession() != null) {
            HttpSession session = req.getSession();
            AccessLevel accessLevel = (AccessLevel) session.getAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE);
            String sideBar = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.GUEST_SIDE_BAR);

            if (accessLevel == null) {

                accessLevel = AccessLevel.GUEST;
                session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
                session.setAttribute(Parameters.SIDE_BAR, sideBar);
                resp.sendRedirect(req.getContextPath() + ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.MAIN_PAGE_PATH));
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
