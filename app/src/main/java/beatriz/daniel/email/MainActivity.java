package beatriz.daniel.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnEnviar = (Button) findViewById(R. id. btnEnviar);
        //Definição da ação do click do botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v){
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}