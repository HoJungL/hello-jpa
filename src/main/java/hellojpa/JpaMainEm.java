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
            MemberEm member = new MemberEm();
            member.setUsername("member1");
            member.setHomeAddress(new Address("HomeCity", "street", "10000"));

            member.getFavoriteFoods().add("라멘");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1", "street", "10000"));
            member.getAddressHistory().add(new Address("old2", "street", "10000"));

            em.persist(member);

            /*
            Address address = new Address("city", "street", "10000");

            MemberEm memberEm1 = new MemberEm();
            memberEm1.setUsername("seok");
            memberEm1.setHomeAddress(address);
            em.persist(memberEm1);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            MemberEm memberEm2 = new MemberEm();
            memberEm2.setUsername("jung");
            memberEm2.setHomeAddress(copyAddress);
            em.persist(memberEm2);

            memberEm1.getHomeAddress().setCity("newCity");*/

            // 임베디드 타입을 여러 엔티티에서 공유하면 위험해요....
            // 부작용(side effect) 생겨요.
            // memberEm1만 바꾸고 싶은데, 둘다 바뀌어요
//            memberEm1.getHomeAddress().setCity("newCity");
            tx.commit();
        } catch (Exception e){

            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
