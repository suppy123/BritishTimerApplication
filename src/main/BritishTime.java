package main;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BritishTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter time in HH:mm format (e.g., 2:45): \n");
			System.out.println("Press Enter on an empty line to quit.");

			while (true) {
				System.out.println("Enter time\n");
				String input = sc.nextLine();
				if (input.isEmpty()) {
					System.out.println("Exiting the program. Thank you!..");
					break;
				}
				
				String outPut = "";
				try {
					DateTimeFormatter format = DateTimeFormatter.ofPattern("H:m");
					LocalTime valTime = LocalTime.parse(input, format);
					outPut = callBritishTimeConverter(valTime);
					System.out.println("British Time = " + outPut);
				} catch (DateTimeException e) {
					System.out.println("Invalid input, please provide input in valid format HH:mm \n" + e.getMessage());
					return;
				}
			}
			sc.close();
		}
	}

	public static String callBritishTimeConverter(LocalTime input) {
		int hour = input.getHour();
		int min = input.getMinute();

		if (hour == 0 && min == 0)
			return "midnight";
		if (hour == 12 && min == 0)
			return "noon";

		String[] numbers = { "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "one" };

		if (min == 0) 
			return numbers[hour % 12] + " o'clock";
		else if (min == 15) 
			return "quarter past " + numbers[hour % 12];
		 else if (min == 30) 
			return "half past " + numbers[hour % 12];
		 else if (min == 45) 
			return "quarter to " + numbers[(hour + 1) % 12];
		 else if  (min == 5 || min == 10 || min == 20 || min == 25) 
			return minToWords(min) + " past " + numbers[hour % 12];
		 else if (min == 35 || min == 40 || min == 50 || min == 55)
	        return minToWords(60 - min) + " to " + numbers[(hour + 1) % 12]; 
		else 
			return numbers[hour % 12] + " " + minToWords(min);

	}

	private static String minToWords(int minute) {
		String[] minWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			    "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two",
			    "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven",
			    "twenty-eight", "twenty-nine", "thirty", "thirty-one", "thirty-two",
			    "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven",
			    "thirty-eight", "thirty-nine", "forty", "forty-one", "forty-two", "forty-three",
			    "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight",
			    "forty-nine", "fifty", "fifty-one", "fifty-two", "fifty-three", "fifty-four",
			    "fifty-five", "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine" };
		return minWords[minute];
	}
}
