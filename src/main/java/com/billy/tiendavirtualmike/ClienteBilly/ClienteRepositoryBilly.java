package com.billy.tiendavirtualmike.ClienteBilly;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryBilly extends JpaRepository<ClienteBilly, Long> {

}
