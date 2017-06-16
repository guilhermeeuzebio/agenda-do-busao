package calculoDistancia;

/**
 * Created by ruan on 16/06/17.
 */

public class ConversoDistancia {


    public static double distance(double latitude1, double latitude2, double longetude1, double longetude2) {

        final int R = 6371; // raio da terra

        double latDistance = Math.toRadians(latitude2 - latitude1); // convertendo para radianos

        double lonDistance = Math.toRadians(longetude2 - longetude1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)  //calculo da distancia entre dois pontos
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // convertendo para Km

        return Math.sqrt(distance);
    }

}
