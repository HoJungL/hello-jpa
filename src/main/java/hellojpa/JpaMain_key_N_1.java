package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain_key_N_1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member_key_N_1 memberKeyN1 = new Member_key_N_1();
            memberKeyN1.setUsername("member1");
            em.persist(memberKeyN1);

            //여기서 신기한 일이?^^
            Team_key_N_1 team = new Team_key_N_1();
            team.setName("teamA");

            // 이거는 신기하게 update로 들어감
            team.getMembers().add(memberKeyN1);
            em.persist(team);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
