package com.hotwaxx.Assesment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @Column(name = "PARTY_ID", length = 40, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String partyId;

    @ManyToOne
    private Party party ;

    @Column(name = "SALUTATION", length = 255)
    private String salutation;

    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 255)
    private String middleName;

    @Column(name = "LAST_NAME", length = 255)
    private String lastName;

    @Column(name = "GENDER", length = 1)
    private Character gender;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "MARITAL_STATUS_ENUM_ID", length = 40)
    private String maritalStatusEnumId;

    @Column(name = "EMPLOYMENT_STATUS_ENUM_ID", length = 40)
    private String employmentStatusEnumId;

    @Column(name = "OCCUPATION", length = 255)
    private String occupation;
}
