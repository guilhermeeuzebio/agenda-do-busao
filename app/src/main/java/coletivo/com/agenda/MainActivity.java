package coletivo.com.agenda;

import android.app.PendingIntent;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        setContentView(R.layout.activity_maps);


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
        public void pesquisar(View view) {
            for (Data d : dados) {
                if (d.equals(txtLinha)) {

                }
            }
        }
}

