package com.example.preddema.Repo;

import com.example.preddema.Model.Statements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementsRepo extends JpaRepository<Statements, Long> {
    List<Statements> findAllByUser_Username(String username);
}
