package com.gladiators.pi_spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title ;
    private String  subject ;
    @Size(min = 3, max = 3000)
    private String  content ;
    @Enumerated(EnumType.STRING)
    private Prix prix;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @Lob
    private byte[] video;

    @Lob
    private byte[] image;

}
