package com.sprint.service;

import com.sprint.entity.Login;

import java.util.List;

public interface LoginService {
    List<Login> fetchLoginList();

    Login addLoginData(Login login);

    String fetchLoginUsernameById(Long loginId);

    Login updatePasswordByLoginUsername(Login login, String loginUsername);
}
