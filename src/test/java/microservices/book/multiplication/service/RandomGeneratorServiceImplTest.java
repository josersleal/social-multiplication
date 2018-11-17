package microservices.book.multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RandomGeneratorServiceImplTest {

	private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() {
		List<Integer> randomFactors = IntStream.range(0, 1000)
				.map(i -> randomGeneratorServiceImpl.generateRandomFactor()).boxed().collect(Collectors.toList());
		System.out.println(randomFactors);
		assertThat(randomFactors).isSubsetOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
	}

}
