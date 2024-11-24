package clients.service;

import clients.dto.ClientWithDeathDateResponse;
import clients.dto.KpiClientsResponse;
import clients.entity.Client;
import clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final int lifeExpectancy;
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository,  @Value("${life.expectancy}") int lifeExpectancy) {
        this.clientRepository = clientRepository;
        this.lifeExpectancy = lifeExpectancy;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public KpiClientsResponse getKpiClients() {
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            return new KpiClientsResponse(0, 0);
        }

        double average = clients.stream()
                .mapToInt(Client::getAge)
                .average()
                .orElse(0);

        double variance = clients.stream()
                .mapToDouble(client -> Math.pow(client.getAge() - average, 2))
                .average()
                .orElse(0);

        double standardDeviation = Math.sqrt(variance);

        return new KpiClientsResponse(average, standardDeviation);
    }

    public List<ClientWithDeathDateResponse> getClientsWithDeathDate() {

        return clientRepository.findAll().stream()
                .filter(client -> client.getBirthDate() != null)
                .map(client -> {
                    LocalDate probableDeathDate = client.getBirthDate().plusYears(lifeExpectancy);
                    return new ClientWithDeathDateResponse(
                            client.getName(),
                            client.getLastname(),
                            client.getAge(),
                            client.getBirthDate(),
                            probableDeathDate
                    );
                })
                .collect(Collectors.toList());
    }

}
