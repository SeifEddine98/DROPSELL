package ENTITIES;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pointures implements Serializable {
	@Id
	private Integer id;
	private String pointure;
	public pointures() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pointures(Integer id, String pointure) {
		super();
		this.id = id;
		this.pointure = pointure;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPointure() {
		return pointure;
	}
	public void setPointure(String pointure) {
		this.pointure = pointure;
	}
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + id;
		result = prime * result + ((pointure == null) ? 0 : pointure.hashCode());
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
		pointures other = (pointures) obj;
		if (id != other.id)
			return false;
		if (pointure == null) {
			if (other.pointure != null)
				return false;
		} else if (!pointure.equals(other.pointure))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "pointures [id=" + id + ", pointure=" + pointure + "]";
	}
	
	
}
