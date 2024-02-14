package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 이걸해야 jpa를 쓰는애구나. 라고 생각함.
public class Member {

    @Id // pk
    private Long id;
    @Column(name="name")
    private String username;
    private Integer age;

    //일반적으로 DB에는 EnumType이 없음. 그럴때 쓰는게 Enumerated
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    //기본생성자 있어야함.
    public Member(){
    }
}
