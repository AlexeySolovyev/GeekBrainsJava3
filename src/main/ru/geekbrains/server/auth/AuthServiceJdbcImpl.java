package ru.geekbrains.server.auth;

import ru.geekbrains.server.User;
import ru.geekbrains.server.persistance.UserRepository;

import java.sql.SQLException;

public class AuthServiceJdbcImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceJdbcImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean authUser(User user) {
        User conUser;
            try {
                conUser = userRepository.findByLogin(user.getLogin());
                return conUser.getPassword().equals(user.getPassword());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }
}
