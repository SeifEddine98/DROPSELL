package ENTITIES;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class gouvernorat_delegation implements Serializable {

	@Id
	private Integer id;
	private String gouvernorat;
	private String delegation;
	
	public gouvernorat_delegation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public gouvernorat_delegation(Integer id, String gouvernorat, String delegation) {
		super();
		this.id = id;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public String getDelegation() {
		return delegation;
	}
	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delegation == null) ? 0 : delegation.hashCode());
		result = prime * result + ((gouvernorat == null) ? 0 : gouvernorat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		gouvernorat_delegation other = (gouvernorat_delegation) obj;
		if (delegation == null) {
			if (other.delegation != null)
				return false;
		} else if (!delegation.equals(other.delegation))
			return false;
		if (gouvernorat == null) {
			if (other.gouvernorat != null)
				return false;
		} else if (!gouvernorat.equals(other.gouvernorat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "gouvernorat_delegation [id=" + id + ", gouvernorat=" + gouvernorat + ", delegation=" + delegation + "]";
	}
	
}
