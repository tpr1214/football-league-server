package org.example.footballleague.Service;

import org.example.footballleague.repositories.UserRepository;
import org.example.footballleague.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // בודק אם הDB אם המשתמש כבר קיים בבסיס הנתונים

        public boolean register(User user) {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                return false; // נכשלו, האימייל תפוס
            }

            user.setBalance(1000.0);
            userRepository.save(user); // שומרים בדאטאבייס
            return true; // הצלחנו!
        }
    }

