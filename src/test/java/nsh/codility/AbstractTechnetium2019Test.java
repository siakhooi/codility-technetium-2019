package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class AbstractTechnetium2019Test {
	abstract Technetium2019Interface getTestObject();

	@Test
	void test01() {
		int[][] A = new int[][] { { 9, 9, 7 }, { 9, 7, 2 }, { 6, 9, 5 }, { 9, 1, 2 } };
		String E = "997952";
		assertEquals(E, getTestObject().solution(A));
	}

	@Test
	@DisplayName("Non-Repeat")
	void test02() {
		int[][] A = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		String E = "14789";
		assertEquals(E, getTestObject().solution(A));
	}

	@Test
	void test03() {
		int[][] A = new int[][] { { 1, 2, 4, 6 }, { 2, 3, 5, 7 }, { 3, 5, 7, 8 }, { 4, 9, 8, 9 } };
		String E = "1246789";
		assertEquals(E, getTestObject().solution(A));
	}

	@Test
	@DisplayName("Single Digit")
	void test04() {
		int[][] A = new int[][] { { 2 } };
		String E = "2";
		assertEquals(E, getTestObject().solution(A));
	}

}
