package com.zero.currency.controllers;

import java.io.IOException;
import java.util.List;


import com.zero.currency.models.ConversionOperation;
import com.zero.currency.models.Country;
import com.zero.currency.services.CurrencyService;
import com.zero.currency.services.XmlService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {

    @Autowired
    CurrencyService currencyService;

    @Autowired
    XmlService xmlService;


    @GetMapping({"/","/index"})
    public String usePrincipal(@RequestParam(name = "currencyBase", required = false) String currencyBase,
                               @RequestParam(name = "currencyXchange", required = false) String currencyConversion,
                               @RequestParam(name = "amount", required = false) Float currencyAmount,
                               Model model) {

        if(currencyBase!=null&&currencyConversion!=null&& currencyAmount!=null) {
            model.addAttribute("conversion",currencyService.makeConversion(currencyService.getMoney(currencyAmount, currencyService.getCurrencyUnit(currencyBase)), currencyService.getCurrencyUnit(currencyConversion)).toString());
        }

        try {
            List<Country> countries=xmlService.readXml();
            LogManager.getLogger(this.getClass()).info(">>>Lista paises"+countries.toString());
            model.addAttribute("currencyBase", new Country());
            model.addAttribute("currencyXchange", new Country());
            model.addAttribute("countries",countries);
            model.addAttribute("conversionOperation",new ConversionOperation());

        } catch (IOException e) {
            e.printStackTrace();

        }
        return "index";
    }

    @PostMapping("/makeConversion")
    public String makeConversion(ConversionOperation conversionOperation,Model model) {

        if(conversionOperation!=null) {
            model.addAttribute("conversion",currencyService.makeConversion(currencyService.getMoney(conversionOperation.getAmount(), currencyService.getCurrencyUnit(conversionOperation.getCurrencyBase())), currencyService.getCurrencyUnit(conversionOperation.getCurrencyXchange())).toString());
        }

        try {
            List<Country> countries=xmlService.readXml();
            LogManager.getLogger(this.getClass()).info(">>>Lista paises"+countries.toString());
            model.addAttribute("currencyBase", new Country());
            model.addAttribute("currencyXchange", new Country());
            model.addAttribute("countries",countries);

        } catch (IOException e) {
            e.printStackTrace();

        }
        return "index";
    }





}

