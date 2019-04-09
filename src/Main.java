import org.apache.commons.cli.*;
import processing.core.*;
import processing.opengl.*;
import peasy.*;
import peasy.org.apache.commons.math.geometry.*;
import java.util.Scanner;


public class Main extends PApplet {

    public static PApplet processing;

    public static void main(String[] args){
//        Options v = new Options();
//        Option  o = new Option("o","opcja");
//        v.addOption(o);
//        CommandLineParser parser = new DefaultParser();
//        CommandLine cmd = null;
//        try {
//            cmd = parser.parse(v,args);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        cmd.getOptionValue("o");






        PApplet.main("Main", args);}

    PeasyCam cam;


    int numberOfPlanets;

    Planet[] planets;

    float[] massList;


    PGraphics nextBackground;


    public void settings(){size(1000,1000,P3D);}

    public void setup(){
        processing = this;

        cam = new PeasyCam(this, 0, 0, 0, 5000);

        cam.setMaximumDistance(7000);



        numberOfPlanets = 7;
        planets = new Planet[numberOfPlanets];

        massList = new float[numberOfPlanets];
        massGenerator();

        float initAcc;
        initAcc = 0.3f;


        PVector loc0 = new PVector(1500,0,0);
        PVector loc1 = new PVector(0,0,1500);
        PVector loc2 = new PVector(-1500,0,0);
        PVector loc3 = new PVector(0,0,-1500);
        PVector loc4 = new PVector(0,1500,0);
        PVector loc5 = new PVector(0,-1500,0);


        PVector loc6 = new PVector(0,0,0);

        PVector vel0 = new PVector(0,0,-initAcc);
        PVector vel1 = new PVector(0,initAcc,0);
        PVector vel2 = new PVector(0,0,initAcc);
        PVector vel3 = new PVector(-initAcc,0,-initAcc);
        PVector vel4 = new PVector(-initAcc,0,-initAcc);
        PVector vel5 = new PVector(initAcc,0,initAcc);

        PVector vel6 = new PVector(0,0,0);

        PVector acc0 = new PVector(0,0,0);
        PVector acc1 = new PVector(0,0,0);
        PVector acc2 = new PVector(0,0,0);
        PVector acc3 = new PVector(0,0,0);
        PVector acc4 = new PVector(0,0,0);
        PVector acc5 = new PVector(0,0,0);

        PVector acc6 = new PVector(0,0,0);


        planets[0] = new Planet(loc0,vel0,acc0,massList[0],map(massList[0],100,1000,20,70));
        planets[1] = new Planet(loc1,vel1,acc1,massList[1],map(massList[1],100,1000,20,70));
        planets[2] = new Planet(loc2,vel2,acc2,massList[2],map(massList[2],100,1000,20,70));
        planets[3] = new Planet(loc3,vel3,acc3,massList[3],map(massList[3],100,1000,20,70));
        planets[4] = new Planet(loc4,vel4,acc4,massList[4],map(massList[4],100,1000,20,70));
        planets[5] = new Planet(loc5,vel5,acc5,massList[5],map(massList[5],100,1000,20,70));

        planets[6] = new Planet(loc6,vel6,acc6,50000,25);


        //      Manual setting for Planet Object values
//        for(int i = 0; i < planets.length; i ++){
//            PVector location = new PVector();
//            inputData(location);
//
//            PVector velocity = new PVector();
//            inputData(velocity);
//
//            PVector acceleration = new PVector();
//            inputData(acceleration);
//            String massname = "mass";
//            float mass = inputData(massname);
//            String radiusname = "radius";
//            float radius = inputData(radiusname);
//            planets[i] = new Planet(location,velocity,acceleration,mass,radius);
//        }

        nextBackground = getBackgroundImage(this);

        AccelerationCalculation ac = new AccelerationCalculation(planets);

        ac.start();




        frameRate(60);

    }

    public void draw(){
        background(nextBackground);

        ambientLight(255,255,255);

        for(int i = 0 ; i < planets.length; i++){
            planets[i].display();
        }


    }



//    public void keyPressed() {
//        for(int camSwitch = 0;camSwitch < planets.length; camSwitch ++){
//            if(camSwitch == planets.length){camSwitch = 0;}
//            cam.lookAt(planets[camSwitch].position.x,planets[camSwitch].position.y,planets[camSwitch].position.z);
//        }
//
//
//
//    }
//




//    PVector  inputData (PVector p) {
//        float x;
//        float y;
//        float z;
//        for(int j = 0; j < 3; j++){
//            Scanner scan = new Scanner(System.in);
//            switch (j){
//                case 0:
//                    System.out.println("Please provide x value for: ");
//                    x = scan.nextInt();
//                    p.x = x;
//                    break;
//                case 1:
//                    System.out.println("Please provide y value for: ");
//                    y = scan.nextInt();
//                    p.y = y;
//                    break;
//                case 2:
//                    System.out.println("Please provide z value for: ");
//                    z = scan.nextInt();
//                    p.z = z;
//                    break;
//            }
//        }
//        return p;
//    }

//    float inputData(String c){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please provide " + c + ":");
//        float s = scan.nextInt();
//        return s;
//    }

    private PGraphics getBackgroundImage(PApplet thisApplet){
        PGraphics back = thisApplet.createGraphics(width,height);
        back.beginDraw();
        back.background(0);

        for (int i =0; i < 1000; i++){
            back.fill(255);
            int posX = (int) (Math.random() * back.width);
            int posY = (int) (Math.random() * back.height);
            back.ellipse(posX,posY,2,2);
        }
        back.endDraw();

        return back;
    }

    private float massGenerator(){
        float randomMass = 0;
        for(int i = 0; i < numberOfPlanets; i ++){
            randomMass = random(100,1000);
            massList[i] = randomMass;
        }
        return randomMass;
    }





}
