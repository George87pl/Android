package academy.learnprogramming.newdatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLiteDatabase bazaGrzesia = getBaseContext().openOrCreateDatabase("bazaGrzesia", MODE_PRIVATE, null);

//        String sql;
//        sql = "DROP TABLE IF EXISTS contacts;";
//        Log.d(TAG, "onCreate: sql = " + sql);
//        bazaGrzesia.execSQL(sql);
//        sql = "CREATE TABLE IF NOT EXISTS contacts(name TEXT, phone INTEGER, email TEXT);";
//        Log.d(TAG, "onCreate: sql is " + sql);
//        bazaGrzesia.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES('tim', 56783, 'tim@email.com');";
//        Log.d(TAG, "onCreate: sql is " + sql);
//        bazaGrzesia.execSQL(sql);
//        sql = "INSERT INTO contacts VALUES('Fred', 123456, 'fred@nurki.com');";
//        Log.d(TAG, "onCreate: sql is " + sql);
//        bazaGrzesia.execSQL(sql);

        Cursor zapytanie = bazaGrzesia.rawQuery("SELECT * FROM contacts;", null);

        textView = findViewById(R.id.textView);

        String imie;
        int numer;
        String email;

        if(zapytanie.moveToFirst()){
            do  {
                imie = zapytanie.getString(0);
                numer = zapytanie.getInt(1);
                email = zapytanie.getString(2);

                textView.append(imie + " | " + numer + " | " + email + "\n");

            } while (zapytanie.moveToNext());
        }
        zapytanie.close();
        bazaGrzesia.close();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
