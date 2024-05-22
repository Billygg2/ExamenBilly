package com.billy.tiendavirtualmike.VentaBilly;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositoryBilly extends JpaRepository<VentaBilly, Long> {
    Optional<VentaBilly> findBynombre(String nombre);
    void deleteBynombre(String nombre);
}
