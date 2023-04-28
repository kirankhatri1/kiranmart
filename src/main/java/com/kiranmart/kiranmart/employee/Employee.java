package com.kiranmart.kiranmart.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kiranmart.kiranmart.base.Model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Table(name="tbl_employee")
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@RequiredArgsConstructor
public class Employee extends Model {

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    // @Column(name = "full_name") if we need to persist in database
    @Transient
    private String fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
    }

    private String email;

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
