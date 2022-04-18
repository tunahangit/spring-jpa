package com.uygulama.springjpa.repository;

import com.uygulama.springjpa.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
