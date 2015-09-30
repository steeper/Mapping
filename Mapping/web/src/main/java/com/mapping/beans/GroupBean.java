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

import com.mapping.entities.Group;



import com.mapping.services.GroupEjb;


@ManagedBean(name="groupBean")
@SessionScoped
public class GroupBean implements Serializable{

	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6947795723922048091L;
	/**
	 * 
	 */
	
	private Group group = new Group();
	
	private Group groupSearch = new Group();
	
	private Calendar cal = Calendar.getInstance();
		
	private String regexText = new String();
	
	private List<Group> groupList = new ArrayList<Group>();
	
	private Boolean isNew = new Boolean(Boolean.TRUE);
	
	@EJB
	GroupEjb groupAction;
	
	
	
	public void save(){
		
			if(isNew){
				try {					
					
					group.setGrpState("C");;
					group.setGrpCreationDate(cal.getTime());
					groupAction.persist(group);
										
					
					group = new Group();
					
					RequestContext.getCurrentInstance().update("groupForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					groupAction.merge(group);
					
					isNew = Boolean.TRUE;
					group = new Group();
					
					RequestContext.getCurrentInstance().update("groupForm:insertDialog");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				groupList = groupAction.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestContext.getCurrentInstance().update("groupForm:groupTable");
		}
		
		
	
	
	public void prueba(){
		System.out.println("prueba");
	}
	
	public void search(){
		try {
			groupList = groupAction.findAll();
			RequestContext.getCurrentInstance().update("groupForm:groupTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(Group gpr){
		
		
		try {
			groupAction.remove(gpr);
			groupList = groupAction.findAll();
			RequestContext.getCurrentInstance().update("groupForm:groupTable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clean(){
		groupList = new ArrayList<Group>();
		RequestContext.getCurrentInstance().update("groupForm:groupTable");
	}
	
	public void edit(Group gpr){
		isNew = Boolean.FALSE;
		group = new Group();	
		group = gpr;
			
		RequestContext.getCurrentInstance().update("groupForm:insertDialog");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public void handleClose(CloseEvent event) {
		group = new Group();
		
		isNew = Boolean.TRUE;
		RequestContext.getCurrentInstance().update("groupForm:insertDialog");
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




	public Group getGroup() {
		return group;
	}




	public void setGroup(Group group) {
		this.group = group;
	}




	public Group getGroupSearch() {
		return groupSearch;
	}




	public void setGroupSearch(Group groupSearch) {
		this.groupSearch = groupSearch;
	}




	public Calendar getCal() {
		return cal;
	}




	public void setCal(Calendar cal) {
		this.cal = cal;
	}




	public List<Group> getGroupList() {
		return groupList;
	}




	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	
	
	

}
