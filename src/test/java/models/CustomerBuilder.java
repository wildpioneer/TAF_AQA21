package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerBuilder {
    private int id;
    private String firstname;
    private String lastName;
    private String email;
    private int age;
}
