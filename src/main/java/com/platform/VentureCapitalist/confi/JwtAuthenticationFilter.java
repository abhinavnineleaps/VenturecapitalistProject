package com.platform.VentureCapitalist.confi;


import com.platform.VentureCapitalist.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//WHEN USER REQUEST THE SERVER THIS IS FIRST STEP IN THE SERVER
@Component
@RequiredArgsConstructor // CREATE CONSRUTOR FOR EVRY FINAL FIELD WHICH WE CREATED HERE
//THIS PROVIDE FILTER FOR ONE EVERY REQUEST
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final TokenRepository tokenRepository;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,//THIS REQUEST IS OUR REQUEST
      @NonNull HttpServletResponse response,// THIS RESPONSE IS ALSO OUR RESPONSE
      @NonNull FilterChain filterChain//THIS BASICALLY CONATAIN THE LIST OF THE FILTER
  ) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    //HERE WE ARE CHECKING THAT OUR TOKEN EXCIT OR NOT

    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    //HERE WE ARE EXTRACTING THE JWT TOKEN AND USER NAME IN THE NEXT LINE
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);

    //NOW WE EXTRACTING THE USER FRO TH DATABASE FOR THE VERIFICATION
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
      var isTokenValid = tokenRepository.findByToken(jwt)
          .map(t -> !t.isExpired() && !t.isRevoked())
          .orElse(false);
      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.getAuthorities()
        );
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
