package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_key {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member_key member1 = new Member_key();
            member1.setUsername("A");
            Member_key member2 = new Member_key();
            member2.setUsername("B");
            Member_key member3 = new Member_key();
            member3.setUsername("C");

            System.out.println("/////////////////");

            em.persist(member1); // 1, 51 메모리 호출
            em.persist(member2); // memory호출
            em.persist(member3); // memory호출
            System.out.println("member1 = "+member1.getId());
            System.out.println("member2 = "+member2.getId());
            System.out.println("member3 = "+member3.getId());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
