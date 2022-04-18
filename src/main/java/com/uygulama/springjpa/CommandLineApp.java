package com.uygulama.springjpa;

import com.uygulama.springjpa.model.*;
import com.uygulama.springjpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CommandLineApp  implements CommandLineRunner {

    @Autowired   // Autorwired yerine field injection tercih edilir.
    private PersonRepository personRepository;
    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ChannelRepository channelRepository;


    @Override
    public void run(String... args) throws Exception {

        //oneToOneExample();
        //oneToManyExample();
        //manyToManyExample();
    }

    private void manyToManyExample() {
        Channel channel1 = new Channel();
        channel1.setName("channel 1");
        channel1.setUrl("URL channel 1");

        Channel channel2 = new Channel();
        channel2.setName("channel 2");
        channel2.setUrl("URL channel 2");

        Subscriber subscriber1 = new Subscriber();
        subscriber1.setUsername("subs1");

        Subscriber subscriber2 = new Subscriber();
        subscriber2.setUsername("subs2");

        channel1.setSubscribers(List.of(subscriber1,subscriber2));
        this.subscriberRepository.saveAll(List.of(subscriber1,subscriber2));
        this.channelRepository.saveAll(List.of(channel1,channel2));

        List<Channel> channels = this.channelRepository.findAll();
        List<Subscriber> subscribers = this.subscriberRepository.findAll();

        System.out.println(subscribers);
        System.out.println(channels);
    }

    private void oneToManyExample() {

        Cart cart = new Cart();
        cart.setUserId(5);
        this.cartRepository.save(cart);

        CartItem cartItem1= new CartItem();
        cartItem1.setCart(cart);
        cartItem1.setProductCode("code1");
        cartItem1.setQuantity(10);
        cartItem1.setUnitPrice(BigDecimal.valueOf(31.31));

        CartItem cartItem2= new CartItem();
        cartItem2.setCart(cart);
        cartItem2.setProductCode("code2");
        cartItem2.setQuantity(11);
        cartItem2.setUnitPrice(BigDecimal.valueOf(32.20));

        this.cartItemRepository.save(cartItem1);
        this.cartItemRepository.save(cartItem2);

         List<Cart> carts= this.cartRepository.findAll();
         List<CartItem> cartItems= this.cartItemRepository.findAll();

        System.out.println(carts.get(0).getCartItemList());
        System.out.println(cartItems.get(0).getCart());
    }

    private void oneToOneExample() {
        Person person = Person.builder()
                .name("tunahan")
                .surname("karabayır")
                .build();
        Passport passport=Passport.builder()
                .expireDate(Instant.now().plus(31,ChronoUnit.DAYS).getEpochSecond())
                .person(person)
                .build();

        this.passportRepository.save(passport);
        System.out.println(passport);
    }
}
