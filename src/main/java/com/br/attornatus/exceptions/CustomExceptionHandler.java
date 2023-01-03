package com.br.attornatus.exceptions;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.attornatus.DTO.ExceptionResponseDTO;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponseDTO> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
				LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString(), ex.getMessage(),
				request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PessoaException.class)
	public final ResponseEntity<ExceptionResponseDTO> handlePessoaException(Exception ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
				LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString(), ex.getMessage(),
				request.getDescription(false), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponseDTO> handleNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
				LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString(), ex.getMessage(),
				request.getDescription(false), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EnderecoException.class)
	public final ResponseEntity<ExceptionResponseDTO> handleEnderecoException(Exception ex, WebRequest request) {
		ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
				LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toString(), ex.getMessage(),
				request.getDescription(false), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
