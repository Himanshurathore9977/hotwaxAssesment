package com.hotwaxx.Assesment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Party {
    @Id
    @Column(name = "PARTY_ID", length = 40, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String partyId;

    @Column(name = "PARTY_TYPE_ENUM_ID", length = 40)
    private String partyTypeEnumId;

    @OneToMany(mappedBy = "party")
    private List<OrderHeader> orders ;

    @OneToMany(mappedBy = "party")
    private  List<Person> person ;

}
