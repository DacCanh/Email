package beatriz.daniel.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Definição da ação do click do botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtendo dados digitados pelo usuario
                EditText etEmail = (EditText) findViewById(R. id.etEmail); //obtencao do campo EditText de id etEmail
                String email = etEmail.getText().toString(); //obter o email digitado pelo usuário

                EditText etAssunto = (EditText) findViewById(R. id.etAssunto); //obtencao do campo EditText de id etAssunto
                String assunto = etAssunto.getText().toString(); //obter o assunto digitado pelo usuário

                EditText etTexto = (EditText) findViewById(R. id.etTexto); //obtencao do campo EditText de id etTexto
                String texto = etTexto.getText().toString(); //obter o texto digitado pelo usuário

                Intent i = new Intent(Intent.ACTION_SENDTO); //indicação da processo que faz o Android procurar as apps intaladas capazes de resolver a ação "ACTION SENDTO"

                i.setData(Uri.parse("mailto:")); //definindo o interesse somente em apps capazes de resolver a URI "mailto". URI = indicar quais apps trabalham com envio e recebiment de email

                String[] emails = new String[] {email}; //preenchendo o Intent com os dados que devem ser enviados para a app externa e que, posteriormente, enviará para o email
                i.putExtra(Intent.EXTRA_EMAIL, emails); //lista de nomes(strings) correspondente ao email de cada destinatário
                i.putExtra(Intent.EXTRA_SUBJECT, assunto); //campo de assunto
                i.putExtra(Intent.EXTRA_TEXT, texto); //corpo de texto do email

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP")); //execução da Intent. Intent.createChooser = comando que dá a opção ao usuário de escolher as apps para enviar uma mensagem de email
                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show();//mensagem que aparecerá caso não há uma app capaz de enviar uma mensagem de email.
                }




            }
        });

    }
}