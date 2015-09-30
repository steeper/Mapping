package com.mapping.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the receptor database table.
 * 
 */
@Entity
@Table(name="receptor")
public class Receptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REC_ID")
	private int recId;

	
	@Column(name="REC_CREATION_DATE")
	private Date recCreationDate;

	@Column(name="REC_STATE")
	private String recState;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="receptor")
	private List<Message> messages;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="receptor")
	private List<User> users;

	public Receptor() {
	}

	public int getRecId() {
		return this.recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public Date getRecCreationDate() {
		return this.recCreationDate;
	}

	public void setRecCreationDate(Date recCreationDate) {
		this.recCreationDate = recCreationDate;
	}

	public String getRecState() {
		return this.recState;
	}

	public void setRecState(String recState) {
		this.recState = recState;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setReceptor(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setReceptor(null);

		return message;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setReceptor(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setReceptor(null);

		return user;
	}

}