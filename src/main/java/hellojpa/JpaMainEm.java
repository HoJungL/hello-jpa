package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainEm {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            MemberEm memberEm = new MemberEm();
            memberEm.setUsername("seok");
            memberEm.setHomeAddress(new Address("city", "street", "1001"));
            memberEm.setWorkPeriod(new Period());
            em.persist(memberEm);

            tx.commit();
        } catch (Exception e){

            tx.rollback();

        } finally {
            em.close();
        }
        emf.close();
    }
}
