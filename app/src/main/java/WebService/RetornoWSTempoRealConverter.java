package WebService;

import android.util.Log;

import coletivo.com.agenda.Constants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import coletivo.com.agenda.Constants;

/**
 * Created by rogerio on 6/15/17.
 */

public class RetornoWSTempoRealConverter implements JsonDeserializer<RetornoWSTempoReal> {
    @Override
    public RetornoWSTempoReal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        RetornoWSTempoReal retorno = new RetornoWSTempoReal();

        final JsonObject object = json.getAsJsonObject();

        final JsonArray columnsAsJson = object.getAsJsonArray("COLUMNS");
        String [] columns = new String[columnsAsJson.size()];
        for(int i=0; i<columnsAsJson.size();i++){
            columns[i]=columnsAsJson.get(i).getAsString();
        }

        retorno.setColumns(columns);


        final JsonArray dataAsJson = object.getAsJsonArray("DATA");
        Data[] data = new Data[dataAsJson.size()];

        for(int i=0; i < dataAsJson.size();i++){
            try{
                JsonArray rawData = dataAsJson.get(i).getAsJsonArray();
                Data singleData = new Data();
                singleData.setDataHora(rawData.get(0).getAsString());
                singleData.setOrdem(rawData.get(1).getAsString());
                singleData.setLinha(rawData.get(2).getAsString());
                singleData.setLatitude(rawData.get(3).getAsDouble());
                singleData.setLongitude(rawData.get(4).getAsDouble());
                singleData.setVelocidade(rawData.get(5).getAsInt());
                data[i]=singleData;
            }catch(Exception e){
                Log.e(Constants.PACKAGE_NAME,"Erro no parser linha do registro : "+i);
                Log.e(Constants.PACKAGE_NAME,"Mensagem do erro de parser : "+e.getMessage());
                continue;
            }

        }

        retorno.setData(data);
        return retorno;
    }
}
