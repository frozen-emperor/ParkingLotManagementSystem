package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.enums.VehicleTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SlotEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private VehicleTypeEnum vehicleType;
	private Boolean isOccupied;

	@JsonIgnore
	private Integer slipId;

	public SlotEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SlotEntity(Integer id, VehicleTypeEnum vehicleType, Boolean isOccupied, Integer slipId) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.isOccupied = isOccupied;
		this.slipId = slipId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(Boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Integer getSlipId() {
		return slipId;
	}

	public void setSlipId(Integer slipId) {
		this.slipId = slipId;
	}

	@Override
	public String toString() {
		return "SlotEntity [id=" + id + ", vehicleType=" + vehicleType + ", isOccupied=" + isOccupied + ", slipId="
				+ slipId + "]";
	}

}
