package com.intevtory.model;

import jakarta.persistence.*;


@Entity
@Table(name = "item_type")
public class ItemType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_type_id")
	private long id;

	@Column(name = "type_name")
	private String typeName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
