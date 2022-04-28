package ir.caspco.visualization.config.security;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Davood Akbari - 1399
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Value("${visualization.permit.all.url}")
    private String[] permitAllUrls;

    private final JwtTokenProvider jwtTokenProvider;
    private final AntPathMatcher antPathMatcher;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider, AntPathMatcher antPathMatcher) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.antPathMatcher = antPathMatcher;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        final String requestURL = getUrlPath(request);
        if (requestURL.equalsIgnoreCase("/")) {
            response.sendRedirect(request.getContextPath() + "/front");
            return;
        }

        if (isFree(request)) {
            chain.doFilter(request, response);
            return;
        }

        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || header.isEmpty() || !header.startsWith("daakit ")) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
        if (!jwtTokenProvider.validate(token)) {
            chain.doFilter(request, response);
            return;
        }

        // Get user identity and set it on the spring security context
//        UserDetails userDetails = userRepo
//                .findByUsername(jwtTokenProvider.getUsername(token))
//                .orElse(null);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null,
//                userDetails == null ? List.of() : userDetails.getAuthorities()
                null, null, List.of()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    //TODO from davood akbari: Decide to remove the following method. Because if it passes without a header,
    // the framework will be blocked in its security step.
    private boolean isFree(HttpServletRequest request) throws URISyntaxException {
        final String requestURL = getUrlPath(request);

        for (String urlPattern : permitAllUrls) {
            if (antPathMatcher.match(urlPattern, requestURL)) {
                return true;
            }
        }
        return false;
    }

    private String getUrlPath(HttpServletRequest request) throws URISyntaxException {
        final URI uri = new URI(request.getRequestURL().toString());
        return uri.getPath();
    }
}
