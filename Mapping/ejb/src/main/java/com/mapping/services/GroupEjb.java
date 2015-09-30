package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Group;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class GroupEjb extends GenericDAOImpl<Group, Integer>{

}
