package com.example.preddema.Service;

import com.example.preddema.Model.Statements;
import com.example.preddema.Model.User;
import com.example.preddema.Repo.StatementsRepo;
import com.example.preddema.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementsService {
    private final StatementsRepo statementsRepo;
    private final UserRepo userRepo;
    public void saveStatements(Statements statements, String username){
        User user = userRepo.findByUsername(username);
        statements.setUser(user);
        statements.setFio(user.getFio());
        statements.setStatus("Новое");
        statementsRepo.save(statements);
    }
    public List<Statements> getAll(){
        return statementsRepo.findAll();
    }
    public List<Statements> getAllByUsername(String username){
        return statementsRepo.findAllByUser_Username(username);
    }
    public void changeStatus(boolean status, Long id){
        Statements statements = statementsRepo.findById(id).get();
        if(status){
            statements.setStatus("Подтверждено");
            statementsRepo.save(statements);
        } else {
            statements.setStatus("Отклонено");
            statementsRepo.save(statements);
        }
    }
}
