package com.codecool.elproyectegrandesprint.javatomatams.controller;

import com.codecool.elproyectegrandesprint.javatomatams.model.LogInDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.NewClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.model.UpdateClientDTO;
import com.codecool.elproyectegrandesprint.javatomatams.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public void editClient(@RequestBody UpdateClientDTO updateClientDTO){
        clientService.updateClient(updateClientDTO);
        System.out.println(updateClientDTO.toString());
    }

}
