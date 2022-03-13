package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.SlipEntity;
import com.app.entity.SlotEntity;
import com.app.entity.UserEntity;
import com.app.service.SlotManagementService;

@RestController
@RequestMapping("/gateKeeper")
public class GateKeepingControllerImpl implements GateKeepingController {

	@Autowired
	private SlotManagementService slotManagementService;

	@Override
	@GetMapping("/getAllSlotsPresent")
	public ResponseEntity<List<SlotEntity>> getAllSlots() {
		return new ResponseEntity<>(slotManagementService.getAllSlots(), HttpStatus.OK);
	}

	@Override
	public List<SlotEntity> getOnlyFreeSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SlipEntity requestForSlotByIdAndUserAndGetSlip(int slotId, UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int submitSlipAndFreeUpSlot(int slipId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
