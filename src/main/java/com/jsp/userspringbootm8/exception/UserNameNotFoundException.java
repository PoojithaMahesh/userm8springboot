package com.jsp.userspringbootm8.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNameNotFoundException extends RuntimeException {
private String message;

}
