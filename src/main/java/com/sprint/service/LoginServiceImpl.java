package com.sprint.service;

import com.sprint.entity.Login;
import com.sprint.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public List<Login> fetchLoginList() {
        return loginRepository.findAll();
    }

    @Override
    public Login addLoginData(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public String fetchLoginUsernameById(Long loginId) {
        Login login =  loginRepository.findById(loginId).get();
        return login.getLoginUsername();
    }

    @Override
    public Login updatePasswordByLoginUsername(Login login, String loginUsername) {
        Login loginFromDb = loginRepository.findByLoginUsername(loginUsername);
        loginFromDb.setLoginPassword(login.getLoginPassword());

        return loginRepository.save(login);
    }

}
