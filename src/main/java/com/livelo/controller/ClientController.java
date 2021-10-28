package com.livelo.controller;

import com.livelo.dto.ClientDto;
import com.livelo.form.ClientForm;

import com.livelo.model.Client;
import com.livelo.repository.ClientRepository;
import com.livelo.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

     @Autowired
     private ClientService clientService;

    @PostMapping("/register")
    @ApiOperation(value = "Register Customer")
    public ClientDto clientDto(@RequestBody @Valid ClientForm clientForm, BindingResult bResult) {
        ClientDto clientDto = clientService.register(clientForm);
        return clientDto;
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "Complete Customer List")
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> clientDto = clientService.findAll();
        return ResponseEntity.ok(clientDto);
    }


    @GetMapping("listId/{id}")
    @ApiOperation(value = "Find Costumer By Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requisição bem sucedida."),
            @ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta de informações"),
            @ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado")})
    public ResponseEntity<ClientDto> findById(@PathVariable long id) {
        ClientDto clientDto = clientService.findClientById(id);
        return ResponseEntity.ok(clientDto);
    }


    @GetMapping("listClient/{name}")
    @ApiOperation(value = "Exibe cliente através de um nome válido informado na URL")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Requisição bem sucedida."),
    @ApiResponse(code = 400, message = "Requisição não atendida, dados incorretos ou falta de informações"),
    @ApiResponse(code = 404, message = "Resultado de pesquisa não encontrado")})
    public ResponseEntity<List<ClientDto>> findByName(@Valid @PathVariable String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update Customer")
    public Client updateClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Customer")
    public void deleteClient(@PathVariable(value = "id") long id) {
        clientService.delete(id);
    }
}
