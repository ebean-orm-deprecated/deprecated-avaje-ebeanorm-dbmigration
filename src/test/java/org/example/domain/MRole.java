package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class MRole {

  @Id
  Integer id;

  String roleName;

  @ManyToMany
  List<MUser> users;

  public MRole() {
  }

  public MRole(String roleName) {
    this.roleName = roleName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<MUser> getUsers() {
    return users;
  }

  public void setUsers(List<MUser> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "MRole [roleName=" + roleName + "]";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    // Make sure other is not null and has the same class as this
    if (other != null && getClass().equals(other.getClass())) {
      final MRole rhs = (MRole) other;
      if (id.equals(rhs.id)) {
        if (id == 0) {
          return false;
        } else {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (id != null && id != 0) {
      int rid = id;
      return (int) (rid ^ (rid >>> 32));
    }
    return super.hashCode();
  }

}
