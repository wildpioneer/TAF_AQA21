package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode(exclude = "id")
public class MilestoneBuilder {
    private int id;
    private String name;
    private String references;
    private String description;
    private boolean completed;
}
