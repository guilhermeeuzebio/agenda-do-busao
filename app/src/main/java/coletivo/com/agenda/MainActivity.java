package coletivo.com.agenda;

import android.app.PendingIntent;
import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;

import WebService.Data;
import WebService.RetornoWSTempoReal;
import WebService.RetornoWSTempoRealConverter;
import WebService.WebServiceMarechal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText txtLinha;


    private Data[] dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RetornoWSTempoReal.class, new RetornoWSTempoRealConverter());
        Gson gson = gsonBuilder.create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(WebServiceMarechal.URL_WEBSERVICE_MARECHAL)
                .build();

        final WebServiceMarechal service = retrofit.create(WebServiceMarechal.class);

        final Call<RetornoWSTempoReal> request = service.getTempoReal();

        request.enqueue(new Callback<RetornoWSTempoReal>() {
            @Override
            public void onResponse(Call<RetornoWSTempoReal> call, Response<RetornoWSTempoReal> response) {
                dados = response.body().getData();
            }

            @Override
            public void onFailure(Call<RetornoWSTempoReal> call, Throwable t) {
                Log.d(Constants.PACKAGE_NAME, "falha ao recuperar webservice" + t.getLocalizedMessage());
                t.printStackTrace();
            }
        });

        txtLinha = (EditText) findViewById(R.id.txtLinha);

    }

        public void agenda(){
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2017,6,17,6,30);

            Calendar endTime = Calendar.getInstance();
            endTime.set(2017,6,17,6,30);

            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                    .putExtra(CalendarContract.Events.TITLE, "Linha 355.1")
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, "Parada de onibus")
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_FREE);
            startActivity(intent);

        }

        public void entrar(View view){
            setContentView(R.layout.pesquisa_linha);

        }

        public void agendar(View view){
            setContentView(R.layout.config_agenda);
        }

        public void calendario(View view){
            agenda();
        }

        public void pesquisar(View view) {   //esta parando o APP
            for (Data d : dados) {
                if (d!=null)
                    if (d.getDataHora().equals(txtLinha)) {
                  //  TextView horario = (TextView)findViewById(R.id.horarios);
                   // horario.setText(d.getDataHora());
                }
            }
        }

        public void mapa (View view){
            Intent it = new Intent(this,MapsActivity.class);
            startActivity(it);
        }


}

