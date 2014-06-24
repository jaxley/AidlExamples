package net.axley.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class GreetingService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // Return the communication channel to the service.
        Log.d("service bound", "bound");
        return serviceBinder;
    }

    /**
     * Implementation of the service stub that actually does the work when requests are received
     */
    private final IGreetingService.Stub serviceBinder = new IGreetingService.Stub() {

        public String greet(String personName) {
            return String.format("Hola %s", personName);
        }
    };
}