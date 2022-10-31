package tests;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.annotations.Test;

public class MilestoneTest {

    @Test
    public void lombokTest1() {
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("tetete");
        milestone.setDescription("sdfsdf");
        milestone.setCompleted(false);

        Milestone milestone1 = new Milestone();
        milestone1.setId(2);
        milestone1.setName("tetete");
        milestone1.setDescription("sdfsdf");
        milestone1.setCompleted(false);

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
    }

    @Test
    public void lombokTest2() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .id(1)
                .description("sdfsd")
                .name("sdfdsf")
                .build();

        MilestoneBuilder milestone1 = MilestoneBuilder.builder()
                .id(1)
                .description("sdfsd")
                .name("sdfdsf")
                .build();


        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
    }
}
