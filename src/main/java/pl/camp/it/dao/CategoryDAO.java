package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.Category;
import pl.camp.it.session.SessionFactory;

import java.util.List;

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
    public List<Category> getAllCategories(){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("From pl.camp.it.model.Category");
        List<Category> result = (List<Category>) query.getResultList();
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
    public void deleteCategoryFromDataBase(Category category){
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

    @Override
    public boolean checkCategoryInDataBase(String category) {
        for (Category category2 : getAllCategories()) {
            if (category2.getName().equals(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkCategoryInDataBaseWithDeleted(String category) {
        for (Category category2 : getAllCategoriesFromDataBaseWithDeleted()) {
            if (category2.getName().equals(category)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Category getCategoryFromDataBase(String name) {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category WHERE name = :name");
        query.setParameter("name", name);
        Category tempCategory = query.getSingleResult();
        session.close();
        return tempCategory;
    }

    @Override
    public List<Category> getAllCategoriesFromDataBaseWithDeleted() {
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Category> query = session.createQuery("FROM pl.camp.it.model.Category");
        List<Category> categories = query.getResultList();
        session.close();
        return categories;
    }
}
