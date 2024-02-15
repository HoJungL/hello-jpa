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
            Team_key team = new Team_key();
            team.setName("TeamA");
            em.persist(team);

            Member_key memberKey = new Member_key();
            memberKey.setUsername("member1");
            memberKey.setTeamId(team.getId());
            em.persist(memberKey);
            /*
            em.persist(member1); // 1, 51 메모리 호출
            em.persist(member2); // memory호출
            em.persist(member3); // memory호출
            */
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
