package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain_key_1_1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member_key_1_1 memkey = new Member_key_1_1();
            memkey.setUsername("user1");
            memkey.setCreatedBy("kim");
            memkey.setCreatedDate(LocalDateTime.now());

            Member_key_1_1 memberKey11 = new Member_key_1_1();
            memberKey11.setUsername("member1");
            em.persist(memberKey11);

            //여기서 신기한 일이?^^
            Team_key_1_1 team = new Team_key_1_1();
            team.setName("teamA");

            // 이거는 신기하게 update로 들어감
            team.getMembers().add(memberKey11);
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
