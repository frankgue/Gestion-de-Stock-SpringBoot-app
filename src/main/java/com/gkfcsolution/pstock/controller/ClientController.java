package com.gkfcsolution.pstock.controller;

import com.gkfcsolution.pstock.entity.Client;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.ClientRepository;
import com.gkfcsolution.pstock.repository.ClientRepository;
import com.gkfcsolution.pstock.service.ClientService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.*;

/**
 * Created on 2025 at 15:21
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 15:21
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        log.info("Get all Clients ...");
        return service.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(value = "id") Long clientId){
        Client client = service.getClient(clientId);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client){
        return service.createClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId) throws ResourceNotFound {
        service.deleteClient(clientId);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }

    @DeleteMapping("/clients/delete")
    public ResponseEntity<String> deleteAllClients() throws ResourceNotFound{
        service.deleteAllClients();
        return new ResponseEntity<>("All Clients have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId, @Valid @RequestBody Client client) throws ResourceNotFound {
        log.info("Update Client with ID = " + clientId + "....");

        Client updateClient = service.updateClient(clientId, client);

        if (updateClient != null){

            return new ResponseEntity<>(updateClient, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
