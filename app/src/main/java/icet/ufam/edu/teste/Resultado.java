package icet.ufam.edu.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    public Jogo principal = new Jogo ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle param = getIntent ().getExtras();
        setContentView(R.layout.resultado);
        principal.setNome(param.getString("nome"));
        principal.setIdade(param.getInt("id"));
        principal.setPret1(param.getString("pret1"));
        principal.setPret2(param.getString("pret2"));
        principal.setPret3(param.getString("pret3"));
        principal.setCit1(param.getString("cidade1"));
        principal.setCit2(param.getString("cidade2"));
        principal.setCit3(param.getString("cidade3"));
        Mostra ();
    }

    public void Mostra(){
        principal.verificaFilhos(principal.getIdade()+19);
        String filhos = Integer.toString(principal.getFilhos());
        principal.setClasse(principal.getIdade()+78);
        String classeFinal = principal.getClasse();
        String ciddeFinal = principal.sortCidades(principal.getIdade()+5);
        String pretFinal = principal.sortPretendentes(principal.getIdade()+98);

        TextView resutado = (TextView) findViewById(R.id.resultado);
        String mensagemResultadoComNome = "Resultado do seu jogo " +principal.getNome ()+":";
        resutado.setText(mensagemResultadoComNome);

        TextView mensagemFilhos = (TextView) findViewById(R.id.mensagemFilhos);
        String mensagemFilhosFinal = "Você terá "+filhos+" filhos!";
        mensagemFilhos.setText(mensagemFilhosFinal);

        TextView mensagemCasamento = (TextView) findViewById(R.id.mensagemCasamento);
        String mensagemCasamentoFinal = "Você casará com "+pretFinal+"!";
        mensagemCasamento.setText(mensagemCasamentoFinal);

        TextView mensagemClasse = (TextView) findViewById(R.id.mensagemClasse);
        String mensagemClasseFinal = null;
        if (classeFinal!=null && classeFinal.equalsIgnoreCase ("Pobre"))
            mensagemClasseFinal = "Poxa "+principal.getNome()+", infelizmente ou felizmente você será "+classeFinal+"!";
        else if (classeFinal!=null && classeFinal.equalsIgnoreCase ("Rico(a)"))
            mensagemClasseFinal = "Parabéns"+principal.getNome()+", você será "+classeFinal+"!";
        else
            mensagemClasseFinal = "Olha "+principal.getNome()+", sorte grande! Você será "+classeFinal+"!";

        mensagemClasse.setText(mensagemClasseFinal);

        TextView mensagemCidadeFinal = (TextView) findViewById (R.id.mensagemMorada);
        String mensagemMoradaFinal = "Você irá morar em "+ciddeFinal+"!";
        mensagemCidadeFinal.setText (mensagemMoradaFinal);

    }

    public void finalizar(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
        finish();
    }
}
