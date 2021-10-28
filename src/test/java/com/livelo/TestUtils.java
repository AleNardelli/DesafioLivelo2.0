package com.livelo;

import com.livelo.form.ClientForm;
import com.livelo.dto.ClientDto;
import com.livelo.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestUtils {

    public static Client newClient() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Erika");
        client.setBirth(LocalDate.of(2000, 12, 12));
        client.setSex('F');
        client.setCity("Curitiba");

        return client;
    }

    public static ClientDto newClientDto() {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(newClient().getId());
        clientDto.setName(newClient().getName());
        clientDto.setBirth(newClient().getBirth());
        clientDto.setSex(newClient().getSex());
        clientDto.setCity(newClient().getCity());

        return clientDto;
    }

    public static ClientForm newClientForm() {
        ClientForm clientForm = new ClientForm();
        clientForm.setName(newClient().getName());
        clientForm.setBirth(newClient().getBirth());
        clientForm.setSex(newClient().getSex());
        clientForm.setCity(newClient().getCity());

        return clientForm;
    }

    public static List<Client> list() {
        List<Client> clients = new ArrayList<>();
        clients.add(newClient());
        return clients;
    }

    public static Optional<Client> search() {
        return Optional.of(newClient());
    }
}
