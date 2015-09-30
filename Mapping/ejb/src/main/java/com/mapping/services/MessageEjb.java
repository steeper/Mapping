package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Message;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class MessageEjb extends GenericDAOImpl<Message, Integer>{

}