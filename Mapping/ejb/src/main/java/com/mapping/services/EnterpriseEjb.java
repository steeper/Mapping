package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Enterprise;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class EnterpriseEjb extends GenericDAOImpl<Enterprise, Integer>{

}
