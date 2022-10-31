package com.example.SpringBootCRUD.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "maybay")
public class MayBay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8347783016285181610L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mamb")
	private Integer mamb;
	
	@Column(name = "loai")
	private String loai;
	
	@Column(name = "tambay")
	private Integer tambay;

	public Integer getMamb() {
		return mamb;
	}

	public void setMamb(Integer mamb) {
		this.mamb = mamb;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Integer getTambay() {
		return tambay;
	}

	public void setTambay(Integer tambay) {
		this.tambay = tambay;
	}

	@Override
	public String toString() {
		return "MayBay [mamb=" + mamb + ", loai=" + loai + ", tambay=" + tambay + "]";
	}

	
	
	
}
