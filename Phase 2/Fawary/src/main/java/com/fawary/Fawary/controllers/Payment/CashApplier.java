package com.fawary.Fawary.controllers.Payment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CashApplier {
    public static ArrayList<String> CashService = new ArrayList<>();
    @PostMapping("admin/services/cash/apply")
    public ArrayList<String> setCashService(@RequestParam String cashService) {
        CashService.add(cashService);
        return CashService;
    }

    public boolean AcceptCash(String s){  // User Service name String
        boolean flag =false;
        for(int i =0;i<CashService.size();i++){
            if (CashService.get(i).equals(s)) {
                flag = true; // check User Service name == Admin Service name String
                break;
            }
        }
        return flag;
    }
}
