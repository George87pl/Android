package academy.learnprogramming.broadcastreceiver;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int numerID = 5;

    private IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    private BroadcastReceiver broadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Masz nowego SMS!", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcast, filter);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS}, numerID);
        int i = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if(i == PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission", "Mamy ciągle pozwolenie!");
        }

        Intent intent = new Intent();
        intent.setAction("pl.kursandroid.mojaFajnaAkcja");
        sendBroadcast(intent);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == numerID) {
            Log.i("Permission", "Mamy pozwolenie");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcast, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcast);
    }
}
