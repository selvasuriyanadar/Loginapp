package loginapp.business;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserLoginSession implements Serializable {

  private String userName;

  public UserLoginSession() {
    userName = null;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void login(User user) {
    setUserName(user.getUserName());
  }

  public void logout() {
    setUserName(null);
  }

  public boolean isLoggedIn() {
    return userName != null;
  }
}
