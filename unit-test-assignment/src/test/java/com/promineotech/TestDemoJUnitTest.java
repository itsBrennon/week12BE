package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForSubtractSmallFromBig")
	void assertThatASmallerNumberIsSubtractedFromABiggerNumber(int a, int b, int expected, boolean  expectException) {
		if (!expectException) {
			assertThat(testDemo.subtractSmallFromBig(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(()  -> testDemo.subtractSmallFromBig(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForSubtractSmallFromBig(){
		//@formatter:off
		return Stream.of(
				arguments(3, 2, 1, false),
				arguments(2, 3, -2, true),
				arguments(3, -1, 4, false),
				arguments(-1, -2, 1, false),
				arguments(-2, -2, -1, true),
				arguments(2, 2, 0, true)
			);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(1, 3, 4, false),
				arguments(-1, 2, 5, true),
				arguments(0, 1, 1, true)
				);
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
}
