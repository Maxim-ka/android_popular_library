package reschikov.geekbrains.popularlibraries.rxjava;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import reschikov.geekbrains.popularlibraries.rxjava.model.Green;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExampleUnitTest {

	private static final int BOUND = 20;
	private Green green;
	private final Random random = new Random();
	private int x;
	private int y;
	private int correctResult;
	private int inCorrectResult;

	@Before
	public void init(){
		green = new Green();
		x = random.nextInt(BOUND);
		y = random.nextInt(BOUND);
		correctResult = x + y;
		do{
			inCorrectResult = random.nextInt(BOUND);
		}while (inCorrectResult == correctResult);
	}

	@Test
    public void addition_isCorrect() {
        assertEquals(String.format("test not passed %d != %d + %d", correctResult, x, y), correctResult, green.add(x, y));
    }

	@Test
	public void addition_isIncorrect() {
		assertNotEquals(String.format("test not passed %d = %d + %d", inCorrectResult, x, y), inCorrectResult, green.add(x, y));
	}
}