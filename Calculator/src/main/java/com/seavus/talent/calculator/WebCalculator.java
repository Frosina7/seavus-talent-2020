package com.seavus.talent.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebCalculator {

    Integer sum = 0;

    @RequestMapping(path = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody

    public Integer add(@RequestParam Integer p1, @RequestParam Integer p2, @RequestParam Character operator) {

        if (operator == '+') {

            return sum = p1 + p2;

        } else if (operator == '-') {
            
            return sum = p1 - p2;
        }
        return sum;

    }


}
