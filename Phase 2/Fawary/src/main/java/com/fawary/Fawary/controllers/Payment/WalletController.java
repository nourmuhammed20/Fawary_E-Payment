package com.fawary.Fawary.controllers.Payment;

import com.fawary.Fawary.BSL.Payment.WalletBL;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class WalletController {
    WalletBL walletBL = new WalletBL();
    @PutMapping("user/wallet/add")
    public HashMap<String,String> addWalletBalance(@RequestParam("walletValue") double value){
        return walletBL.chargeWallet(value);
    }
    @GetMapping("admin/wallet/alltrans")
    public HashMap<String,HashMap<String,Double>> listWalletTransactions(){
            return walletBL.listWalletTrans();
    }

}


