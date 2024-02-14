package hellojpa;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="member_seq_generator",
sequenceName = "member_seq",
initialValue = 1, allocationSize = 50)
public class Member_key {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Member_key() {
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
}
