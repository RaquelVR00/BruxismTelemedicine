/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pojos.users.Role;
import pojos.users.User;
import db.interfaces.UserManager;

public class JPAUserManager implements UserManager {

    private EntityManager em;

    @Override
    public void connect() {
        em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
        em.getTransaction().commit();
        List<Role> existingRoles = this.getRoles();
        if (existingRoles.size() < 2) {

            this.createRole(new Role("doctor"));
            this.createRole(new Role("patient"));

        }
    }

    @Override
    public void disconnect() {
        em.close();
    }

    @Override
    public void createUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void createRole(Role role) {
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
    }

    @Override
    public Role getRole(int id) {
        Query q = em.createNativeQuery("SELECT * FROM roles WHERE id = ?", Role.class);
        q.setParameter(1, id);
        return (Role) q.getSingleResult();

    }

    @Override
    public List<Role> getRoles() {
        Query q = em.createNativeQuery("SELECT * FROM roles", Role.class);
        return (List<Role>) q.getResultList();
    }

    @Override
    public User checkPassword(String email, String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ? AND password = ?", User.class);
            q.setParameter(1, email);
            q.setParameter(2, hash);
            return (User) q.getSingleResult();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoResultException nre) {
            return null;
        }
        return null;
    }

    @Override
    public String updateUsername(String username) {
        return null;
    }

    @Override
    public void updatePassword(String username) {
    }

}
