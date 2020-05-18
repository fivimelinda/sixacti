package propensi.sixacti.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propensi.sixacti.model.ERole;
import propensi.sixacti.model.Roles;
import propensi.sixacti.model.UserModel;
import propensi.sixacti.model.Users;
import propensi.sixacti.payload.request.LoginRequest;
import propensi.sixacti.payload.request.SignupRequest;
import propensi.sixacti.payload.response.JwtResponse;
import propensi.sixacti.payload.response.MessageResponse;
import propensi.sixacti.repository.UserDB;
import propensi.sixacti.repository.Login.RolesRepository;
import propensi.sixacti.repository.Login.UserRepository;
import propensi.sixacti.security.jwt.JwtUtils;
import propensi.sixacti.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDB userDb;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RolesRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		Users users = userRepository.findByUsername(userDetails.getUsername()).orElse(null);

		UserModel user = null;
		if (userDb.findByUsers(users).size() != 0){
			user = userDb.findByUsers(users).get(0);
		}
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 roles,
												 user
                                                 ));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		// Create new user's account
		Users user = new Users(signUpRequest.getUsername(), 
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
//		System.out.println("---------------------------------------");
//		System.out.println(signUpRequest.getUsername());
//		System.out.println(strRoles);
        Set<Roles> roles = new HashSet<>();
        
		if (strRoles == null) {
			Roles userRole = roleRepository.findByRoleName(ERole.ROLE_PELAMAR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
                case "admin":
					Roles adminRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
                case "section manager":
					Roles sectRole = roleRepository.findByRoleName(ERole.ROLE_SECTIONMANAGER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(sectRole);
					break;
                case "assistant manager":
					Roles assistRole = roleRepository.findByRoleName(ERole.ROLE_ASSISTANTMANAGER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(assistRole);
					break;
                case "department manager":
					Roles dptRole = roleRepository.findByRoleName(ERole.ROLE_DEPARTMENTMANAGER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(dptRole);
					break;
                case "karyawan kontrak":
					Roles kontrakRole = roleRepository.findByRoleName(ERole.ROLE_KARYAWANKONTRAK)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(kontrakRole);
					break;
				case "pelamar":
					Roles modRole = roleRepository.findByRoleName(ERole.ROLE_PELAMAR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Roles userRole = roleRepository.findByRoleName(ERole.ROLE_KARYAWANTETAP)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}