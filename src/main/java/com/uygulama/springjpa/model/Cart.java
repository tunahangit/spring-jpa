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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long userId;

    /*
    *  Cart isminde bir sepetimiz var. Veritabanından sepeti çektğimiz zaman Cart tablosundaki sepeti çekiyor.
    *  O sepetin altındaki ürünleri görmek istiyorsak feth type yapısını kullanıyoruz.
    *  Sepeti çektiğimizde ürünleri de getiriyor. Bu bu durum içni EAGER kullanıyoruz.
    * OneToOne -> Fetch Type default olarak EAGER
    * ManyToOne -> One tarafı yine default EAGER
    * ManyToMany ve OneToMany ilişkilerinde ise default LAZY
    * Buradaki örnekte de default fetch type LAZY
    * Eğer LAZY olarak kalsaydı Cart gelecekti ancak CartItem null olacaktı.*/

    @OneToMany(mappedBy = "cart" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<CartItem> cartItemList = new ArrayList();
}
