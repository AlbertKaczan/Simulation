import processing.core.PVector;

import java.io.Serializable;


public class AccelerationCalculation extends Thread {
    Planet[] planetsList;

    AccelerationCalculation( Planet [] planets){
        planetsList = planets;
    }
    @Override
    public void run() {
        while(true){
            for(int i =0; i < planetsList.length; i++) {
                for (int j = 0; j < planetsList.length; j++) {
                    if (i != j) {
                        PVector force = planetsList[j].attract(planetsList[i]);
                        planetsList[i].applyForce(force);
                    }
                }
                planetsList[i].update();
            }
            try{
                sleep(Main.getSettings().getSlider(Main.STRING).getValue(),0);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
