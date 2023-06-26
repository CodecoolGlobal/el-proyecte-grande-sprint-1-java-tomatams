package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(NewClientDTO newClientDTO) {
        clientRepository.save(buildClient(newClientDTO));
    }

    private Client buildClient(NewClientDTO newClientDTO) {
        return Client.builder()
                .ID(UUID.randomUUID())
                .name(newClientDTO.name())
                .password(newClientDTO.password())
                .email(newClientDTO.email())
                .build();
    }
}
