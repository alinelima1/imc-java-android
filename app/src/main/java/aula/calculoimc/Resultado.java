package aula.calculoimc;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Aline on 05/10/2017.
 */

public class Resultado extends AppCompatActivity implements View.OnClickListener{

    ImageView imgmuitoGorda;
    ImageView imggorda;
    ImageView imgmedio;
    ImageView imgmagra;
    ImageView imgmuitoMagra;
    TextView resultado;
    Double resultImc;
    Button voltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultado);

        voltar = (Button)this.findViewById(R.id.btnVoltar);
        voltar.setOnClickListener(this);

        Bundle extra = getIntent().getExtras();
        resultImc = extra.getDouble("resultImc");
        resultImc = Double.valueOf(String.format(Locale.US, "%.2f", resultImc));

        chamaResult();

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void chamaResult() {
        imgmuitoGorda = (ImageView)this.findViewById(R.id.ivMuitoGorda);
        imgmuitoGorda.setVisibility(View.INVISIBLE);
        imggorda = (ImageView)this.findViewById(R.id.ivGorda);
        imggorda.setVisibility(View.INVISIBLE);
        imgmedio = (ImageView)this.findViewById(R.id.ivIdeal);
        imgmedio.setVisibility(View.INVISIBLE);
        imgmagra = (ImageView)this.findViewById(R.id.ivMagra);
        imgmagra.setVisibility(View.INVISIBLE);
        imgmuitoMagra = (ImageView)this.findViewById(R.id.ivMagra);
        imgmuitoMagra.setVisibility(View.INVISIBLE);
        resultado = (TextView)this.findViewById(R.id.tvResultado);

        if(resultImc < 16){
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está muito abaixo do peso!");
            imgmuitoMagra.setVisibility(View.VISIBLE);
        }else if (resultImc >= 16 && resultImc < 18.5){
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está abaixo do peso!");
            imgmagra.setVisibility(View.VISIBLE);
        }else if(resultImc >= 18.5 && resultImc < 25){
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está no peso ideal!");
            imgmedio.setVisibility(View.VISIBLE);
        }else if(resultImc >= 25 && resultImc < 30){
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está acima do peso!");
            imggorda.setVisibility(View.VISIBLE);
        }else if(resultImc >= 30 && resultImc < 35){
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está muito acima do peso!\nObesidade Grau 1");
            imgmuitoGorda.setVisibility(View.VISIBLE);
        }else if(resultImc >= 35 && resultImc < 40) {
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está muito acima do peso!\nObesidade Grau 2");
            imgmuitoGorda.setVisibility(View.VISIBLE);
        }else if(resultImc >= 40) {
            resultado.setText("Seu IMC é " + resultImc + "\nVocê está muito acima do peso!\nObesidade Grau 3");
            imgmuitoGorda.setVisibility(View.VISIBLE);
        }
    }
}
