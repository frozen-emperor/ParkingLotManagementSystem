package com.app.service;

import java.util.List;

import com.app.entity.SlotEntity;

public interface SlotManagementService {

	public boolean bookSlot(int id);

	public void freeSlot(int d);
	
	public List<SlotEntity> getAllSlots();
	
	public List<SlotEntity> getAllFreeSlots();
}
