package io.zbqmgldjfh.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SecurityController {

    @GetMapping("/login")
    public void login() {}

    @GetMapping("/accessDenied")
    public void accessDenied() {}

    @GetMapping("/logout")
    public void logout() {
    }

    @GetMapping("/adminPage")
    public void admin() {}
}
