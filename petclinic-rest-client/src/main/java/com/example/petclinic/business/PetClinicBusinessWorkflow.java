package com.example.petclinic.business;

import com.example.petclinic.model.*;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetService;
import com.example.petclinic.service.VetService;
import com.example.petclinic.service.VisitService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PetClinicBusinessWorkflow {

    private static final Logger log = LoggerFactory.getLogger(PetClinicBusinessWorkflow.class.getName());

    private OwnerService ownerService;
    private PetService petService;
    private VetService vetService;
    private VisitService visitService;

    public PetClinicBusinessWorkflow(OwnerService ownerService, PetService petService, VetService vetService, VisitService visitService) {

        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.visitService = visitService;

    }

    public void runBusiness() {

        // Create Owners
        Owner owner1 = Owner.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner2 = Owner.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner3 = Owner.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Owner owner4 = Owner.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        // saveOwner
        ownerService.saveOwner(owner1);
        ownerService.saveOwner(owner2);
        ownerService.saveOwner(owner3);
        ownerService.saveOwner(owner4);

        // getAllOwners
        List<Owner> owners = ownerService.getAllOwners();
        owners.forEach(owner -> log.info(owner.toString()));

        // getOwnerByName
        String searchForOwner = "Homer Simpson";
        List<Owner> homers = ownerService.getOwnerByName(searchForOwner);

        AtomicInteger counter = new AtomicInteger(1);
        homers.forEach(homer -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchForOwner);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(homer);

            log.info(sb.toString());
        });

        // modify owner
        Owner ownerModification = homers.get(0);
        ownerModification.setName("Homerus");

        ownerService.modifyOwner(ownerModification);

        log.info(ownerService.getOwnerByName("Homerus").toString());

        // delete owner
        ownerService.deleteOwner(ownerModification);


        Pet pet1 = Pet.builder().withName("Strangles").withBirthDate(new Date()).withPetType(PetType.SNAKE).build();
        Pet pet2 = Pet.builder().withName("Mojo").withBirthDate(new Date()).withPetType(PetType.MONKEY).build();
        Pet pet3 = Pet.builder().withName("Pinchy").withBirthDate(new Date()).withPetType(PetType.LOBSTER).build();
        Pet pet4 = Pet.builder().withName("Cthulhu").withBirthDate(new Date()).withPetType(PetType.HORRORTERROR).build();


        //savePet
        petService.savePet(pet1);
        petService.savePet(pet2);
        petService.savePet(pet3);
        petService.savePet(pet4);

        //getAllPets
        List<Pet> pets = petService.getAllPets();
        pets.forEach(pet -> log.info(pet.toString()));

        // getPetByName
        String searchForPet = "Cthulhu";
        List<Pet> cthulhuPlural = petService.getPetByName(searchForPet);

        counter.set(1);
        cthulhuPlural.forEach(cthulhu -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchForPet);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(cthulhu);

            log.info(sb.toString());
        });

        // modify pet
        Pet petModification = cthulhuPlural.get(0);
        petModification.setName("CthulhuLemon");

        petService.modifyPet(petModification);

        log.info(petService.getPetByName("CthulhuLemon").toString());

        // delete pet
        petService.deletePet(petModification);

        Vet vet1 = Vet.builder().withName("SuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).build();
        Vet vet2 = Vet.builder().withName("PrettySolidVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withSpeciality(Speciality.RADIOLOGY).build();
        Vet vet3 = Vet.builder().withName("OutstandingVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).build();

        // save Vet
        vetService.saveVet(vet1);
        vetService.saveVet(vet2);
        vetService.saveVet(vet3);

        // getAllVets
        List<Vet> vets = vetService.getAllVets();
        vets.forEach(vet -> log.info(vet.toString()));

        // getVetByName
        String searchForVet = "SuperVet";
        List<Vet> superVets = vetService.getVetByName(searchForVet);

        counter.set(1);
        superVets.forEach(superVet -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchForVet);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(superVet);

            log.info(sb.toString());
        });

        // modify owner
        Vet vetModification = superVets.get(0);
        vetModification.setName("SuperDuperVet");

        //vetService.modifyVet(vetModification);

        log.info(vetService.getVetByName("SuperDuperVet").toString());

        // delete vet
        vetService.deleteVet(vetModification);

        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("[REDACTED] Visit!").withPet(pet4).build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit3 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit4 = Visit.builder().withDateOfVisit(new Date()).withDescription("Super Visit").build();

        visitService.saveVisit(visit1);
        visitService.saveVisit(visit2);
        visitService.saveVisit(visit3);
        visitService.saveVisit(visit4);

        // getAllVisits
        List<Visit> visits = visitService.getAllVisits();
        visits.forEach(visit -> log.info(visit.toString()));

        // getVisitByName
        String searchForVisit = "[REDACTED] Visit!";
        List<Visit> superVisits = visitService.getVisitByPetName(searchForVisit);

        counter.set(1);
        superVisits.forEach(superVisit -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchForVisit);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(superVisit);

            log.info(sb.toString());
        });

        // modify owner
        Visit visitModification = superVisits.get(0);
        visitModification.setDescription("SuperDuperVisit");

        visitService.modifyVisit(visitModification);

        log.info(visitService.getVisitByPetName("SuperDuperVisit").toString());

        // delete visit
        visitService.deleteVisit(visitModification);

    }
}