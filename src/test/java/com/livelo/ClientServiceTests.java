package com.livelo;

import com.livelo.dto.ClientDto;
import com.livelo.model.Client;
import com.livelo.modelMapper.ConfigModelMapper;
import com.livelo.repository.ClientRepository;
import com.livelo.service.ClientService;
import com.livelo.validation.ValidationAge;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.*;

@ContextConfiguration (classes = {ClientService.class, ModelMapper.class, ConfigModelMapper.class, ValidationAge.class})
@ExtendWith( MockitoExtension.class)
public class ClientServiceTests {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ValidationAge validationAge;

    @Test
    public void testClientRegister() {
        var client = TestUtils.newClient();
        var clientForm = TestUtils.newClientForm();
        var clientDto = TestUtils.newClientDto();

        doNothing().when(this.validationAge).validate((Client)client);
        when(modelMapper.map(clientForm, Client.class)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(modelMapper.map(client, ClientDto.class)).thenReturn(clientDto);
        clientService.register(clientForm);
        verify(this.validationAge).validate((Client) client);
        verify(clientRepository, times(1)).save(client);
        verify(modelMapper, times(1)).map(client, ClientDto.class);
    }

    @Test
    public void testCompleteListClients() {
        var clients = TestUtils.list();
        when(clientRepository.findAll()).thenReturn(clients);
        clientService.findAll();
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void testFindClientsByName() {
        var clients = TestUtils.list();
        var name = "Erika";
        when(clientRepository.findByName(name)).thenReturn(clients);
        clientService.findByName(name);
        verify(clientRepository, times(1)).findByName(name);
    }

    @Test
    public void testFindClientById() {
        var search = TestUtils.search();
        var client = TestUtils.newClient();
        var clientDto = TestUtils.newClientDto();

        when(clientRepository.findById(1L)).thenReturn(search);
        when(modelMapper.map(client, ClientDto.class)).thenReturn(clientDto);
        clientService.findClientById(1L);
        verify(clientRepository, times(1)).findById(1L);
        verify(modelMapper, times(1)).map(client, ClientDto.class);
    }
}
