package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository  distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear() {
		List <Whisky> whiskies = whiskyRepository.getWhiskyByYear(1991);
		Whisky whisky = whiskies.get(0);
		assertEquals(12, whisky.getAge());
	}

	@Test
	public void canGetDistilleryByRegion() {
		List<Distillery> distilleries = distilleryRepository.getDistilleryByRegion("Highland");
		Distillery distillery = distilleries.get(0);
		assertEquals("Glendronach", distillery.getName());
	}

	@Test
	public void canGetWhiskiesByAge() {
		Distillery distillery = distilleryRepository.getOne(1L);
		List<Whisky> whiskies = whiskyRepository.getWhiskyByAge(distillery, 15);
		Whisky whisky = whiskies.get(0);
		assertEquals("The Glendronach Revival", whisky.getName());
	}

	@Test
	public void canGetWhiskyByRegion() {
		List<Whisky> whiskies = whiskyRepository.getWhiskyByRegion("Highland");
		assertEquals(2, whiskies.size());
	}

	@Test
	public void canGetDistilleryByWhiskyAge() {
		List<Distillery> distilleries = distilleryRepository.getDistilleryByAgeOfWhisky(15);
		assertEquals(1, distilleries.size());
	}
}
