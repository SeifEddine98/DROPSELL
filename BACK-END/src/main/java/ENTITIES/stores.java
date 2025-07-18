package ENTITIES;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class stores implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.
	IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	private String logo_path;
	private String description;
	private Integer views_number;
	private Boolean is_sponsored;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private partners partner;
    private String couverture_path;
    private String numtel;
    private String gouvernorat;
    private String delegation;
	
	public stores() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public stores(Integer id, String name, String logo_path, String description, Integer views_number,
			Boolean is_sponsored, partners partner, String couverture_path, String numtel, String gouvernorat,
			String delegation) {
		super();
		this.id = id;
		this.name = name;
		this.logo_path = logo_path;
		this.description = description;
		this.views_number = views_number;
		this.is_sponsored = is_sponsored;
		this.partner = partner;
		this.couverture_path = couverture_path;
		this.numtel = numtel;
		this.gouvernorat = gouvernorat;
		this.delegation = delegation;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLogo_path() {
		return logo_path;
	}



	public void setLogo_path(MultipartFile logo) throws IOException {
		 if (logo == null || logo.isEmpty()) {
		        this.logo_path = null;
		        return;
		    }
	    Path path = Paths.get("C:\\Users\\HP\\Desktop\\logo");

	    if (!Files.exists(path)) {
	        Files.createDirectories(path);
	    }

	    String fileName = UUID.randomUUID().toString() + ".png";
	    Path logoPath = path.resolve(fileName);
	    try (InputStream inputStream = logo.getInputStream()) {
	        Files.copy(inputStream, logoPath);
	    }

	    this.logo_path = logoPath.toString();
	}




	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getViews_number() {
		return views_number;
	}



	public void setViews_number(Integer views_number) {
		this.views_number = views_number;
	}



	public Boolean getIs_sponsored() {
		return is_sponsored;
	}



	public void setIs_sponsored(Boolean is_sponsored) {
		this.is_sponsored = is_sponsored;
	}



	public partners getPartner() {
		return partner;
	}



	public void setPartner(partners partner) {
		this.partner = partner;
	}



	public String getCouverture_path() {
		return couverture_path;
	}



	public void setCouverture_path(MultipartFile couverture) throws IOException {
		 if (couverture == null || couverture.isEmpty()) {
		        this.couverture_path = null;
		        return;
		    }
		Path path = Paths.get("C:\\Users\\HP\\Desktop\\couverture");

	    if (!Files.exists(path)) {
	        Files.createDirectories(path);
	    }

	    String fileName = UUID.randomUUID().toString() + ".png";
	    Path couverturePath = path.resolve(fileName);
	    try (InputStream inputStream = couverture.getInputStream()) {
	        Files.copy(inputStream, couverturePath);
	    }

	    this.couverture_path = couverturePath.toString();
	}



	public String getNumtel() {
		return numtel;
	}



	public void setNumtel(String numtel) {
		this.numtel = numtel;
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



	
}
