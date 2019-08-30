package com.example.petclinic;

import com.example.petclinic.controller.VisitController;
import com.example.petclinic.model.Visit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class PetClinicVisit {

    private static ConfigurableApplicationContext context;

    private static VisitController visitController;

    public static void main(String[] args) {

        context = SpringApplication.run(PetClinicVisit.class, args);

        generateData();

    }

    public static void generateData() {

        visitController = (VisitController) context.getBean("visitController");

        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("Nice Visit!").build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit3 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit4 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();

        visitController.add(visit1);
        visitController.add(visit2);
        visitController.add(visit3);
        visitController.add(visit4);

    }
}
