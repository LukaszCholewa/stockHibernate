package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.Category;
import pl.camp.it.session.SessionFactory;

import java.util.Set;

public class CategoryDAO implements ICategoryDAO{

    @Override
    public Category getCategoryById(int id){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.model.Category WHERE id = :id");
        query.setParameter("id", id);
        Category result = query.getSingleResult();
        session.close();
        return result;
    }

    @Override
    public Set<Category> getAllCategories(){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.model.Category");
        Set<Category> result = (Set<Category>) query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void saveCategoryToDatabase (Category category) {
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(category);
            tx.commit();
        } catch(Exception e){
            if(tx!= null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    }

    @Override
    public void deleteCategoryFromDataBase(String category){
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(category);
            tx.commit();
        } catch(Exception e){
            if(tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }
}
