package ua.ivashchuk.filter;

import ua.ivashchuk.domain.UserRole;
import ua.ivashchuk.shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/cabinet.jsp")
public class CabinetFilter implements Filter {

    private FilterService filterService = FilterService.getFilterService();


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        filterService.doFilterValidation(req, resp, chain, Arrays.asList(UserRole.USER, UserRole.ADMIN));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
