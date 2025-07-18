package ENTITIES;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class stores_categories implements Serializable  {
	    @ManyToOne
	    @JoinColumn(name = "store_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private stores store;
	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private categories category;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;

		public stores_categories() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public stores_categories(stores store, categories category) {
			super();
			this.store = store;
			this.category = category;
		}



		public stores getStore() {
			return store;
		}

		public void setStore(stores store) {
			this.store = store;
		}

		public categories getCategory() {
			return category;
		}

		public void setCategory(categories category) {
			this.category = category;
		}

		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}

}
