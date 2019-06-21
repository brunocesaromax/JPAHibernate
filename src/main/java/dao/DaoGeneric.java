package dao;

import configuration.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DaoGeneric<E> {

    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public E saveOrUpdate(E entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        E entityMerge = entityManager.merge(entity); /*Existe o persist que cria e o update que só atualiza, mas o merge faz os dois*/
        transaction.commit();

        return entityMerge;
    }

    public E find(E entity) {

        Object id = HibernateUtil.getPrimaryKey(entity);

        E e = (E) entityManager.find(entity.getClass(), id);

        return e;

    }

    public E find(Long id, Class<E> entity) {

        E e = entityManager.find(entity, id);
        return e;
    }

    public void deleteById(E entity) {

        Object id = HibernateUtil.getPrimaryKey(entity);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /*Mandando SQL direto para o banco de dados, evita vários erros*/
        entityManager.createNativeQuery(
                "DELETE FROM " + entity.getClass().getSimpleName().toLowerCase() + " WHERE id =" + id).executeUpdate();

        transaction.commit();
    }

    public List<E> findAll(Class<E> entity) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List list = entityManager.createQuery("FROM " + entity.getName()).getResultList();

        transaction.commit();

        return list;
    }

    /*Podemos utilizar o entityManager em outras partes do projeto, para criar consultas específicas*/
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
