package com.fawary.Fawary.BSL.Authintaction;

import com.fawary.Fawary.Models.Users;

public class Login {

    Users u1 = new Users();
    public String LoginCheck(String username, String Password) {

        u1.addAdmin();

        for (int i = 0; i < Users.UsersArray.size(); i++) {


            if (Users.UsersArray.get(i).getUsername().equals(username) && Users.UsersArray.get(i).getPassword().equals(Password) && !Users.UsersArray.get(i).isAdmin()){


                if(!Users.UsersArray.get(i).isLogged()) {
                    Users.setCurrentUser(username);
                    Users.UsersArray.get(i).setLogged(true);
                    return "User Menu"; //true
                }
                return "already logged in";
            }

            else if (Users.UsersArray.get(i).getUsername().equals(username) && Users.UsersArray.get(i).getPassword().equals(Password) && Users.UsersArray.get(i).isAdmin()){

                if(!Users.UsersArray.get(i).isLogged()) {
                    Users.setCurrentUser(username);
                    Users.UsersArray.get(i).setLogged(true);
                    return "Admin Menu"; //false
                }
                return "already logged in";
            }
        }
        return "No Data Found";
    }
}