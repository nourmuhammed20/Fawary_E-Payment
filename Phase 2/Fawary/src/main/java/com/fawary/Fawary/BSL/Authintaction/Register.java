package com.fawary.Fawary.BSL.Authintaction;

import com.fawary.Fawary.Models.Users;

public class Register {
    boolean flag;
    public boolean registerCheck(String username, String Password, String email, double credit, double wallet){
        Users u1 = new Users();
        if (Users.UsersArray.isEmpty()) {
            if(username.equals("admin")){
                u1.setAdmin(true);
            }
            u1.setUsername(username);
            u1.setPassword(Password);
            u1.setEmail(email);
            u1.setCredit(credit);
            u1.setWallet(wallet);
            Users.UsersArray.add(u1);
            flag=true;
        }
        else {
            for (int i = 0; i < Users.UsersArray.size(); i++) {
                if (Users.UsersArray.get(i).getUsername().equals(username)&&Users.UsersArray.get(i).getEmail().equals(email))
                {
                    flag=false;
                    break;
                }
                else if(username.equals("admin")){

                    u1.setUsername(username);
                    u1.setPassword(Password);
                    u1.setEmail(email);
                    u1.setAdmin(true);
                    Users.UsersArray.add(u1);
                    flag=true;
                    break;
                }
                else
                {
                    u1.setUsername(username);
                    u1.setPassword(Password);
                    u1.setEmail(email);
                    u1.setCredit(credit);
                    u1.setWallet(wallet);
                    Users.UsersArray.add(u1);
                    u1.setAdmin(false);
                    flag=true;
                    break;
                }
            }
        }
            return flag;
    }
}


