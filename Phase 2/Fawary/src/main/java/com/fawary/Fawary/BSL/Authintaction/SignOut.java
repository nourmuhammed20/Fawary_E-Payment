package com.fawary.Fawary.BSL.Authintaction;


import com.fawary.Fawary.Models.Users;
import org.springframework.stereotype.Service;

import static com.fawary.Fawary.Models.Users.UsersArray;
@Service
public class SignOut {
    public String leave(){
        for (Users i : UsersArray){
            if(i.getUsername().equals(Users.getCurrentUser()))
            {
                i.setLogged(false);
            }
        }
        Users.setCurrentUser(null);
        return "Signed Out";
    }

}
