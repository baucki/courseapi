package com.example.courseapi.service;

import com.example.courseapi.model.entities.Client;
import com.example.courseapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }



}
