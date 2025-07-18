package ENTITIES;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class categories implements Serializable {
	
	@Id
	private int id;
	private String name;
	private String cover_picture_path;
	private String description;
	private Integer parent_id;
	
	public categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public categories(int id, String name, String cover_picture_path, String description, int parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.cover_picture_path = cover_picture_path;
		this.description = description;
		this.parent_id = parent_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover_picture_path() {
		return cover_picture_path;
	}
	public void setCover_picture_path(String cover_picture_path) {
		this.cover_picture_path = cover_picture_path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "categories [id=" + id + ", name=" + name + ", cover_picture_path=" + cover_picture_path
				+ ", description=" + description + ", parent_id=" + parent_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cover_picture_path == null) ? 0 : cover_picture_path.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + parent_id;
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
		categories other = (categories) obj;
		if (cover_picture_path == null) {
			if (other.cover_picture_path != null)
				return false;
		} else if (!cover_picture_path.equals(other.cover_picture_path))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent_id != other.parent_id)
			return false;
		return true;
	}

	
}
