package com.fizz.fizz_server.domain.user.repository;

import com.fizz.fizz_server.domain.user.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
}
