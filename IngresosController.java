/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.controllers;

import com.example.demo.models.Ingresos_Caja;
import com.example.demo.repositories.ingresosRepository;
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

@RestController
@RequestMapping("/api/Ingresos_Caja")
public class IngresosController {
        @Autowired
    private ingresosRepository ingresosRepository;
    
    @GetMapping
    public List<Ingresos_Caja> getAllIngresos_Caja() {
        return ingresosRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ingresos_Caja> getIngresos_CajaById(@PathVariable Long id) {
        Optional<Ingresos_Caja> ingresos = ingresosRepository.findById(id);
        return ingresos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Ingresos_Caja> createIngresos_Caja(@RequestBody Ingresos_Caja ingresos){
       Ingresos_Caja savedIngresos_Caja = ingresosRepository.save(ingresos);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedIngresos_Caja);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngresos_Caja(@PathVariable Long id) {
        if(!ingresosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ingresosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ingresos_Caja> updateIngresos_Caja(@PathVariable Long id, @RequestBody Ingresos_Caja updatedIngresos_Caja) {
        if(!ingresosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        updatedIngresos_Caja.setId(id);
       Ingresos_Caja savedIngresos_Caja = ingresosRepository.save(updatedIngresos_Caja);
       return ResponseEntity.ok(savedIngresos_Caja);
    }
    
}
