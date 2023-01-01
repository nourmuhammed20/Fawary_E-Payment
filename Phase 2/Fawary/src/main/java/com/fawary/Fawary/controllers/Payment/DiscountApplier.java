package com.fawary.Fawary.controllers.Payment;

import com.fawary.Fawary.BSL.Payment.DiscountBL;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountApplier {
    @PutMapping("admin/apply/discount")
    public String applySpecDiscount(@RequestParam ("ServiceName") String servicename){
        DiscountBL discountBL =new DiscountBL();
        discountBL.setServiceDiscount(servicename);
        return discountBL.setServiceDiscount(servicename);
    }
}
