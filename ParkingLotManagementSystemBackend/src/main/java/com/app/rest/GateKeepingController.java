package com.app.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.entity.SlipEntity;
import com.app.entity.SlotEntity;
import com.app.entity.UserEntity;

public interface GateKeepingController {

	public ResponseEntity<List<SlotEntity>> getAllSlots();

	public List<SlotEntity> getOnlyFreeSlots();

	public SlipEntity requestForSlotByIdAndUserAndGetSlip(int slotId, UserEntity user);

	public int submitSlipAndFreeUpSlot(int slipId);

}
