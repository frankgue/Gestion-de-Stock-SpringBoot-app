package com.gkfcsolution.pstock.service;

import com.gkfcsolution.pstock.entity.Client;
import com.gkfcsolution.pstock.exceptions.ResourceNotFound;

import java.util.List;

/**
 * Created on 2025 at 18:20
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 18:20
 */
public interface ClientService {
    Client createClient( Client client);
    Client updateClient(Long clientId,  Client client) throws ResourceNotFound;
    Client getClient( Long clientId);
    List<Client> getAllClients();
    void deleteClient( Long clientId);
    void deleteAllClients();
}
