package loginapp.controller;

import loginapp.business.UserLoginSession;
import loginapp.business.UserLoginVerification;
import loginapp.business.User;
import loginapp.data.UserDB;

public class UserLoginController {

  public static boolean register(
        String userName,
        String password,
        String confirmPassword) {

    if (password != null
          && confirmPassword != null
          && password.equals(confirmPassword)) {

      User user = new User();
      user.setUserName(userName);
      user.setPassword(password);
      if (UserLoginVerification.isValidNewUser(user)) {

        if (UserDB.createUser(user) != 0) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean login(
        UserLoginSession userLoginSession,
        String userName,
        String password) {

    User user = new User();
    user.setUserName(userName);
    user.setPassword(password);
    if (UserLoginVerification.isValidExistingUser(user)) {

      userLoginSession.login(user);
      return true;
    }

    return false;
  }

  public static boolean updatePassword(
        UserLoginSession userLoginSession,
        String oldPassword,
        String password,
        String confirmPassword) {

    if (userLoginSession.isLoggedIn()) {

      User user = new User();
      user.setUserName(userLoginSession.getUserName());
      user.setPassword(oldPassword);
      if (UserLoginVerification.isValidExistingUser(user)) {

        if (password != null
              && confirmPassword != null
              && password.equals(confirmPassword)) {

          user.setPassword(password);
          if (user.validate().isEmpty())
          {

            if (UserDB.updatePassword(user) != 0) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  public static void logout(
        UserLoginSession userLoginSession) {

    if (userLoginSession.isLoggedIn()) {
      userLoginSession.logout();
    }
  }

  public static boolean deleteUser(
        UserLoginSession userLoginSession) {

    if (userLoginSession.isLoggedIn()) {

      User user = new User();
      user.setUserName(userLoginSession.getUserName());
      if (UserDB.deleteUser(user) != 0) {
        return true;
      }
    }

    return false;
  }
}
