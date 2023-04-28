package com.kiranmart.kiranmart.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class Model {

    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, name ="created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, name ="modified_date")
    private Date modifiedDate;

    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean status;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean deleted;

}
