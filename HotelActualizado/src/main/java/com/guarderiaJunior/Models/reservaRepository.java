
package com.guarderiaJunior.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guarderiaJunior.Clases.Reservas;

public interface reservaRepository extends JpaRepository<Reservas,Long> {}
