package com.example.ejercicio3a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Atributos -> Variables

    //Atributos que representen cada elemento visual que diseñen
    //NOTA: Elemento visual que van a usar como codigo
    private TextView txtResultado;
    private Button btnInvertir;
    private EditText etNombre, etCelular;
    //Atributos de clase
    private String nombre;
    private int celular;

    //Metodos->Funciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        /*
        Para configurar al boton y decirle que este pendiente
        al evento click que se haga sobre el boton usamos un metodo
        del tipo SETTER...
        y en realidad ustedes quieren configurar un concepto llamado
        Listener -> algo que esta pendiente a que pase cierto esa
         */
        btnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        /* Definen el enlace de sus variable o atributos
         *  con sus componentes que han diseñado en pantalla
         *  Inicializando sus vistas -> referencia de un View a una variable*/
        etNombre = findViewById(R.id.etNombre);
        etCelular = findViewById(R.id.etCelular);
        txtResultado = findViewById(R.id.txtResultado);
        btnInvertir = findViewById(R.id.btnInvertir);
    }

    private void obtenerInformacionUsuario(){
        /*
        Para obtener la informacion que el usuario introduce en los
        campos de texto. Ustedes van a obtener esos valores del
        atributo TEXT que esta presente en el diseñador de ese componente.
        Y para obtener algo en POO con JAVA se usa su buen amigo GETTER.
        Obtener texto de EditText -> .getText()
        */
        nombre = etNombre.getText().toString();
        //Transformar una cadena en numero
        String celText = etCelular.getText().toString();
        celular = Integer.parseInt(celText);
    }

    private void invertirNumero(){
        int resto = 0, invertido = 0;
        while (this.celular>0){
            resto=this.celular%10;
            invertido = invertido * 10 + resto;
            this.celular = this.celular / 10;
        }
        txtResultado.setText("Valor invertido: "+invertido);
    }

    // 3 formas de usar el boton
    // Forma 2:

    @Override
    public void onClick(View view) {
        obtenerInformacionUsuario();
        invertirNumero();
    }
}