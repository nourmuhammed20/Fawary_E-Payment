package com.fawary.Fawary.controllers.Transactions;

import com.fawary.Fawary.BSL.TransactionsBSL.RefundBL;
import com.fawary.Fawary.Models.Transaction;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;



@RestController
public class RefundController {
    RefundBL refundBL = new RefundBL();

    @PutMapping("user/refunds/add")
    public   HashMap<String,String> AddRefund(@RequestParam("id") int id){
        return  refundBL.addRefund(id);
    }
    @PutMapping("admin/refunds/accept")
        public HashMap<String,String> AcceptRefund(@RequestParam("id") int id){
           return refundBL.acceptRefund(id);
        }


    @PutMapping("admin/refunds/reject")
        public HashMap<String,String> RejectRefund(@RequestParam("id") int id){
        return refundBL.rejectRefund(id);
        }

    @GetMapping("user/refunds/notifications")
        public HashMap<String,ArrayList<Transaction>> updateNotfication()
        { return refundBL.notifications();}

    @GetMapping(value="admin/refunds/")
    public  HashMap<String,ArrayList<Transaction>> ListRefunds(){
        return refundBL.refundslist();
    }
}
