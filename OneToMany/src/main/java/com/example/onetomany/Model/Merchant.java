package com.example.onetomany.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor


public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;
      private String Name;
      @OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
       private Set<Branch> branches;
}
