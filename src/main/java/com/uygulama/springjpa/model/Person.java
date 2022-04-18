package com.uygulama.springjpa.model;

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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    private String surname;


    /*Person'un bir pasaportu var. Birbirlerine bağımlılar. Pasaport kısmında hangi objeye ait olduğunu anlamak için
    * mappedBy kullanırız.
    * Bu bir vatandaş(Person) sınıfı ve içerisinde de vatandaşa ait pasaport bilgisi var. Pasaport sınıfı içerisinde bir
    * Person objesi varsa o obje bu Person sınıfına işaret eder. Pasaportaki Person buradaki Person  olur.
    * */
    /* Peki buradaki ilişkiyi kim sahipleniyor? Burada ilişkiyi sahiplenen Person 'dır. Çünkü vatandaşın bir pasaport
    *  bağımlılığı var. Dolayısıyla bu ilişkide ev sahipliği yapan kişi vatandaş(Person)'tır. Dolayısıyla mappedBy
    *  yapısını buraya yazıyorum.MappedBy yapısını Pasaport'a koysaydım ev sahibi Pasaport olacaktı. Yaptığım şeyler de
    *  ona göre devam edecekti. İki tarafa da mappedBy yazılamaz.
    * */

    /* Person'ı sildiğimde pasaportun da silinmesini isitiyorsam ya da Person'ı çektiğimde pasapor bilgilerinin de
     *kendisiyle gelmesini istiyorsam bunun gibi bazı işlemleri yaptığımda diğer tarafın da etkilenmesini isitiyorsam
     *Cascade adı verilen işlemi kullanırız.*/
    @OneToOne(mappedBy = "person")
    private Passport passport;

}
