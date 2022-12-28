package org.top.ordersapi.model.dao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersapi.model.entity.Client;
import org.top.ordersapi.model.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DbDaoClient implements IDaoClient {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>)clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return (Optional<Client>) clientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Client delete(Integer id) {
        return null;
    }
}
