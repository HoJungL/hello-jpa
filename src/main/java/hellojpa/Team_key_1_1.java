package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team_key_1_1 {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    @OneToMany() // mappedBy : 뭐랑 연결되어있니? 변수명으로
    @JoinColumn(name = "TEAM_ID")
    private List<Member_key_1_1> members = new ArrayList<>(); // 관례임

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member_key_1_1> getMembers() {
        return members;
    }

    public void setMembers(List<Member_key_1_1> members) {
        this.members = members;
    }
}
