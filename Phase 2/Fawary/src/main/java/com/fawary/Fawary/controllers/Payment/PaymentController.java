package com.fawary.Fawary.controllers.Payment;
import com.fawary.Fawary.BSL.Payment.Cash;
import com.fawary.Fawary.BSL.Payment.CreditCard;
import com.fawary.Fawary.BSL.Payment.PaymentResponse;
import com.fawary.Fawary.Models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController

@RequestMapping("user/pay")
public class PaymentController {
    @PostMapping("/")
    public HashMap<String, Transaction> payment(@RequestParam("method") String method,
                                                @RequestParam("serviceMoney") double ServiceMoney,
                                                @RequestParam("serviceName") String serviceName,
                                                @RequestParam("serviceProvider") String serviceProvider)
    {
           PaymentResponse paymentResponse;
           paymentResponse = new Cash();   //dummy
           return paymentResponse.payment(method,ServiceMoney,serviceName,serviceProvider);
    }
}
