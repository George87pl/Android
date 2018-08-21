package academy.learnprogramming.samolot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewSamolot;
    float x = 0;
    float y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewSamolot = findViewById(R.id.imageViewSamolot);
        Button buttonUp = findViewById(R.id.buttonUp);
        Button buttonDown = findViewById(R.id.buttonDown);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        Button buttonRight = findViewById(R.id.buttonRight);

        View.OnClickListener buttonMove = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation samolot;

                switch(v.getId()){
                    case R.id.buttonUp:
                        samolot = new TranslateAnimation(Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, y, Animation.RELATIVE_TO_SELF, y += -1);
                        samolot.setDuration(1000);
                        imageViewSamolot.startAnimation(samolot);
                        samolot.setFillAfter(true);
                        break;
                    case R.id.buttonDown:
                        samolot = new TranslateAnimation(Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, y, Animation.RELATIVE_TO_SELF, y += 1);
                        samolot.setDuration(1000);
                        imageViewSamolot.startAnimation(samolot);
                        samolot.setFillAfter(true);
                        break;
                    case R.id.buttonLeft:
                        samolot = new TranslateAnimation(Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, x += -1, Animation.RELATIVE_TO_SELF, y, Animation.RELATIVE_TO_SELF, y);
                        samolot.setDuration(1000);
                        imageViewSamolot.startAnimation(samolot);
                        samolot.setFillAfter(true);
                        break;
                    case R.id.buttonRight:
                        samolot = new TranslateAnimation(Animation.RELATIVE_TO_SELF, x, Animation.RELATIVE_TO_SELF, x += 1, Animation.RELATIVE_TO_SELF, y, Animation.RELATIVE_TO_SELF, y);
                        samolot.setDuration(1000);
                        imageViewSamolot.startAnimation(samolot);
                        samolot.setFillAfter(true);
                        break;
                }
            }
        };

        buttonUp.setOnClickListener(buttonMove);
        buttonDown.setOnClickListener(buttonMove);
        buttonLeft.setOnClickListener(buttonMove);
        buttonRight.setOnClickListener(buttonMove);
    }
}
