package com.ajsw.barInventory.repositories;

import com.ajsw.barInventory.domain.entity.Drink;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DrinkDAO {
    private final SessionFactory factory;

    public DrinkDAO() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        factory = config.buildSessionFactory();
    }

    public void saveDrink(Drink drink) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(drink);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Drink> getAllDrinks() {
        Session session = factory.openSession();
        Transaction transaction = null;
        List<Drink> drinks = null;
        try {
            transaction = session.beginTransaction();
            Query<Drink> query = session.createQuery("FROM Drink", Drink.class);
            drinks = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return drinks;
    }

    public Drink getDrink(int id) {
        Session session = factory.openSession();
        Drink drink = null;
        try {
            drink = session.get(Drink.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return drink;
    }

    public void updateDrink(Drink drink) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(drink);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDrink(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Drink drink = session.get(Drink.class, id);
            session.delete(drink);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
