package dress_up_studio_be.Users.Services;

import dress_up_studio_be.JWT.JwtService;
import dress_up_studio_be.Users.Models.Role;
import dress_up_studio_be.Users.Models.UserEntity;
import dress_up_studio_be.Users.Models.UserRequest;
import dress_up_studio_be.Users.Repository.UserRepository;
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

    public void saveUserDocument(UserRequest registerRequest) {
        UserEntity userEntity = modelMapper.map(registerRequest, UserEntity.class);
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userEntity.setRole(Role.USER);
        userRepository.save(userEntity);
    }

    public String verifyUser(UserRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()));
        System.out.println(authenticate.getAuthorities());


        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getEmail());
        }
        return "User not found";
    }
}
