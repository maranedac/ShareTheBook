package cl.mac.sharethebook.login;

import cl.mac.sharethebook.data.CurrentUser;

/**
 * Created by Michael on 26-06-2017.
 */

public class LoginValidation {

    LoginCallback callback;

    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    public void validate() {
        if (new CurrentUser().getCurrent() != null) {
            callback.logged();
        } else {
            callback.signIn();
        }

    }

}
