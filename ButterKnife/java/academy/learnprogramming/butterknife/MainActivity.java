package academy.learnprogramming.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //button = findViewById(R.id.button);

        button.setText("Zmieniony tekst");
    }

    @OnClick(R.id.button)
    public void buttonClick(){
        Toast.makeText(this, "BADUM TSSS", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.button)
    public boolean buttonLong(){
        Toast.makeText(this, "Trzymasz długoooooo!", Toast.LENGTH_SHORT).show();

        return true;
    }
}
