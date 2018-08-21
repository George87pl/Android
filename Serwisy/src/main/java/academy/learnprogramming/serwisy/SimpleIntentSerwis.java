package academy.learnprogramming.serwisy;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class SimpleIntentSerwis extends IntentService {

    Handler handler = new Handler();

    public SimpleIntentSerwis() {
        super("TestWorker");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Witaj świecie", Toast.LENGTH_LONG).show();
                handler.postDelayed(this, 4000);
            }
        });

    }
}
