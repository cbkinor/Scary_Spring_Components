package cooksys.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_role") //do not need anything after @Table
public class AppRole {

	//will be in every class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role")  //do not need anything after @Column
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
