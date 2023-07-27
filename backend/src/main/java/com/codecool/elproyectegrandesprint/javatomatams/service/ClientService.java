package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.Role;
import com.codecool.elproyectegrandesprint.javatomatams.model.UpdateClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addClient(NewClientDTO newClientDTO) {
        clientRepository.save(buildClient(newClientDTO));
    }

    private Client buildClient(NewClientDTO newClientDTO) {
        return Client.builder()
                .ID(UUID.randomUUID())
                .name(newClientDTO.name())
                .password(passwordEncoder.encode(newClientDTO.password()))
                .email(newClientDTO.email())
                .role(Role.USER)
                .build();
    }

    public void updateClient(UpdateClientDTO updateClientDTO) {
    }
}
