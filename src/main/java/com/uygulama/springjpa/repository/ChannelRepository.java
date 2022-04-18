package com.uygulama.springjpa.repository;

import com.uygulama.springjpa.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
