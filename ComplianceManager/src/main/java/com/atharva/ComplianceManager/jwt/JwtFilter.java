package com.atharva.ComplianceManager.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final ApplicationContext applicationContext;

    public JwtFilter(JwtUtils jwtUtils, ApplicationContext applicationContext) {
        this.jwtUtils = jwtUtils;
        this.applicationContext = applicationContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String token;
        String jwt = null;
        final String username;

        // 1. Extract JWT token from header
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        token = authHeader.substring(7);

        try{
            //2. Extract username from token
            username = jwtUtils.extractUsername(token);

            System.out.println(username+"-username");

            //3. Check if user is not alreadyy authenticated
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){ // username kiva currentlyAuthenticated users bagel

                // ⚠️ Lazy fetch of userDetailsService to avoid circular dependency
                UserDetailsService userDetailsService = applicationContext.getBean("userDetailsServiceImpl", UserDetailsService.class);

                // Load user from db
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                //Validate token against username
                if (jwtUtils.validateToken(token, userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken  = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Set authentication in context

                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    context.setAuthentication(authenticationToken);
                    SecurityContextHolder.setContext(context);
                }

            }
        } catch (Exception e){
            System.out.println("JWT Filter error"+ e.getMessage());
        }
        filterChain.doFilter(request,response);
    }
}
