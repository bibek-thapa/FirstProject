package com.example.data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER_TBL")
public class UserDetail implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(nullable=false,unique = true,name="USER_NAME")
    private String userName;
    
    
    
    @NotEmpty
    @Column(name="USER_PASSWORD",nullable = false)
    private String password;

    @NotEmpty
    @Email
    @Column(name = "USER_EMAIL",nullable = false)
    private String emailAddress;
    
    @NotEmpty
    @Column(name="USER_FIRSTNAME",nullable = false)
    private String firstName;
    
    @NotEmpty
    @Column(name = "USER_LASTNAME",nullable = false)
    private String lastName;
    
    @Column(name = "USER_ACTIVE",nullable = false)
    private int active;
    
    @ManyToMany
    @JoinTable(name="USER_ROLE_TBL",joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name="roleId"))
    private Set<UserRoles> roles;

    public Set<UserRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoles> roles) {
        this.roles = roles;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    

    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
