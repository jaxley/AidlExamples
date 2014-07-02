// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package net.axley.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class GreetingService extends Service
{

    public GreetingService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        Log.d("service bound", "bound");
        return serviceBinder;
    }

    private final IGreetingService.Stub serviceBinder = new IGreetingService.Stub() {

        public String greet(String s)
        {
            return String.format("Hola %s", new Object[] {
                s
            });
        }
/* decompiler garbage */
/*        final GreetingService this$0;

            
            {
                this$0 = GreetingService.this;
                super();
            }*/
    }
;
}
