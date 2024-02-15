package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 내가 있으면.. 빠르게 스캔 가능!
@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
