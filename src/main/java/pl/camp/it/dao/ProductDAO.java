package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.model.Product;
import pl.camp.it.session.SessionFactory;
import java.util.Set;

public class ProductDAO implements IProductDAO{

    @Override
    public void saveProductToDatabase (Product product) {
        Session session = SessionFactory.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(product);
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
    public Product getProductById(int id){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.camp.it.model.Product WHERE id = " + id);
        Product product = query.getSingleResult();
        session.close();
        return product;
    }

    @Override
    public Set<Product> getAllProducts(){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.camp.it.model.Product");
       Set<Product> result = (Set<Product>) query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Set<Product> getProductsByCategoryName(int id){
        Session session = SessionFactory.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.camp.it.model.Product WHERE category.id = " + id);
        Set<Product> result = (Set<Product>) query.getResultList();
        session.close();
        return result;
    }
}
