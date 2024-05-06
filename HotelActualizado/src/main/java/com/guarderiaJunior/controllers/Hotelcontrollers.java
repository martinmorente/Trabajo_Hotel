
package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Personal;
import com.guarderiaJunior.Models.personalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



 @RestController 
 @RequestMapping("/api/personal")
public class Hotelcontrollers {
   
    @Autowired //Repositorio
    private personalRepository personalRepository;
    
    @GetMapping /*Sintaxis para realizar un select*/
    public List<Personal>getAllPersonal(){
        return personalRepository.findAll();
    }
}