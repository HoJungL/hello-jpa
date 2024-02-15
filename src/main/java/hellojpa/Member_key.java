package hellojpa;

import javax.persistence.*;

@Entity
public class Member_key {

    // 나는야 연관관계 주인(OWNER) 나는 코딩할때 주인을 기준으로 반드시 changeTeam을 쓸거임
    @Id
    @GeneratedValue()
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;


    // 1:N 관계
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team_key team;

    // @Column(name = "TEAM_ID")
    // private Long teamId;


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

    public Team_key getTeam() {
        return team;
    }

    public void changeTeam(Team_key team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
