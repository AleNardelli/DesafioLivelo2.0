package com.livelo.service;

import com.livelo.exception.ResourceNotFoundException;
import com.livelo.form.ClientForm;
import com.livelo.dto.ClientDto;
import com.livelo.model.Client;
import com.livelo.repository.ClientRepository;
import com.livelo.validation.ValidationAge;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ValidationAge validationAge;

    public ClientDto register(ClientForm Form){
        Client client = modelMapper.map(Form, Client.class);
        validationAge.validate(client);
        this.clientRepository.save(client);
        return modelMapper.map(client, ClientDto.class);
    }

    public List<ClientDto> findAll() {
        List<Client> client = clientRepository.findAll();
        return client.stream().map(c -> modelMapper.map(c, ClientDto.class)).collect(Collectors.toList());
    }

    public ClientDto findClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found::" + id));
        return modelMapper.map(client, ClientDto.class);
    }


    public List<ClientDto> findByName(String name) {
        List<ClientDto> result = new ArrayList<>();
        List<Client> findByName = clientRepository.findByName(name);
        if (!findByName.isEmpty()) {
            findByName.forEach(f -> result.add(modelMapper.map(f, ClientDto.class)));
        }
        return result;
    }

    public void delete(@PathVariable Long id) {
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()) {
            clientRepository.deleteById(id);
        }
    }


}
