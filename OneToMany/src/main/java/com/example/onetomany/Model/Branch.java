package com.example.onetomany.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  Integer number;
    private String area;

    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    @JsonIgnore
    private Merchant merchant;
}
