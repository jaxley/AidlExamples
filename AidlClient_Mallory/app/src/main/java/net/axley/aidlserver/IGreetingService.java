// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package net.axley.aidlserver;

import android.os.*;

public interface IGreetingService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IGreetingService {

        public static IGreetingService asInterface(IBinder ibinder) {
            if (ibinder == null)
                return null;
            IInterface iinterface = ibinder.queryLocalInterface("net.axley.aidlserver.IGreetingService");
            if (iinterface != null && (iinterface instanceof IGreetingService))
                return (IGreetingService) iinterface;
            else
                return new net.axley.aidlserver.IGreetingService.Stub.Proxy(ibinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
                throws RemoteException {
            switch (i) {
                default:
                    return super.onTransact(i, parcel, parcel1, j);

                case 1598968902:
                    parcel1.writeString("net.axley.aidlserver.IGreetingService");
                    return true;

                case 1: // '\001'
                    parcel.enforceInterface("net.axley.aidlserver.IGreetingService");
                    String s = greet(parcel.readString());
                    parcel1.writeNoException();
                    parcel1.writeString(s);
                    return true;
            }
        }

        private static final String DESCRIPTOR = "net.axley.aidlserver.IGreetingService";
        static final int TRANSACTION_greet = 1;

        public Stub() {
            attachInterface(this, "net.axley.aidlserver.IGreetingService");
        }

        private static class Proxy
                implements IGreetingService {

            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return "net.axley.aidlserver.IGreetingService";
            }

            public String greet(String s)
                    throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                try {
                    parcel.writeInterfaceToken("net.axley.aidlserver.IGreetingService");
                    parcel.writeString(s);
                    mRemote.transact(1, parcel, parcel1, 0);
                    parcel1.readException();
                    s1 = parcel1.readString();
                } finally {
                    parcel1.recycle();
                    parcel.recycle();
                }
                return s1;

            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }
    }

    public abstract String greet(String s)
        throws RemoteException;
}
