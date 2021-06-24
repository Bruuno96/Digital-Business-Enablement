package br.com.fiap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@Column(name="cd_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Temporal (TemporalType.DATE)
	private Date birthday;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Setup> setups = new ArrayList<>();
	

	public void Add(Setup setup) {
		if (setups == null) {
			setups = new ArrayList<>();
			setups.add(setup);
			setup.setUser(this);
		}
	}
	
	public User() {}
	

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Setup> getSetups() {
		return setups;
	}

	public void setSetups(List<Setup> setups) {
		this.setups = setups;
	}

	

	

}
