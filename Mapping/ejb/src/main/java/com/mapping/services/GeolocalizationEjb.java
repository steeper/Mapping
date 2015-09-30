package com.mapping.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mapping.entities.Geolocalization;
import com.mapping.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class GeolocalizationEjb extends GenericDAOImpl<Geolocalization, Integer>{

}