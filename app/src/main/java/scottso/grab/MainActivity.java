package scottso.grab;

import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.parse.LogInCallback;
import com.parse.Parse;

import com.parse.ParseException;

import com.parse.ParseUser;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    private LoginButton loginBtn;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "rImfNv4tT49YDypqeW0EBVwwES7b8GBIeeilMjsi", "HUbrGgOnHXM3DpWo2aHJ8AGZUyHOhFOPokyEoLNJ");

        FacebookSdk.sdkInitialize(getApplicationContext());

        loginBtn = (LoginButton) findViewById(R.id.login_button);



    }



    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
