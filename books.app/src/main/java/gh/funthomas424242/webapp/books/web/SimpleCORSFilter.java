package gh.funthomas424242.webapp.books.web;

/**#%L*Books.App-REST Services*%%*Copyright(C)2015 Pivotal Software,Inc.*%%*This program is free software:you can redistribute it and/or modify*it under the terms of the GNU Lesser General Public License as*published by the Free Software Foundation,either version 3 of the*License,or(at your option)any later version.**This program is distributed in the hope that it will be useful,*but WITHOUT ANY WARRANTY;without even the implied warranty of*MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the*GNU General Lesser Public License for more details.**You should have received a copy of the GNU General Lesser Public*License along with this program.If not,see*<http://www.gnu.org/licenses/lgpl-3.0.html>.
*#L%*/

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Diese Klasse realisiert einen CORS Filter er wird automatisch per ConfigScan
 * gefunden. Mechanismus aus spring-boot (funktioniert ohne Abhängigkeit zu
 * webmvc)
 *
 * @author huluvu424242
 *
 */
@Component
public class SimpleCORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

}