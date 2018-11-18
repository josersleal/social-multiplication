package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
	Multiplication createRandomMultiplication();

	Boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
