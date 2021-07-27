package com.sdargol.service;

import com.sdargol.dto.ClientDTO;
import com.sdargol.entity.Client;
import com.sdargol.repository.ClientRepository;
import com.sdargol.service.api.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService implements IClient {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public ClientDTO create(ClientDTO client) {
        if(client.getOrders() == null){
            client.setOrders(new ArrayList<>());
        }
        Client c = Client.dtoToEntity(client);
        clientRepository.save(c);
        return client;
    }

    @Override
    public ClientDTO getByLogin(String login) {
        return ClientDTO.entityToDTO(clientRepository.findByLogin(login));
    }

    @Override
    @Transactional
    public ClientDTO update(ClientDTO client) {
        Client c = clientRepository.findByLogin(client.getLogin());
        c.setLogin(client.getLogin());
        c.setName(client.getName());
        clientRepository.save(c);
        return ClientDTO.entityToDTO(clientRepository.findByLogin(client.getLogin()));
    }

    @Override
    @Transactional
    public ClientDTO delete(String login) {
        Client c = clientRepository.findByLogin(login);
        clientRepository.delete(c);
        return ClientDTO.entityToDTO(c);
    }

    @Override
    public List<ClientDTO> getAll() {
        return ClientDTO.entitiesToListDTO(clientRepository.findAll());
    }
}
