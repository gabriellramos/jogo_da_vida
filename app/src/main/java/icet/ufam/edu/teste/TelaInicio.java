package icet.ufam.edu.teste;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInicio extends AppCompatActivity{
    public Jogo principal = new Jogo();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState );
        setContentView(R.layout.tela_inicio1);
    }

    public void voltarInicio (View view){
        Intent voltar = new Intent(this, MainActivity.class);
        voltar.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        startActivity(voltar);
        finish();
    }

    protected int validaCampo( EditText nome){
        if (nome.getText().toString().equals("") || nome.getText().toString().equals(" ") ) {
            Toast.makeText(TelaInicio.this, "Nome inválido!", Toast.LENGTH_LONG).show();
            return 0;
        }else{
            return 1;
        }

    }

    public void continuarEtp2(View view){
        EditText caixaNome = (EditText) findViewById(R.id.caixaNome);
        String Nome;
        if (validaCampo(caixaNome)==1){
            Nome = caixaNome.getText().toString();
            Toast.makeText (this, "OK!", Toast.LENGTH_LONG).show ();
            principal.setNome (Nome);
            Intent etp2 = new Intent (this, Tabuleiro.class);
            Bundle param = new Bundle ();
            param.putString ("nome", Nome);
            etp2.putExtras (param);
            startActivity (etp2);
            finish ();
        }
    }

}
