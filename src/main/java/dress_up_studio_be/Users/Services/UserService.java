package dress_up_studio_be.Users.Services;

import dress_up_studio_be.JWT.JwtService;
import dress_up_studio_be.Users.Models.UserDocument;
import dress_up_studio_be.Users.Models.UserRequest;
import dress_up_studio_be.Users.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void saveUserDocument(UserRequest userRequest) {
        UserDocument userDocument = modelMapper.map(userRequest, UserDocument.class);
        userDocument.setPassword(encoder.encode(userDocument.getPassword()));
        userRepository.save(userDocument);
    }

    public String verifyUser(UserRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        }
        return "User not found";
    }
}
