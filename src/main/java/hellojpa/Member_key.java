package hellojpa;

import javax.persistence.*;

@Entity
public class Member_key {

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

    public void setTeam(Team_key team) {
        this.team = team;
    }

}
