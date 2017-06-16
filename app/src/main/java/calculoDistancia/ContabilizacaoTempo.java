package calculoDistancia;

/**
 * Created by ruan on 16/06/17.
 */

public class ContabilizacaoTempo {

     private double tempoEspera;
     private double distancia;
     private double velocidade;

     public double getTempoEspera() {
          return tempoEspera;
     }

     public void setTempoEspera(double tempoEspera) {
          this.tempoEspera = tempoEspera;
     }

     public double getDistancia() {
          return distancia;
     }

     public void setDistancia(double distancia) {
          this.distancia = distancia;
     }

     public double getVelocidade() {
          return velocidade;
     }

     public void setVelocidade(double velocidade) {
          this.velocidade = velocidade;
     }

     public double converte(){
          setTempoEspera(getDistancia() / getVelocidade());
          return getTempoEspera();
     }

}
