package com.mapping.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean(name="loginBean")
@SessionScoped
public class Logout implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5722616030335589264L;

	public Logout(){
		
	}
	
	
	/*marik*/
	/*marik vos*/
	public void logout() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/pages/user/user.xhtml");
	}
}
