package models;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = "id")
public class Milestone {
    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}
