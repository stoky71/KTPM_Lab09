package com.example.SpringBootCRUD.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "chuyenbay")
public class ChuyenBay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8090123623946330367L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macb")
	private String macb;
	
	@Column(name = "gadi")
	private String gadi;
	
	@Column(name = "gaden")
	private String gaden;
	
	@Column(name = "dodai")
	private Integer dodai;
	
	@Column(name = "giodi")
	private Date giodi;
	
	@Column(name = "gioden")
	private Date gioden;
	
	@Column(name = "chiphi")
	private Integer chiphi;

	public String getMacb() {
		return macb;
	}

	public void setMacb(String macb) {
		this.macb = macb;
	}

	public String getGadi() {
		return gadi;
	}

	public void setGadi(String gadi) {
		this.gadi = gadi;
	}

	public String getGaden() {
		return gaden;
	}

	public void setGaden(String gaden) {
		this.gaden = gaden;
	}

	public Integer getDodai() {
		return dodai;
	}

	public void setDodai(Integer dodai) {
		this.dodai = dodai;
	}

	public Date getGiodi() {
		return giodi;
	}

	public void setGiodi(Date giodi) {
		this.giodi = giodi;
	}

	public Date getGioden() {
		return gioden;
	}

	public void setGioden(Date gioden) {
		this.gioden = gioden;
	}

	public Integer getChiPhi() {
		return chiphi;
	}

	public void setChiPhi(Integer chiphi) {
		this.chiphi = chiphi;
	}
	
	public ChuyenBay(String macb, String gadi, String gaden, Integer dodai, Date giodi, Date gioden, Integer chiphi) {
		super();
		this.macb = macb;
		this.gadi = gadi;
		this.gaden = gaden;
		this.dodai = dodai;
		this.giodi = giodi;
		this.gioden = gioden;
		this.chiphi = chiphi;
	}
	
	public ChuyenBay() {
		super();
	}

	@Override
	public String toString() {
		return "ChuyenBay [macb=" + macb + ", gadi=" + gadi + ", gaden=" + gaden + ", dodai=" + dodai + ", giodi="
				+ giodi + ", gioden=" + gioden + ", chiPhi=" + chiphi + "]";
	}
	
	
	
	
}
