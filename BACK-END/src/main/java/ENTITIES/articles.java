package ENTITIES;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;



@Entity
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class articles implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.
	IDENTITY)
	private Integer id;
	@NotNull
	private String title;
	private String description;
	@NotNull
	private String size;
	private String color;
	@NotNull
	private Integer price;
	private String brand;
	@NotNull
	private Integer quantity;
	@NotNull
	private String picture_path;
	private Integer views_number;
	@NotNull
	private LocalDateTime created_at=LocalDateTime.now();
	@Type(type = "pgsql_enum")
    private article_status_ref status;
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private categories categorie;
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private stores store;
	
	public articles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public articles(Integer id, String title, String description, String size, String color, Integer price,
			String brand, Integer quantity, String picture_path, Integer views_number, LocalDateTime created_at,
			article_status_ref status, categories categorie, stores store) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.size = size;
		this.color = color;
		this.price = price;
		this.brand = brand;
		this.quantity = quantity;
		this.picture_path = picture_path;
		this.views_number = views_number;
		this.created_at = created_at;
		this.status = status;
		this.categorie = categorie;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public void setPicture_path(List<MultipartFile> pictures) throws IOException {
		Path path = Paths.get("C:\\Users\\HP\\Desktop\\pictures");
		  if (!Files.exists(path)) {
		        Files.createDirectories(path);
		    }
		
		StringJoiner sj = new StringJoiner(";");
	    for (MultipartFile picture : pictures) {
	        if (!picture.isEmpty()) {
	            String fileName = UUID.randomUUID().toString() + ".png";
	            Path picturePath = path.resolve(fileName);
	            try (InputStream inputStream = picture.getInputStream()) {
	                Files.copy(inputStream, picturePath);
	            }
	            sj.add(picturePath.toString());
	        }
	    }

		this.picture_path = sj.toString();
	}

	public Integer getViews_number() {
		return views_number;
	}

	public void setViews_number(Integer views_number) {
		this.views_number = views_number;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public article_status_ref getStatus() {
		return status;
	}

	public void setStatus(article_status_ref status) {
		this.status = status;
	}

	public categories getCategorie() {
		return categorie;
	}

	public void setCategorie(categories categorie) {
		this.categorie = categorie;
	}

	public stores getStore() {
		return store;
	}

	public void setStore(stores store) {
		this.store = store;
	}
	
	
    
	
    
	
}
