package com.eanurag.math;

import java.util.Random;

/**
 * Library to generate Random numbers
 * @author anurag
 *
 */
public class RandomNumberGenerator {
	// could also use Math.Random() here
	static Random random = new Random();

	/**
	 * Generates big positive random number
	 * @return
	 */
	public static Integer generateRandom() {
		Integer rand = random.nextInt();
		return rand > 0 ? rand : generateRandom();
	}

	/**
	 * Generates big positive random number
	 * @param stop : the upper limit
	 * @return
	 */
	public static Integer generateRandom(int stop) {
		return random.nextInt(stop);
	}

	/**
	 * Generates big positive random number
	 * @param start : the lower limit
	 * @param stop	: the upper limit
	 * @return
	 */
	public static Integer generateRandom(int start, int stop) {
		// making double sure that the user input is in correct order
		Integer low = Math.min(start, stop);
		Integer high = Math.max(start, stop);

		return random.nextInt(high - low) + low;
	}
}
