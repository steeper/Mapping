package com.mapping.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Enterprise;
import com.mapping.entities.User;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class EnterpriseEjb extends GenericDAOImpl<Enterprise, Integer>{
	public EnterpriseEjb(){
		
	}
	public List<Enterprise> findByEnterpriseName(Enterprise ent) throws Exception{
		List<Enterprise> list = new ArrayList<Enterprise>();
		
		if(ent.getEntName().equals(new String("")))
		{
				list = findAll();
		}
		else
		{
			String query = "SELECT e FROM Enterprise e where ";
			query+= "e.entName like '%"+ent.getEntName()+"%'";			
			list = find(query);
			return list;
		}
		return list;
	}
}
