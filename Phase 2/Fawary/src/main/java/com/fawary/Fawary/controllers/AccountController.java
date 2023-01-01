package com.fawary.Fawary.controllers;

import com.fawary.Fawary.BSL.Authintaction.*;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/auth")
public class AccountController {
    Register reg = new Register();

    @PostMapping(value = {"admin/login","user/login"})
    public String CheckSignin(@RequestParam("username") String username,
                              @RequestParam("Password") String Password) {
        Login log = new Login();
        String response =log.LoginCheck(username,Password);  //Login CHeck Changed to static ?
        return response ;
    }

    @PostMapping(value = {"user/register"})
    public boolean CheckSignup(@RequestParam("username") String username,
                               @RequestParam("Password") String Password,
                               @RequestParam("email") String email,
                               @RequestParam("credit") double credit,
                               @RequestParam("wallet") double wallet) {

        boolean response = reg.registerCheck(username,Password,email,credit,wallet);
        return response ;
    }

    @PutMapping(value={"admin/signout","user/signout"})
    public String signout(){
        SignOut signOut = new SignOut();
        signOut.leave();
        return signOut.leave();
    }

}
