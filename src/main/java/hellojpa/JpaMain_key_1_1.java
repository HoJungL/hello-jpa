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

/*            Member_key_1_1 memkey = new Member_key_1_1();
            memkey.setUsername("user1");
            memkey.setCreatedBy("kim");
            memkey.setCreatedDate(LocalDateTime.now());

            Member_key_1_1 memberKey11 = new Member_key_1_1();
            memberKey11.setUsername("member1");
            em.persist(memberKey11);*/



            // 지연로딩
            Team_key_1_1 team1 = new Team_key_1_1();
            team1.setName("teamA");
            em.persist(team1);

            Member_key_1_1 member1 = new Member_key_1_1();
            member1.setUsername("member1");
            member1.setTeam(team1);
            em.persist(member1);

            em.flush();
            em.clear();

            Member_key_1_1 m = em.find(Member_key_1_1.class, member1.getId());

            System.out.println("==========================");
            //locker 있으면 안됩니다..ㅠㅠ
            System.out.println("m= " + m.getTeam().getClass());

            System.out.println("==========================");
            m.getTeam().getName(); // 이때 초기화가 됨.
            System.out.println("==========================");

            tx.commit();

/*
            //여기서 신기한 일이?^^
            Team_key_1_1 team = new Team_key_1_1();
            team.setName("teamA");

            // 이거는 신기하게 update로 들어감
            team.getMembers().add(memberKey11);
            em.persist(team);
*/


        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();

    }
}
