package br.com.fiap.model;
import javax.persistence.*;


@Entity
@SequenceGenerator(name="usuariox", sequenceName = "SQ_TB_USUARIOx", allocationSize = 1)
public class Usuario {
		
		@Id 
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuariox")
		@Column(name="id_person", length = 70)
		private int idperson;
	    private String firstname;
	    private String lastname;
	    private String password;
	    private String email;
	    
	    

	    public int getIdperson() {
			return idperson;
		}

		public void setIdperson(int idperson) {
			this.idperson = idperson;
		}

		public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		
		@Override
		public String toString() {
			return "Setup [name=" + firstname + ", lastname=" + lastname + "]";
		}
	}



