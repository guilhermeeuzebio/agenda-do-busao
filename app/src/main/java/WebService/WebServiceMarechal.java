package WebService;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rogerio on 6/15/17.
 */

public interface WebServiceMarechal {

    public static final String URL_WEBSERVICE_MARECHAL = "http://www.geodftrans.dftrans.df.gov.br:8080/";


    @GET("PosicaoGeoService//get-tempo-real")
    public Call<RetornoWSTempoReal> getTempoReal();



}
