/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos.users;

/**
 *
 * @author ricardooriol
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {

    private static final long serialVersionUID = -7421790002967283667L;
    private Integer id;
    private String name;

    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role() {
        super();
        this.users = new ArrayList<User>();
    }

    public Role(String name) {
        super();
        this.name = name;
        this.users = new ArrayList<User>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Role other = (Role) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    public String toStringRole() {
        return name;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }

}
