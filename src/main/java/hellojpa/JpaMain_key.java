package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_key {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            
            //저장
            Team_key team = new Team_key();
            team.setName("TeamA");
            em.persist(team);

            Member_key memberKey = new Member_key();
            memberKey.setUsername("member1");
            memberKey.setTeam(team); // 이게 중요함.
            em.persist(memberKey);

            //양방향일떄는 둘다 값 세팅 꼭하셈, (//이게 중요함. 부분과 아래의 코드)
            team.getMembers().add(memberKey);

            //역방향(주인이 아닌 방향)만 연관관계 설정
            // team.getMembers().add(memberKey); 이러면 DB에 안들어간당?


            // 이거 있어야 아래의 코드가 DB에서 깔끔하게 들고옴. 쓰기쓰기
            em.flush();
            em.clear();


            /*
            Member_key findMember = em.find(Member_key.class, memberKey.getId());
            List<Member_key> members = findMember.getTeam().getMembers();

            for (Member_key m : members) {
                System.out.println("m = " + m.getUsername());
                
            }
            */

            /*
            // 영속성 콘텍스트에 있는걸 그냥 바로 들고옴
            Member_key findMember = em.find(Member_key.class, memberKey.getId());
            
            Team_key findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());
            */

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
