package com.fawary.Fawary.BSL.Search;

import java.util.ArrayList;
import java.util.Locale;

public class SearchBSL {
    //Next Method used to Get all possible substring from the Saved Services To enhance Search
    public static ArrayList<String> getString(String substr){
        ArrayList<String> serviceslist=new   ArrayList <String>();
        serviceslist.add("Internet Payment");
        serviceslist.add("Mobile Recharge");
        serviceslist.add("Landline");
        serviceslist.add("Donations");

        ArrayList<String> foundedStrings=new ArrayList<String>();
        substr=substr.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        for(int i=0;i<serviceslist.size();i++){
            String tmp= serviceslist.get(i).toLowerCase(Locale.ROOT).replaceAll("\\s", "");
            if(tmp.contains(substr))
            {
                foundedStrings.add(serviceslist.get(i));
            }
        }
        return foundedStrings;
    }
}
