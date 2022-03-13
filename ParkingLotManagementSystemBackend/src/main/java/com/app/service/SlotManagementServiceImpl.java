package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.SlotEntity;
import com.app.repo.SlotRepository;

@Service
public class SlotManagementServiceImpl implements SlotManagementService {

	@Autowired
	private SlotRepository slotRepository;

	@Override
	public boolean bookSlot(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void freeSlot(int d) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SlotEntity> getAllSlots() {
		return slotRepository.findAll();
	}

	@Override
	public List<SlotEntity> getAllFreeSlots() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
