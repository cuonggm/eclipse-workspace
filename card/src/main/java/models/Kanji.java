package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="KANJIS")
public class Kanji {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="KANJI")
	private String kanji;
	
	@Column(name="HIRAGANA")
	private String hiragana;
	
	@Column(name="MEANING")
	private String meaning;
	
	@Column(name="HAN_VIET")
	private String hanViet;
	
	@Column(name="CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="UPDATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	public Kanji() {
		super();
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji) {
		this.kanji = kanji;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getHanViet() {
		return hanViet;
	}

	public void setHanViet(String hanViet) {
		this.hanViet = hanViet;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
