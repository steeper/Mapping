package com.mapping.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

import com.mapping.entities.Geolocalization;
import com.mapping.entities.Group;
import com.mapping.services.GeolocalizationEjb;


@ManagedBean(name="geoBean")
@SessionScoped
public class GeolocalizationBean implements Serializable{

	/**
	 * 
	 */
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7003495263926043285L;

	/**
	 * 
	 */
	
	private Geolocalization geo = new Geolocalization();
	
	private Geolocalization geoSearch = new Geolocalization();
	
	private Calendar cal = Calendar.getInstance();
		
	private String regexText = new String();
	
	private List<Geolocalization> geoList = new ArrayList<Geolocalization>();
	
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	@EJB
	GeolocalizationEjb geoAction;
	
	
	
	public void save(){
		
		if(isNew){
				try {					
					
					geo.setGeoState("C");
					geo.setGeoDate(cal.getTime());
					geoAction.persist(geo);
										
					
					geo = new Geolocalization();
					
					RequestContext.getCurrentInstance().update("groupForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					geoAction.merge(geo);
					
					isNew = Boolean.TRUE;
					geo = new Geolocalization();
					
					RequestContext.getCurrentInstance().update("groupForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				geoList = geoAction.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestContext.getCurrentInstance().update("geoForm:geoTable");

		}

		
	
	
	public void prueba(){
		System.out.println("prueba");
	}
	
	public void search(){
		try {
			geoList = geoAction.findAll();
			RequestContext.getCurrentInstance().update("geoForm:geoTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(Geolocalization geop){
		
		
		try {
			geoAction.remove(geop);
			geoList = geoAction.findAll();
			RequestContext.getCurrentInstance().update("geoForm:geoTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		geoList = new ArrayList<Geolocalization>();
		RequestContext.getCurrentInstance().update("geoForm:geoTable");
	}
	
	public void edit(Geolocalization geop){
		isNew = Boolean.FALSE;
		geo = new Geolocalization();	
		geo = geop;
			
		RequestContext.getCurrentInstance().update("geoForm:geoDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void handleClose(CloseEvent event) {
		geo = new Geolocalization();
		
		isNew = Boolean.TRUE;
		RequestContext.getCurrentInstance().update("geoForm:geoDialog");
    }
	



	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	

	public String getRegexText() {
		return regexText;
	}

	public void setRegexText(String regexText) {
		this.regexText = regexText;
	}




	public Calendar getCal() {
		return cal;
	}




	public void setCal(Calendar cal) {
		this.cal = cal;
	}





	
	
	

}
