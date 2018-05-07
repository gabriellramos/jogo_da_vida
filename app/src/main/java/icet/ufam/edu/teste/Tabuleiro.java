package icet.ufam.edu.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tabuleiro extends AppCompatActivity {
    Jogo principal = new Jogo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabuleiro_layout);
        Bundle param = getIntent ().getExtras();
        String Nome = param.getString("nome");

        principal.setNome(Nome);
    }

    public int validaPretendente (EditText pretendente) {
        if (pretendente.getText ().toString ().equals ("")
                || pretendente.getText ().toString ().isEmpty ())
            return 0;
        else
            return 1;
    }

    public int validaCidade (EditText cidade){
        if (cidade.getText ().toString ().isEmpty ()
                || cidade.getText ().toString ().equals(""))
            return 0;
        else {
            return 1;
        }
    }

    public int validaIdade (EditText idade){
        if (idade.getText ().toString ().isEmpty ()
                || idade.getText ().toString ().equals("")
                || idade.getText ().toString () == null){
            return 0;
        } else{
            String id = idade.getText ().toString ();
            int idadeInt = Integer.parseInt (id);
            int cond = 1;
            if (idadeInt<=0)
                cond=0;
            return cond;
        }
    }

    public void validaTudo(View view) {
        EditText caixaId = (EditText) findViewById(R.id.idade);


        //Cidades
        EditText city1 = (EditText)findViewById(R.id.cidade1);
        EditText city2 = (EditText)findViewById(R.id.cidade2);
        EditText city3 = (EditText)findViewById(R.id.cidade3);


        //Pretendentes
        EditText pret1 = (EditText)findViewById(R.id.pretendente1);
        EditText pret2 = (EditText)findViewById(R.id.pretendente2);
        EditText pret3 = (EditText)findViewById(R.id.pretendente3);


        if (validaIdade(caixaId)==1
                && validaPretendente(pret1)==1
                && validaPretendente(pret2)==1
                && validaPretendente(pret3)==1
                && validaCidade(city1)==1
                && validaCidade(city2)==1
                && validaCidade(city3)==1){

            String strIdade = caixaId.getText().toString();
            int idade = Integer.parseInt(strIdade);

            String cidade1 = city1.getText().toString();
            String cidade2 = city2.getText().toString();
            String cidade3 = city3.getText().toString();

            String pretendente1 = pret1.getText().toString();
            String pretendente2 = pret2.getText().toString();
            String pretendente3 = pret3.getText().toString();

            principal.setIdade (idade);
            principal.setCit1(cidade1);
            principal.setCit2(cidade2);
            principal.setCit3(cidade3);
            principal.setPret1(pretendente1);
            principal.setPret2(pretendente2);
            principal.setPret3(pretendente3);

            if (principal.getNome ()!=null
                    && principal.getCidade1 () != null
                    && principal.getCidade2 () != null
                    && principal.getCidade3 () != null
                    && principal.getPret1 () != null
                    && principal.getPret2 () != null
                    && principal.getPret3 () != null
                    && principal.getIdade () > 0){
                Bundle param = new Bundle ();
                param.putString("nome",principal.getNome());
                param.putInt("id",principal.getIdade());
                param.putString("pret1",principal.getPret1());
                param.putString("pret2",principal.getPret2());
                param.putString("pret3",principal.getPret3());
                param.putString("cidade1",principal.getCidade1());
                param.putString("cidade2",principal.getCidade2());
                param.putString("cidade3",principal.getCidade3());

                Intent resu = new Intent(this, Resultado.class);
                resu.putExtras(param);
                startActivity(resu);
                finish();

            }
        }else
            Toast.makeText (this,"Preencha todos os requisitos",Toast.LENGTH_SHORT).show ();
    }
}
