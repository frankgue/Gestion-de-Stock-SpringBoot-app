package com.gkfcsolution.pstock.service.impl;

import com.gkfcsolution.pstock.entity.Client;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;
import com.gkfcsolution.pstock.repository.ClientRepository;
import com.gkfcsolution.pstock.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2025 at 18:24
 * File: ClientServiceImpl.java.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:24
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Override
    public Client createClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client updateClient(Long clientId, Client client) throws ResourceNotFound {
        log.info("Update Client with ID = " + clientId + "....");

        Optional<Client> clientInfo = repository.findById(clientId);
        if (clientInfo.isPresent()){
            Client clientResult = clientInfo.get();
            clientResult.setLibelle(client.getLibelle());
            clientResult.setCode(client.getCode());
            clientResult.setAsuj(client.getAsuj());
            clientResult.setEmail(client.getEmail());
            clientResult.setAdresse(client.getAdresse());
            clientResult.setContact(client.getContact());
            clientResult.setLogin(client.getLogin());
            clientResult.setSolde(client.getSolde());
            clientResult.setMatfisc(client.getMatfisc());
            clientResult.setSoldeInit(client.getSoldeInit());
            clientResult.setTel(client.getTel());
            clientResult.setPwd(client.getPwd());
            clientResult.setTimbre(client.getTimbre());

            return repository.save(clientResult);

        } else {
            throw  new ResourceNotFound("Client not found");
        }
    }

    @Override
    public Client getClient(Long clientId) {
        return repository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = repository.findById(clientId).orElseThrow(() -> new ResolutionException("Client not found"));
        repository.delete(client);
    }

    @Override
    public void deleteAllClients() {
        repository.deleteAll();
    }
}
