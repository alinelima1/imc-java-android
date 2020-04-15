package aula.calculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editPeso;
    EditText editAltura;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = (EditText)this.findViewById(R.id.etPeso);
        editAltura = (EditText)this.findViewById(R.id.etAltura);
        btnCalcular = (Button)this.findViewById(R.id.btnCalc);
        btnCalcular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(!editPeso.getText().toString().equals("") && !editAltura.getText().toString().equals("")){
            double peso = Double.parseDouble(editPeso.getText().toString().replace(",", "."));
            double altura = Double.parseDouble(editAltura.getText().toString().replace(",", "."));
            double resultImc = peso/(altura*altura);
            Intent intent = new Intent("resultado");
            intent.putExtra("resultImc", resultImc);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Informe valores válidos para peso e altura.", Toast.LENGTH_SHORT).show();
        }

    }
}



