package WebService;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rogerio on 6/15/17.
 */


public class RetornoWSTempoReal {

    @SerializedName("COLUMNS")
    private String[] Columns;

    @SerializedName("DATA")
    private Data[] data;

    public String[] getColumns() {
        return Columns;
    }

    public void setColumns(String[] columns) {
        Columns = columns;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}