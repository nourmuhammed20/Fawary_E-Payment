package com.fawary.Fawary.Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {
   protected double WalletCredit;

   public static HashMap<String,Double> WalletTransactions = new HashMap<String,Double>();
   public void setWalletCredit(double walletCredit) {

      this.WalletCredit = walletCredit;

   }
   public double getWalletCredit() {
      return WalletCredit;
   }

}
