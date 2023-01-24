package it.ddbdev.demo.repository;

import it.ddbdev.demo.entity.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class UserRepository {

    @PersistenceContext(unitName = "POSTGRES_PU")
    private EntityManager entityManager;

    public List<Account> findAll(){
        return entityManager.createNamedQuery("Account.findAll").getResultList();
    }

    public Optional<Account> findAccountById(Long id){
        return entityManager.createNamedQuery("Account.findById")
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
    }
    public Boolean findByUsername(String username){
        return entityManager
                .createQuery("SELECT a FROM Account a where a.username = :username")
                .setParameter("username", username)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();
    }
    @Transactional
    public void save(Account account){
        entityManager.persist(account);
    }
}