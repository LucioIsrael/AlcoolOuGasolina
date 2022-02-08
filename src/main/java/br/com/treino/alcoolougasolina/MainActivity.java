package br.com.treino.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView text_Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool   = findViewById(R.id.precoAlcool);
        editPrecoGasolina = findViewById(R.id.precoGasolina);
        text_Resultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean campoValidado = this.validarCampos(precoAlcool, precoGasolina);
        if (campoValidado) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool/valorGasolina;

            if (resultado >= 0.7){
                text_Resultado.setText("Melhor utilizar gasolina");
            } else {
                text_Resultado.setText("Melhor utilizar álcool");
            }


        } else {
            text_Resultado.setText("Preencha todos os campos");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        Boolean campoValidado = true;

        if(pAlcool == null || pAlcool.equals("")){
            campoValidado = false;
        } else if(pGasolina == null || pGasolina.equals("")){
            campoValidado = false;
        }

        return campoValidado;

    }

}