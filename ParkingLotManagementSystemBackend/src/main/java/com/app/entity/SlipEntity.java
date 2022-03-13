package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SlipEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String vehicleNumber;
	private Boolean isActive;
	private Integer slotId;
	private LocalDateTime inTime;
	private LocalDateTime outTime;
	
	@ManyToOne
	private UserEntity userEntity;

	public SlipEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SlipEntity(Integer id, String vehicleNumber, Boolean isActive, Integer slotId, LocalDateTime inTime,
			LocalDateTime outTime, UserEntity userEntity) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.isActive = isActive;
		this.slotId = slotId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.userEntity = userEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	public LocalDateTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}

	public LocalDateTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "SlipEntity [id=" + id + ", vehicleNumber=" + vehicleNumber + ", isActive=" + isActive + ", slotId="
				+ slotId + ", inTime=" + inTime + ", outTime=" + outTime + ", userEntity=" + userEntity + "]";
	}

}
