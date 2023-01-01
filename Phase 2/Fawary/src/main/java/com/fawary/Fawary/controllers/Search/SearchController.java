package com.fawary.Fawary.controllers.Search;
import com.fawary.Fawary.BSL.Search.SearchBSL;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("user/search")
public class SearchController {


@GetMapping("/")
    public  ArrayList<String> search(@RequestParam("reqservice") String ReqService){
        ArrayList<String> foundedStrings= new ArrayList<String>();

        foundedStrings= SearchBSL.getString(ReqService);

        if(foundedStrings.size()!=0){
            return foundedStrings;
        }
        else {
            return null;
        }
    }
}
