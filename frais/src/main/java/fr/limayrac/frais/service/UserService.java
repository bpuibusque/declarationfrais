package fr.limayrac.frais.service;

import fr.limayrac.frais.model.User;
import fr.limayrac.frais.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String password, String role) {
        System.out.println(" Création de l'utilisateur : " + username);
        System.out.println(" Mot de passe encodé : " + passwordEncoder.encode(password));
    
        User user = new User(username, passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
