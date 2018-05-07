package icet.ufam.edu.teste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sairJogo (View view){
        finish();
        System.exit(0);
    }

    public void iniciaJogo (View view){
        Intent inicio = new Intent(this, TelaInicio.class);
        startActivity(inicio);
        finish();
    }

}
