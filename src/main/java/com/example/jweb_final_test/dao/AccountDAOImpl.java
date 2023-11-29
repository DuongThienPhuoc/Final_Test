package com.example.jweb_final_test.dao;

import com.example.jweb_final_test.entity.Account;
import com.example.jweb_final_test.entity.TransactionHistory;
import com.example.jweb_final_test.until.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private final HibernateUtil hibernateUtil = new HibernateUtil();

    @Override
    public void saveAccount(Account account) {
        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(account);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void saveTransaction(TransactionHistory transactionHistory) {
        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(transaction);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean login(String username, String password) {
        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        TypedQuery<Account> query = entityManager.createQuery("select e from Account e where e.account = :account and e.password=:password", Account.class);
        query.setParameter("account", username);
        query.setParameter("password", password);
        try {
            return query.getSingleResult() != null;
        } catch (NoResultException e) {
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Account getAccount(String username) {
        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Account> query = entityManager.createQuery("select a from Account a where a.account = :account", Account.class);
            query.setParameter("account", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Account> getAccountToTransfer(String username) {
        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Account> query = entityManager.createQuery("select a from Account a where a.account != :username", Account.class);
            query.setParameter("username", username);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }

    }

//    @Override
//    public void transfer(String account, String accountTransfer, Long amount, String note) {
//        EntityManager entityManager = hibernateUtil.getEntityManagerFactory().createEntityManager();
//        Account accountT = accountDAO.getAccount(account);
//        Account accountR = accountDAO.getAccount(accountTransfer);
//        var accTransfer = Account.builder()
//                .balance(accountT.getBalance() - amount)
//                .build();
//        entityManager.merge(accountTransfer);
//        var accReceiver = Account.builder()
//                .balance(accountR.getBalance()+amount)
//                .build();
//        entityManager.merge(accReceiver);
//    }
}
