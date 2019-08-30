package com.example.petclinic;

import com.example.petclinic.controller.PetController;
import com.example.petclinic.model.Pet;
import com.example.petclinic.model.PetType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class PetClinicPet {

    private static ConfigurableApplicationContext context;

    private static PetController petController;

    public static void main(String[] args) {

        context = SpringApplication.run(PetClinicPet.class, args);

        generateData();
    }

    private static void generateData() {

        petController = (PetController) context.getBean("petController");

        Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).build();
        Pet pet2 = Pet.builder().withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).build();
        Pet pet3 = Pet.builder().withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).build();
        Pet pet4 = Pet.builder().withName("Plopper").withBirthDate(new Date()).withPetType(PetType.PIG).build();

        // Pets for [REDACTED]
        Pet pet5 = Pet.builder().withName("Greyhound").withBirthDate(new Date()).withPetType(PetType.DOG).build();

        // Pets for [MORE REDACTED]
        Pet pet6 = Pet.builder().withName("Laddie").withBirthDate(new Date()).withPetType(PetType.DOG).build();
        Pet pet7 = Pet.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withPetType(PetType.DOG).build();
        Pet pet8 = Pet.builder().withName("Stampy").withBirthDate(new Date()).withPetType(PetType.ELEPHANT).build();
        Pet pet9 = Pet.builder().withName("Duncan").withBirthDate(new Date()).withPetType(PetType.HORSE).build();


        // Playthings for Cthulhu
        Pet pet10 = Pet.builder().withName("Nibbles").withBirthDate(new Date()).withPetType(PetType.HAMPSTER).build();
        Pet pet11 = Pet.builder().withName("Chirpy Boy").withBirthDate(new Date()).withPetType(PetType.LIZARD).build();
        Pet pet12 = Pet.builder().withName("Bart Junior").withBirthDate(new Date()).withPetType(PetType.LIZARD).build();
        Pet pet13 = Pet.builder().withName("Snowball IV").withBirthDate(new Date()).withPetType(PetType.CAT).build();
        Pet pet14 = Pet.builder().withName("Princess").withBirthDate(new Date()).withPetType(PetType.HORSE).build();

        petController.add(pet1);
        petController.add(pet2);
        petController.add(pet3);
        petController.add(pet4);
        petController.add(pet5);
        petController.add(pet6);
        petController.add(pet7);
        petController.add(pet8);
        petController.add(pet9);
        petController.add(pet10);
        petController.add(pet11);
        petController.add(pet12);
        petController.add(pet13);
        petController.add(pet14);

    }
}
