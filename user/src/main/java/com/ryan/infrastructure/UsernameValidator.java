package com.ryan.infrastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {

  // strict regex
  private static final String USERNAME_PATTERN =
      "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

  private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

  private UsernameValidator() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean isValid(final String username) {
    Matcher matcher = pattern.matcher(username);
    return matcher.matches();
  }

}

