package it.ddbdev.demo.service;

import it.ddbdev.demo.entity.Account;
import it.ddbdev.demo.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public List<Account> findAllAccount(){
        return userRepository.findAll();
    }

    public Optional<Account> findAccountById(Long id){
        return userRepository.findAccountById(id);
    }

    public boolean findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void save(Account account){
        userRepository.save(account);
    }
}
