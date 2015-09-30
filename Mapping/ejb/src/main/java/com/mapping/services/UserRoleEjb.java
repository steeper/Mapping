package com.mapping.services;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.mapping.entities.User;
import com.mapping.entities.UserRole;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class UserRoleEjb extends GenericDAOImpl<UserRole, Integer>{
	public UserRoleEjb(){
		
	}
	
	public UserRole findByUser(User user){
		UserRole userFinded = new UserRole();
		List<UserRole> list = new ArrayList<UserRole>();
		
		String query = "SELECT u FROM UserRole u where u.user.usrName ='"+user.getUsrName()+"'";
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(UserRole aux : list){
			userFinded = aux;
		}
		return userFinded;
	}
}