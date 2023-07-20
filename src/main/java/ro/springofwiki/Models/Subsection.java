package ro.springofwiki.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "Subsection")
@Table(name = "Subsection")
public class Subsection {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Section section;
	
	public Subsection(String title, String description) {
		super();
		this.setTitle(title);
		this.setDescription(description);
	}
	
	public Subsection() {
		super();
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

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
