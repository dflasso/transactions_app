package io.github.dflasso.transactions.models.dtos;

import io.github.dflasso.transactions.models.entities.EmployeeEntity;
import io.github.dflasso.transactions.models.entities.PersonEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * DTO basic data of person
 */
@Data
public class PersonSummaryDTO {
    private String name;

    private String lastname;

    private int age;

    private String workPosition;

    public void buildFromPersonEntity(PersonEntity personEntity) {
        this.name = personEntity.getNames();
        this.lastname = personEntity.getLastnames();

        EmployeeEntity employeeData = personEntity.getEmployee();

        this.age = Period.between(personEntity.getBirthday(), LocalDate.now()).getYears();

        if(employeeData != null){
            this.workPosition = employeeData.getWorkPosition();
        }

    }
}
