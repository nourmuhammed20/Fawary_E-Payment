package com.fawary.Fawary.controllers.Transactions;

import com.fawary.Fawary.BSL.TransactionsBSL.TransactionBL;
import com.fawary.Fawary.Models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
@RestController
@RequestMapping("admin/transactions")
public class TransactionController {
    @GetMapping(value="/")
    public HashMap<String,ArrayList<Transaction>> ListTrans(){
        TransactionBL transactionBL = new TransactionBL();
        return transactionBL.listTransaction();
    }
}
