package com.codecool.elproyectegrandesprint.javatomatams.service;

import com.codecool.elproyectegrandesprint.javatomatams.model.Client;
import com.codecool.elproyectegrandesprint.javatomatams.model.LogInDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.Role;
import com.codecool.elproyectegrandesprint.javatomatams.repositoryDAO.ClientRepository;
import com.codecool.elproyectegrandesprint.javatomatams.security.ClientDetailsService;
import com.codecool.elproyectegrandesprint.javatomatams.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientDetailsService clientDetailsService;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, ClientDetailsService clientDetailsService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.clientDetailsService = clientDetailsService;
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

}
