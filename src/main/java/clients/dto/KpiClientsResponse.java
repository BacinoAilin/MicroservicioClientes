package clients.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KpiClientsResponse {

    private double averageAge;
    private double standardDeviation;
}
