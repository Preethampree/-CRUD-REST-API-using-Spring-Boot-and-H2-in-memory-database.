package com.example.demo.repository;

import com.example.demo.model.Usero;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<Usero, Long> {
}