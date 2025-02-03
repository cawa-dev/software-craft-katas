package com.cawadev.softwarecraft.katas.tripservice.exception;

import java.io.Serial;

public class CollaboratorCallException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -4584041339906109902L;

	public CollaboratorCallException(String message) {
		super(message);
	}
}
