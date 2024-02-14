package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 엔티티 메니저는 쓰레드 간의 공유는 하면 안돼.
        EntityManager em = emf.createEntityManager();

        //JPA의 모든 데이터 변경은 트랜젝션 안에서 실행해야함.
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 해줘야함.
/*
        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");

        em.persist(member);

        tx.commit();
        em.close();*/


        try {
            //
            Member member = em.find(Member.class, 150L);
            //영속
/*
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
*/

            //아직 영속성 컨텍스트에 채워짐
/*
            em.persist(member1);
            em.persist(member2);
*/

            //내가 실행되면 dB에 저장!
            System.out.println("#############");
            tx.commit();

            // 정보 생성 (C : create)
            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloB");

            //영속
//            em.persist(member);

//            Member findMember = em.find(Member.class, 101L);

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
/*
            // 정보 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
*/
// 여러명을 한번에 출력하고 싶어요.
/*
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) // 1번부터
                    .setMaxResults(4) // 4명 데리고 와
                    .getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getName());
*/
