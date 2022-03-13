package com.app.dev;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entity.SlipEntity;
import com.app.entity.SlotEntity;
import com.app.entity.UserEntity;
import com.app.enums.VehicleTypeEnum;
import com.app.repo.SlipRepository;
import com.app.repo.SlotRepository;
import com.app.repo.UserRepository;

@Component
public class MockDataGenerator {
	final Logger logger = LoggerFactory.getLogger(MockDataGenerator.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SlipRepository slipRepository;

	@Autowired
	private SlotRepository slotRepository;

	private int numberOfParkingSlots;
	private Map<VehicleTypeEnum, Integer> vehicleType2NumberOfSlots;

	public void init(int numberOfParkingSlots) {
		this.numberOfParkingSlots = numberOfParkingSlots;
		vehicleType2NumberOfSlots = new HashMap<>();

		// TODO make this independent of number of vehical types enum
		int numberOfTwoWheelerSlots = (int) Math.ceil(numberOfParkingSlots * 0.6);
		int numberOfFourWheelerSlots = (int) Math.ceil(numberOfParkingSlots * 0.3);
		int numberOfBusSlots = (int) Math.ceil(numberOfParkingSlots * 0.1);

		vehicleType2NumberOfSlots.put(VehicleTypeEnum.TWO_WHEELER, numberOfTwoWheelerSlots);
		vehicleType2NumberOfSlots.put(VehicleTypeEnum.FOUR_WHEELER, numberOfFourWheelerSlots);
		vehicleType2NumberOfSlots.put(VehicleTypeEnum.BUS, numberOfBusSlots);
	}

	public void generateCompleteMockData() {
		generateSlotMockData();
		generateUserMockData();
		generateSlipMockData();
	}

	private void generateSlotMockData() {

		if (slotRepository.count() > 0)
			return;
		// taking 60% slots for two wheelers
		for (Map.Entry<VehicleTypeEnum, Integer> entry : vehicleType2NumberOfSlots.entrySet()) {
			for (int i = 0; i < entry.getValue().intValue(); i++) {

				slotRepository.save(new SlotEntity(null, entry.getKey(), Boolean.FALSE, null));
			}
		}
		slotRepository.findAll().forEach(slot -> logger.info("slot entity added to db: " + slot.toString()));

	}

	private void generateUserMockData() {
		String[] names2PhonePairs = { "shailesh,8097180274", "sunil,8097887029", "sid,7864292012", "sonu,9087765423",
				"abhishek,8907810234" };

		if (userRepository.count() > 0)
			return;

		for (int i = 0; i < 5; i++) {
			String[] tokens = names2PhonePairs[i].split(",");
			userRepository.save(new UserEntity(null, tokens[0], tokens[1]));

		}
		userRepository.findAll().forEach(user -> logger.info("user entity added to db: " + user.toString()));

	}

	private void generateSlipMockData() {

		String[] vehicleNumbers = { "MH 2304", "MH 2405", "MH 7809" };
		List<UserEntity> users = userRepository.findAll().subList(0, 3);
		List<Integer> slotIds = slotRepository.findAll().stream().map(slot -> slot.getId())
				.collect(Collectors.toList());

		if (slipRepository.count() > 0)
			return;

		for (int i = 0; i < 3; i++) {		
			int slotIndex = ThreadLocalRandom.current().nextInt(0, numberOfParkingSlots - 1);
			int slotId = slotIds.get(slotIndex);

			SlipEntity saved = slipRepository.save(new SlipEntity(null, vehicleNumbers[i], Boolean.TRUE, slotId,
					LocalDateTime.now(), null, users.get(i)));
			try {
				SlotEntity slot = slotRepository.findById(slotId).get();

				slot.setSlipId(saved.getId());
				slot.setIsOccupied(Boolean.TRUE);
				slotRepository.save(slot);
			} catch (Exception e) {
				logger.info("slot change failed for id:" + slotId);
			}
		}
		slipRepository.findAll().forEach(slip -> logger.info("slip entity added to db: " + slip.toString()));

	}

	public void cleanup() {
		this.slipRepository.deleteAll();
		this.userRepository.deleteAll();
		this.slotRepository.deleteAll();
	}
}
