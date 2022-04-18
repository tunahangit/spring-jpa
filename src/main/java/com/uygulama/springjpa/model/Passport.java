package com.uygulama.springjpa.model;

import com.uygulama.springjpa.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long expireDate;

    /*
    * Pasaportta bir değişiklik olursa ilgili obje de ( Person ) değişiklikten etkilensin.
    * (cascade yapısı bunu sağlar*/
    @OneToOne(cascade =CascadeType.ALL )
    private Person person;
}
