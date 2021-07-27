package com.sdargol.repository;

import com.sdargol.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByLogin(String login);
}
