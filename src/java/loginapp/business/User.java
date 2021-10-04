package loginapp.business;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class User implements Serializable {

  private String userName;
  private String password;

  public User(){
    userName = "";
    password = "";
  }

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Map<String, String> validateUserName() {

    Map<String, String> errors = new HashMap<>();

    if (userName == null || userName.equals("")) {
      errors.put("UserName", "User Name cannot be empty.");
    }
    else if (userName.length() > 15) {
      errors.put("UserName", "User Name cannot exceed 15 characters of length.");
    }

    return errors;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Map<String, String> validatePassword() {

    Map<String, String> errors = new HashMap<>();

    if (password == null || password.equals("")) {
      errors.put("Password", "Password cannot be empty.");
    }
    else if (password.length() > 15) {
      errors.put("Password", "Password cannot exceed 15 characters of length.");
    }
    else if (password.length() < 8) {
      errors.put("Password", "Password cannot be smaller than 8 characters of length.");
    }

    return errors;
  }

  public Map<String, String> validate() {

    Map<String, String> errors = new HashMap<>();

    errors.putAll(validateUserName());
    errors.putAll(validatePassword());

    return errors;
  }

  public boolean matches(User user) {
    return user.getUserName().equals(userName) && user.getPassword().equals(password);
  }
}
