package dress_up_studio_be.Users.Services;

import dress_up_studio_be.Users.Models.UserDocument;
import dress_up_studio_be.Users.Models.UserRequest;
import dress_up_studio_be.Users.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void saveUserDocument(UserRequest userRequest) {
        UserDocument userDocument = modelMapper.map(userRequest, UserDocument.class);
        userDocument.setPassword(encoder.encode(userDocument.getPassword()));
        userRepository.save(userDocument);
    }
}
