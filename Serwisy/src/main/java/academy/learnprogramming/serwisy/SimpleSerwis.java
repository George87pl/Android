package academy.learnprogramming.serwisy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class SimpleSerwis extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        for(int i = 0; i<=100; i++) {
            Toast.makeText(this, "Jestem z serwice", Toast.LENGTH_LONG).show();
        }
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }
}
