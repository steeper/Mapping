package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Form;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class FormEjb extends GenericDAOImpl<Form, Integer>{

}
