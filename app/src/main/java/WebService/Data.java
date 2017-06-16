package WebService;

/**
 * Created by rogerio on 6/15/17.
 */

public class Data {

    private String dataHora;
    private String ordem;
    private String linha;
    private double latitude;
    private double longitude;
    private int velocidade;


    public String getDataHora() {
        return dataHora;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }


    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}