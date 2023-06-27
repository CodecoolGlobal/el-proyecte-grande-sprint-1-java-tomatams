package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.LogInDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/add")
    public void createClient(@RequestBody NewClientDTO newClientDTO) {
        clientService.addClient(newClientDTO);
    }

    @PostMapping("/login")
    public void logInClient(@RequestBody LogInDTO logInDTO) {
        //clientService.addClient(logInDTO);
    }
}
