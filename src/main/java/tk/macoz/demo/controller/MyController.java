package tk.macoz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.macoz.demo.bean.Country;
import tk.macoz.demo.service.ICountryService;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private ICountryService countryService;

    @RequestMapping(value="/countries",  method= RequestMethod.GET,
            produces= MediaType.APPLICATION_XML_VALUE)
    public List<Country> listCountries() {

        return countryService.findAll();
    }
}
