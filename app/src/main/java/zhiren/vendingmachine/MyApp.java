package zhiren.vendingmachine;

import android.app.Application;

import com.xuhao.android.libsocket.sdk.OkSocket;

/**
 * Author: andy
 * Time:2018/10/11 0011
 * Description:
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //The primary process needs to be distinguished at the beginning of the primary process.
        OkSocket.initialize(this);
        //If you need to open the Socket debug log, configure the following
        //OkSocket.initialize(this,true);
    }

}
