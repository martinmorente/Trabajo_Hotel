/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guarderiaJunior.controllers;

import com.guarderiaJunior.Clases.Personal;
import com.guarderiaJunior.Models.personalRepository;
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

/**
 *
 * @author Coral
 */
@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private personalRepository personalRepository;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        Optional<Personal> personal = personalRepository.findById(id);
        return personal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping /*Crear hotel*/
    public ResponseEntity<Personal> createPersonal(@RequestBody Personal personal) {
        Personal savedPersonal = personalRepository.save(personal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        if (!personalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable Long id, @RequestBody Personal updatedPersonal) {
        if (!personalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedPersonal.setIdPersonal(id);
        Personal savedPersonal = personalRepository.save(updatedPersonal);
        return ResponseEntity.ok(savedPersonal);
    }
}
