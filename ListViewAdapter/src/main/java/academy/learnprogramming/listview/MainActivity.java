package academy.learnprogramming.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        List<Owoc> listaOwocow = new ArrayList<>();

        for(int i=0; i<5; i++){
            listaOwocow.add(new Owoc("Agrest", "Kwaśny", 30));
            listaOwocow.add(new Owoc("Nektarynka", "Słodki", 5));
            listaOwocow.add(new Owoc("Kunkfat", "Cierpki", 2));
            listaOwocow.add(new Owoc("Grejpfrut", "Gorzki", 1));
        }

        MojAdapter mojAdapter = new MojAdapter(this, listaOwocow);

        lista.setAdapter(mojAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Kliknięto: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
