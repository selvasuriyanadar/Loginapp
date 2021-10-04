package loginapp.business;

import loginapp.data.UserDB;

public class UserLoginVerification {
  
  public static boolean isValidExistingUser(User user) {

    if (user.validate().isEmpty()) {

      if (UserDB.userExists(user)) {

        User userFromDb = new User();
        userFromDb.setUserName(user.getUserName());
        if (UserDB.selectUser(userFromDb) != null) {
          if (user.matches(userFromDb)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean isValidNewUser(User user) {

    if (user.validate().isEmpty()) {

      if (!UserDB.userExists(user)) {
        return true;
      }
    }
    return false;
  }
}
