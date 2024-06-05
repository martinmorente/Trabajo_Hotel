
package com.guarderiaJunior.Hotel.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guarderiaJunior.Hotel.Clases.Reservas;

public interface reservaRepository extends JpaRepository<Reservas,Long> {}
