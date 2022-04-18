package com.uygulama.springjpa.repository;

import com.uygulama.springjpa.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
