package com.kiranmart.kiranmart.department;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table(name="tbl_department")
@Entity
@DynamicInsert
@DynamicUpdate
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    @Column (name = "department_id", nullable = false, length = 50)
    private String departmentId;

    @Column (name= " department_name" , length = 200)
    private String departmentName;
}
