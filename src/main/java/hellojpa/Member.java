package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 이걸해야 jpa를 쓰는애구나. 라고 생각함.
//@Table(uniqueConstraints = 유니크 key)이름 쓰면 돼
public class Member {

    @Id // pk
    private Long id;
    //nullable = false 인경우, not null 임
    @Column(name="name", updatable = false) //이렇게하면 업뎃이 안됨. DB에서 건들지 않는 이상.
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

    // DB에는 안쓰고, 임시데이터로(캐시) 쓰고 싶다면!!
    @Transient
    private int temp;



    //기본생성자 있어야함.
    public Member(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
