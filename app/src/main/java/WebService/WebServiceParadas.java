package WebService;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 16/06/17.
 */

public interface WebServiceParadas {

    public static final String URL_WEBSERVICE_MARECHAL = "http://www.sistemas.dftrans.df.gov.br/horarios/src/mapas/";

    @GET("getParadas")
    public Call<RetornoWSTempoReal> getTempoReal();

}
