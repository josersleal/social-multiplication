package microservices.book.multiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;

public class MultiplicationServiceImplTest {
	private MultiplicationServiceImpl multiplicationServiceImpl;
	@Mock
	private RandomGeneratorService randomGeneratorService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
	}

	@Test
	public void createRandomMultiplicationTest() {
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
//		assertThat(multiplication.getResult()).isEqualTo(1500);
	}

	@Test
	public void checkCorrectAttemptTest() throws Exception {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("John Doe");
		MultiplicationResultAttempt resAttempt = new MultiplicationResultAttempt(user, multiplication, 3000);

//	When
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(resAttempt);
//		assert
		assertThat(attemptResult).isTrue();
	}

	@Test
	public void checkWrongAttemptTest() throws Exception {
		Multiplication multiplication = new Multiplication(50, 60);
		User user = new User("John Doe");
		MultiplicationResultAttempt resAttempt = new MultiplicationResultAttempt(user, multiplication, 3010);

//	When
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(resAttempt);
//		assert
		assertThat(attemptResult).isFalse();
	}
}
