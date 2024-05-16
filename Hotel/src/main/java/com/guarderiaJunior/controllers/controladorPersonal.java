
package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guarderiaJunior.Models.personalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;



 @RestController 
 @RequestMapping("/api/personal")
public class controladorPersonal {
   
    @Autowired //Repositorio
    private personalRepository personalRepository;
    
    @GetMapping /*Sintaxis para realizar un select*/
    public List<Personal>getAllPersonal(){
        return personalRepository.findAll();
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id){
        Optional<Personal> personal = personalRepository.findById(id);
        return  personal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }   
}