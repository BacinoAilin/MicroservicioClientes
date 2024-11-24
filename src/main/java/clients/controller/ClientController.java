package clients.controller;


import clients.dto.ClientWithDeathDateResponse;
import clients.dto.KpiClientsResponse;
import clients.entity.Client;
import clients.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "API for managing clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/createClient")
    @Operation(summary = "Create a new client", responses = {
            @ApiResponse(responseCode = "200", description = "Client created successfully")
    })
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/clients")
    @Operation(summary = "Get a list of all clients", responses = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully")
    })
    public List<Client> listClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/kpiclients")
    @Operation(summary = "Get KPI of clients", responses = {
            @ApiResponse(responseCode = "200", description = "KPI retrieved successfully")
    })
    public KpiClientsResponse getKpiClients() {
        return clientService.getKpiClients();
    }

    @GetMapping("/clients/deathdate")
    @Operation(summary = "Get clients with probable death dates", responses = {
            @ApiResponse(responseCode = "200", description = "List with death dates retrieved successfully")
    })
    public List<ClientWithDeathDateResponse> listClientsWithDeathDate() {
        return clientService.getClientsWithDeathDate();
    }
}
