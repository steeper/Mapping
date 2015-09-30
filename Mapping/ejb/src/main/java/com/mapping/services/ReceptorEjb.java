package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Receptor;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class ReceptorEjb extends GenericDAOImpl<Receptor, Integer>{

}