package com.sdargol.controllers;

import com.sdargol.dto.ClientDTO;
import com.sdargol.dto.msg.ContentMessageDTO;
import com.sdargol.service.api.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@CrossOrigin("*")
public class ClientsController {
    private final IClient clientService;

    @Autowired
    public ClientsController(IClient client) {
        this.clientService = client;
    }

    @PostMapping
    public ResponseEntity<ContentMessageDTO<ClientDTO>> createClient(@RequestBody ClientDTO client){
        ContentMessageDTO<ClientDTO> msg = new ContentMessageDTO<>("Client successfully created, login: " + client.getLogin(), clientService.create(client));
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<ContentMessageDTO<List<ClientDTO>>> getAllClients(){
        ContentMessageDTO<List<ClientDTO>> msg = new ContentMessageDTO<>("All clients", clientService.getAll());
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{login}")
    public ResponseEntity<ClientDTO> getClientByLogin(@PathVariable String login){
        return ResponseEntity.ok(clientService.getByLogin(login));
    }

    @PutMapping
    public ResponseEntity<ContentMessageDTO<ClientDTO>> updateClient(@RequestBody ClientDTO client){
        ClientDTO c = clientService.update(client);
        ContentMessageDTO<ClientDTO> msg = new ContentMessageDTO<>("Client successfully updated", c);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<ContentMessageDTO<ClientDTO>> deleteClient(@PathVariable String login){
        ClientDTO c = clientService.delete(login);
        ContentMessageDTO<ClientDTO> msg = new ContentMessageDTO<>("Client successfully deleted, login: " + c.getLogin(), c);
        return ResponseEntity.ok(msg);
    }
}
