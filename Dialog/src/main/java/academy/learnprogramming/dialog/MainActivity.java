package academy.learnprogramming.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCustomDialog();

//        AlertDialog dialog = new AlertDialog.Builder(this)
//                .setCancelable(false)
//                .setTitle("Kurs Android")
//                .setMessage("Podoba Ci się kurs?")
//                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                }).setNegativeButton("Nie", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "No nie lubię", Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
    }

    public void createCustomDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_test);
        dialog.setTitle("Test");

        Button exit = dialog.findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
