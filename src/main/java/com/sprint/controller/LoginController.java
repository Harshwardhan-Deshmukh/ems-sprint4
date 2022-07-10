package com.sprint.controller;

import com.sprint.entity.Login;
import com.sprint.repository.EmployeeRepository;
import com.sprint.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("login")
    public List<Login> listAllLoginRecords() {
        return loginService.fetchLoginList();
    }

    @GetMapping("login/{id}")
    public String fetchLoginUsernameById(@PathVariable("id") Long loginId) {
        return loginService.fetchLoginUsernameById(loginId);
    }

    @PostMapping("login")
    public Login addLoginData(@RequestParam(value = "empId") Long empId ,@Valid @RequestBody Login login) {
        login.setEmployee(employeeRepository.findById(empId).get());
        return loginService.addLoginData(login);
    }

    @PutMapping("login/update/{username}")
    public Login updateLogin(@RequestBody Login login, @PathVariable("username") String loginUsername) {
        return loginService.updatePasswordByLoginUsername(login, loginUsername);
    }

}
