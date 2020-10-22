//package be.multimedi.jammik.klant;
//
//
//import be.multimedi.jammik.jwt.JwtConfig;
//import be.multimedi.jammik.jwt.JwtSecretKey;
//import be.multimedi.jammik.jwt.JwtUsernameAndPasswordAuthenticationFilter;
//import be.multimedi.jammik.jwt.UsernameAndPasswordAuthenticationRequest;
//import be.multimedi.jammik.repository.KlantRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.crypto.SecretKey;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/login")
//@CrossOrigin()
//public class LoginController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    KlantRepository klantRepository;
//
//
//    @Autowired
//    PasswordEncoder encoder;
//
////    @Autowired
////    JwtUtils jwtUtils;
//
//    @Autowired
//    JwtConfig jwtConfig;
//
//    @Autowired
//    SecretKey secretKey;
//
//    @PostMapping("")
//    public ResponseEntity<?> authenticateUser( @RequestBody UsernameAndPasswordAuthenticationRequest loginRequest) {
//
//        new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager,jwtConfig,secretKey);
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }
//
//
//
//}
