package com.ustglobal.jpawithhibernateapp.onetomany;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Table(name="pencil_box")
@Data
public class PencilBox {

	@Column
	@Id
	private int bid;
	
	@Column
	private String bname;
	
	@Exclude
	@OneToMany(mappedBy = "pencilBox")
	private List<Pencil> pencil;
}
