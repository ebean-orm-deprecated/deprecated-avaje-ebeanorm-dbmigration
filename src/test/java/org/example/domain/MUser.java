package org.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MUser {

  @Id
  Integer id;

  String userName;

  // Cascade remove will delete from intersection table
  // but will not delete the actual Roles
  @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
  List<MRole> roles;

  @ManyToOne
  private MUserType userType;

  public MUser() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<MRole> getRoles() {
    return roles;
  }

  public void setRoles(List<MRole> roles) {
    this.roles = roles;
  }

  public void addRole(MRole role) {
    if (roles == null) {
      roles = new ArrayList<MRole>();
    }
    roles.add(role);
  }

  public MUserType getUserType() {
    return userType;
  }

  public void setUserType(MUserType userType) {
    this.userType = userType;
  }

}
