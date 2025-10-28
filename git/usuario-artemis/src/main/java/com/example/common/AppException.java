/**
 * Copyright (c) 2025.
 */
package com.example.common;

/**
 * Excepción personalizada not-checked:runtime exception:silenciosa.
 */
public class AppException extends RuntimeException {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje.
	 * @param message Mensaje de la excepción.
	 */
	public AppException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe una excepción.
	 * @param e Excepción original.
	 */
	public AppException(Exception e) {
		super(e);
	}
}
