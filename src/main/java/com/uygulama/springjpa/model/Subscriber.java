package com.uygulama.springjpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String username;

    @ManyToMany(mappedBy = "subscribers" ,fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Channel> channels=new ArrayList();
}
