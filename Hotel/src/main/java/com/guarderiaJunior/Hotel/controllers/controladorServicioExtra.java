
package com.guarderiaJunior.Hotel.controllers;

import com.guarderiaJunior.Hotel.Clases.ServicioExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guarderiaJunior.Hotel.Models.servicioExtraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 *
 * @author Hugo
 */


@RestController
@RequestMapping("/api/Servicio")

public class controladorServicioExtra {
    
    @Autowired /*Esto nos sirve para evitar usos de punteros this nota: Se pone el repositorio en el que guardas la información*/
    private servicioExtraRepository servicioExtraRepository;
    
    @GetMapping
     public List<ServicioExtra>getAllHotels(){
         return servicioExtraRepository.findAll();
     }
    
     @GetMapping("/{id}")
     public ResponseEntity<ServicioExtra> getHotelById(@PathVariable Long id){/*Si nosotros queremos referenciar al id que tenemos en la linea 25 tendremos que hacer anotaciones*/
         Optional<ServicioExtra> servicioExtra = servicioExtraRepository.findById(id);
         return servicioExtra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }
     @PostMapping
    public ResponseEntity<ServicioExtra> createServicioExtra(@RequestBody ServicioExtra servicioExtra){
       ServicioExtra savedServicioExtra = servicioExtraRepository.save(servicioExtra);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedServicioExtra);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitaciones(@PathVariable Long id) {
        if(!servicioExtraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        servicioExtraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ServicioExtra> updateServicioExtra(@PathVariable Long id, @RequestBody ServicioExtra updatedServicioExtra) {
        if(!servicioExtraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        updatedServicioExtra.setIdServicioExtra(id);
       ServicioExtra savedServicioExtra = servicioExtraRepository.save(updatedServicioExtra);
       return ResponseEntity.ok(savedServicioExtra);
    }
}