package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Role;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RoleEjb extends GenericDAOImpl<Role, Integer>{

}