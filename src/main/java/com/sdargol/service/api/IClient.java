package com.sdargol.service.api;

import com.sdargol.dto.ClientDTO;

import java.util.List;

public interface IClient {
    ClientDTO create(ClientDTO client);
    ClientDTO getByLogin(String login);
    ClientDTO update(ClientDTO client);
    ClientDTO delete(String login);
    List<ClientDTO> getAll();
}
