package net.axley.aidlclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import net.axley.aidlserver.IGreetingService;


public class ClientHomeActivity extends Activity {

    private IGreetingService greetingService;
    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);

        // change the text to that returned by the service
        greetingText = (TextView)findViewById(R.id.greetingText);

        bindService(new Intent("net.axley.aidlserver.IGreetingService"),
                greetingServiceConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.client_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ServiceConnection greetingServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           greetingService = IGreetingService.Stub.asInterface(iBinder);

            try {
                greetingText.setText(greetingService.greet("Jim Bob"));
            } catch (RemoteException e) {
                greetingText.setText(e.getStackTrace().toString());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // don't care
        }
    };
}
