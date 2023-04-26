package com.kiranmart.kiranmart.employee;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Table(name="tbl_employee")
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@RequiredArgsConstructor
public class Employee {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, name ="created_date")
    private Date createdDate;


}
