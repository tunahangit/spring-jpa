package com.uygulama.springjpa.repository;

import com.uygulama.springjpa.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber,Long> {
}
