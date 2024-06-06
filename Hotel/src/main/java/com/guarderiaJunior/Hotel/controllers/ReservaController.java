package com.guarderiaJunior.Hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guarderiaJunior.Hotel.Clases.Reservas;
import com.guarderiaJunior.Hotel.Models.reservaRepository;


/**
 *
 * @author Jose Antonio
 */
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
     @Autowired /*Esto nos sirve para evitar usos de punteros this nota: Se pone el repositorio en el que guardas la información*/
    private reservaRepository reservaRepository;
    
    
    @GetMapping
     public List<Reservas>getAllHotels(){
         return reservaRepository.findAll();
     }
    
     @GetMapping("/{id}")
     public ResponseEntity<Reservas> getHotelById(@PathVariable Long id){/*Si nosotros queremos referenciar al id que tenemos en la linea 25 tendremos que hacer anotaciones*/
         Optional<Reservas> reserva = reservaRepository.findById(id);
         return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }
     
       @PostMapping
    public ResponseEntity<Reservas> createServicioExtra(@RequestBody Reservas reserva){
       Reservas savedReserva = reservaRepository.save(reserva);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedReserva);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        if(!reservaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Reservas> updateServicioExtra(@PathVariable Long id, @RequestBody Reservas updatedReserva) {
        if(!reservaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        updatedReserva.setId(id);
       Reservas savedReserva = reservaRepository.save(updatedReserva);
       return ResponseEntity.ok(savedReserva);
    }
}
