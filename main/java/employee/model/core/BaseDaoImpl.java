package employee.model.core;

import employee.model.connectordb.DbConnector;
import org.hibernate.Session;

import java.io.Serializable;


public abstract class BaseDaoImpl<E extends Serializable> implements BaseDAO<E> {

    private Session session = DbConnector.getSession();


    @Override
    public void create(E e) {
        Session session = DbConnector.getSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public E update(E e) {

        Session session = DbConnector.getSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();
        return e;

    }

    protected abstract String getEntityName();


    @Override
    public E read(Serializable id) {
        Session session = DbConnector.getSession();
        E e = (E) session.get(getEntityName(), id);

        System.out.println(e); // 1 teacher read
        return e;

    }


    @Override
    public void delete(Serializable id) {

        Session session = DbConnector.getSession();

        session.beginTransaction();

        session.createQuery("delete Employee t where t.id = ?1").setParameter(1, id).executeUpdate();

        session.getTransaction().commit();

        session.close();
    }
}




