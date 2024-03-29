package hellojpa;

import javax.persistence.*;

@Entity
public class Member_key_1_1 extends BaseEntity {

    // 나는야 연관관계 주인(OWNER) 나는 코딩할때 주인을 기준으로 반드시 changeTeam을 쓸거임
    @Id
    @GeneratedValue()
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    //insert, update 안넣으면 주인취급하기 때문에 읽기전용이 아님. 반드시 넣어줄것.
    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩.
    //@ManyToOne(fetch = FetchType.EAGER) 즉시로딩 넌 쓰지 않아요 실무에서..
    @JoinColumn(name = "TEAM_ID")
    private Team_key_1_1 team;


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

    public Team_key_1_1 getTeam() {
        return team;
    }

    public void setTeam(Team_key_1_1 team) {
        this.team = team;
    }
}
