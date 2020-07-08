package com.eCommerce.RESTcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.entity.jwt.AuthenticationRequest;
import com.eCommerce.entity.jwt.AuthenticationResponse;
import com.eCommerce.services.JwtSecurityService;

@RestController
@RequestMapping("/authentication-api")
@CrossOrigin(origins = "*")
public class JwtAuthenticationRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtSecurityService jwtSecurityService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			authenticationManager.authenticate(authentication);
		}catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtSecurityService.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
