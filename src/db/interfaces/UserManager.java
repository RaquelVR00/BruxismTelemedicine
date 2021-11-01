/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.interfaces;

/**
 *
 * @author ricardooriol
 */
import java.util.List;
import pojos.users.Role;
import pojos.users.User;


public interface UserManager {

	public void connect();

	public void disconnect();

	public void createUser(User u);

	public void newRole(Role r);

	public Role getRole(int id);

	public List<Role> getRoles();

	public User checkPassword(String email, String password);

}
