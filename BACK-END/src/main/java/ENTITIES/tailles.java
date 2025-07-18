package ENTITIES;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class tailles implements Serializable {
	@Id
	private Integer id;
	private String taille;
	public tailles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public tailles(Integer id, String taille) {
		super();
		this.id = id;
		this.taille = taille;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + id;
		result = prime * result + ((taille == null) ? 0 : taille.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tailles other = (tailles) obj;
		if (id != other.id)
			return false;
		if (taille == null) {
			if (other.taille != null)
				return false;
		} else if (!taille.equals(other.taille))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "tailles [id=" + id + ", taille=" + taille + "]";
	}
	

}
