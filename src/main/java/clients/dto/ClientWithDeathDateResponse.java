package clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientWithDeathDateResponse {

    private String name;
    private String lastname;
    private int age;
    private LocalDate birthDate;
    private LocalDate probableDeathDate;
}
