package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class BritishTimeTest {

		// TODO Auto-generated method stub
		@Test
		public void testOClock() {
			assertEquals("one o'clock", BritishTime.callBritishTimeConverter(LocalTime.of(1, 0)));
		}
	
		@Test
		public void testFivesPast() {
			assertEquals("five past two", BritishTime.callBritishTimeConverter(LocalTime.of(2, 5)));
		}
		
		@Test
		public void testMinutesPast() {
		    assertEquals("ten past three", BritishTime.callBritishTimeConverter(LocalTime.of(3, 10)));
		}

		@Test
		public void testQuarterPast() {
		    assertEquals("quarter past four", BritishTime.callBritishTimeConverter(LocalTime.of(4, 15)));
		}
		
		@Test
		public void testOtherTime() {
		    assertEquals("six thirty-two", BritishTime.callBritishTimeConverter(LocalTime.of(6, 32)));
		}
		
		@Test
		public void testHalfPast() {
		    assertEquals("half past seven", BritishTime.callBritishTimeConverter(LocalTime.of(7, 30)));
		}
		
		@Test
		public void testQuarterTo() {
		    assertEquals("quarter to ten", BritishTime.callBritishTimeConverter(LocalTime.of(9, 45)));
		}
		
		@Test
		public void testMinutesTo() {
		    assertEquals("ten to eleven", BritishTime.callBritishTimeConverter(LocalTime.of(10, 50)));
		}
		
		@Test
		public void testMidnight() {
		    assertEquals("midnight", BritishTime.callBritishTimeConverter(LocalTime.of(0, 0)));
		}
		
		@Test
		public void testNoon() {
		    assertEquals("noon", BritishTime.callBritishTimeConverter(LocalTime.of(12, 0)));
		}
}