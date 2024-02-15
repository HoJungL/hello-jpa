package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Movie movie = new Movie();
            movie.setDirector("AAA");
            movie.setActor("BBb");
            movie.setName("바람");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();


            Movie findMovie = em.find(Movie.class, movie.getId());

            tx.commit();
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
