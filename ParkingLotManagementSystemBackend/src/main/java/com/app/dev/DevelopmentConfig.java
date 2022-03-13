package com.app.dev;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopmentConfig {
	final Logger logger = LoggerFactory.getLogger(DevelopmentConfig.class);

	@Autowired
	private MockDataGenerator mockDataGenerator;

	@Value("${mock-data-setup-needed}")
	private boolean isMockDataSetupNeeded;

	@PostConstruct
	public void setupDevelopmentEnv() {
		logDevProfileActive();
		if (isMockDataSetupNeeded) {
			this.mockDataGenerator.init(17);
			this.mockDataGenerator.cleanup();
			this.mockDataGenerator.generateCompleteMockData();
		}else {
			logger.info("mock data not needed so setup aborted");
		}
	}

	private void logDevProfileActive() {
		logger.info("Development Profile Activated Successfully!!");
	}

}
