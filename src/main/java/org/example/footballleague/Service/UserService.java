package org.example.footballleague.Service;

import org.example.footballleague.model.User;
import org.example.footballleague.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional   // ← זה הקריטי!
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user) {
        System.out.println("🔍 Checking if email exists: " + user.getEmail());

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            System.out.println("❌ Email already exists!");
            return false;
        }

        user.setBalance(1000.0);

        System.out.println("💾 Saving new user: " + user.getUsername() + " | " + user.getEmail());

        User savedUser = userRepository.save(user);

        System.out.println("✅ User saved successfully! ID = " + savedUser.getId());

        return true;
    }
}