package sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.practice.Login;

public class SessionManager {

    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    private final String KEY_USERNAME = "key_username";
    private final String KEY_EMAIL = "key_email";
    private final String KEY_IF_LOGGED_IN = "key_session_if_logged_in";

    private final String PREF_FILE_NAME = "learning"; // It will used as file name  in sharedprefrences
    private final int PRIVATE_MODE = 0; //it will used to private the file.

    public SessionManager(Context context){

        this.context =context;
        sp = context.getSharedPreferences(PREF_FILE_NAME,PRIVATE_MODE);
        editor = sp.edit();
    }

    //checking of the sharedprefrence
    public boolean checkSession(){
        if(sp.contains(KEY_IF_LOGGED_IN)){
            return true;
        }
        else {
            return false;
        }
    }

    //creating a session and storing username , email
    // password in not storing in the sharedprefrances because it not a good practice
    public void createSession(String username, String email){

        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_EMAIL,email);
        editor.putBoolean(KEY_IF_LOGGED_IN,true);
        editor.commit();

    }

    //getting username data
    public String getData(String Key){
        String value = sp.getString(Key,null);
        return value;
    }

    //for logout the session
    public void logoutSession(){
        editor.clear();
        editor.commit();

        Intent intent = new Intent(context, Login.class);
        context.startActivity(intent);
    }
}
