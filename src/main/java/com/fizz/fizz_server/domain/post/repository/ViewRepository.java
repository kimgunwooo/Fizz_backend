package com.fizz.fizz_server.domain.post.repository;

import com.fizz.fizz_server.domain.post.domain.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
}
