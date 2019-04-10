import peasy.PeasyCam;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;
import util.Settings;


public class Main extends PApplet {
    public static PApplet processing;

    static Settings settings = new Settings();

    public static final String KURWO_STRING = "TIME KURWO";

    PeasyCam cam;


    int numberOfPlanets, numberOfHoles;

    Planet[] planets;

    float[] massList;

    PImage nextBackground;
    PImage veryBiImg;

    PVector[] locations;

    PVector[] velocities;

    PVector[] accelerations;



    public static void main(String[] args) {
        PApplet.main("Main", args);

        settings = new Settings();
        settings.addSlider(1, 500, 5, KURWO_STRING);

        settings.createWindow();
        settings.setVisible(true);
    }

    public void settings() {
        //size(1000,1000, P3D);
        fullScreen(P3D);
    }

    public void setup(){

        Planet.setDrawTail(false);

        processing = this;

        cam = new PeasyCam(this, 0, 0, 0, 5000);

        cam.setMaximumDistance(10000);



        numberOfPlanets = 50;
        numberOfHoles = 2;
        planets = new Planet[numberOfPlanets];

        massList = new float[numberOfPlanets];
        massGenerator();



        float initAcc;
        initAcc = 0.3f;

        locations = new PVector[numberOfPlanets];
        velocities = new PVector[numberOfPlanets];
        accelerations = new PVector[numberOfPlanets];

        int it = numberOfPlanets - numberOfHoles;
        for(int i = 0; i < it; i++) {
            PVector location = new PVector(random(-width/2,width/2),random(-height/2,height/2),random(-width/2,width/2));
            locations[i] = location;

        }

        for(int i = 0; i < it; i++) {
            PVector velocity = new PVector(random(-0.5f,0.5f),random(-0.5f,0.5f),random(-0.5f,0.5f));
            velocities[i] = velocity;

        }

        for(int i = 0; i < it; i++) {
            PVector acceleration = new PVector(random(-0.15f,0.15f),random(-0.15f,0.15f),random(-0.15f,0.15f));
            accelerations[i] = acceleration;

        }
//        PVector loc0 = new PVector(1500,0,0);
//        PVector loc1 = new PVector(0,0,1500);
//        PVector loc2 = new PVector(-1500,0,0);
//        PVector loc3 = new PVector(0,0,-1500);
//        PVector loc4 = new PVector(0,1500,0);
//        PVector loc5 = new PVector(0,-1500,0);
//
//
//       PVector loc6 = new PVector(0,0,0);
//
//        PVector vel0 = new PVector(0,0,-initAcc);
//        PVector vel1 = new PVector(0,initAcc,0);
//        PVector vel2 = new PVector(0,0,initAcc);
//        PVector vel3 = new PVector(-initAcc,0,-initAcc);
//        PVector vel4 = new PVector(-initAcc,0,-initAcc);
//        PVector vel5 = new PVector(initAcc,0,initAcc);
//
//       PVector vel6 = new PVector(0,0,0);
//
//        PVector acc0 = new PVector(0,0,0);
//        PVector acc1 = new PVector(0,0,0.2f);
//        PVector acc2 = new PVector(0,0,0);
//        PVector acc3 = new PVector(0,0,0);
//        PVector acc4 = new PVector(0.4f,0,0);
//        PVector acc5 = new PVector(0,0,0);
//
//       PVector acc6 = new PVector(0,0,0);

        PVector hole = new PVector();


        for(int i = 0; i < it; i++) {
            planets[i] = new Planet(locations[i],velocities[i],accelerations[i],massList[i],map(massList[i],100,1000,20,70));
        }

//        planets[0] = new Planet(locations[],vel0,acc0,massList[0],map(massList[0],100,1000,20,70));
//        planets[1] = new Planet(loc1,vel1,acc1,massList[1],map(massList[1],100,1000,20,70));
//        planets[2] = new Planet(loc2,vel2,acc2,massList[2],map(massList[2],100,1000,20,70));
//        planets[3] = new Planet(loc3,vel3,acc3,massList[3],map(massList[3],100,1000,20,70));
//        planets[4] = new Planet(loc4,vel4,acc4,massList[4],map(massList[4],100,1000,20,70));
//        planets[5] = new Planet(loc5,vel5,acc5,massList[5],map(massList[5],100,1000,20,70));

//        planets[6] = new Planet(loc6,vel6,acc6,50000,25);
        planets[planets.length - numberOfHoles] = new Planet(new PVector(width/2, 0, 0),new PVector(0,0,-1f),hole,50000,25);
        planets[planets.length - numberOfHoles + 1] = new Planet(new PVector(-width/2, 0, 0),hole,hole,100000,25);
        nextBackground = getVeriBiBackgroundImage();
        veryBiImg = getVeriBiBackgroundImage();

        AccelerationCalculation ac = new AccelerationCalculation(planets);

        ac.start();




        frameRate(60);

    }

    public void draw(){
//        background(getVeriBiBackgroundImage(cam.getRotations()));

        float[] losRotationes = cam.getRotations();
        int xPos = (int) map(losRotationes[0], -PI, PI, 0, veryBiImg.width);
        int yPos = (int) map(losRotationes[1], -PI, PI, 0, veryBiImg.height);

        //pushMatrix();

//        translate(losRotationes[0], losRotationes[1], losRotationes[2]);
        //PImage image = new PImage;
        //image = (veryBiImg, 0, 0, width, height, xPos, yPos, width, height);



        //popMatrix();
        ambientLight(255,255,255);

        for (Planet planet : planets)
            planet.display();

       // float[] arr = cam.getRotations();
//        System.out.println(arr[0] + " : " + arr[1] + " : " + arr[2]);
    }


    private PGraphics getVeriBiBackgroundImage(){
        PGraphics back = processing.createGraphics(width*4,height*4);
        back.beginDraw();
        back.background(0);

        for (int i =0; i < 10000; i++){
            back.fill(255);
            int posX = (int) (Math.random() * back.width);
            int posY = (int) (Math.random() * back.height);
            back.ellipse(posX,posY,2,2);
        }
        back.endDraw();

        return back;


    }

//    private PImage getBackgroundImage(float[] losRotationes) {
////        PGraphics back = processing.createGraphics(width,height);
//        PImage back = new PImage(width, height);
//
////        back.beginDraw();
//
//        int xPos = (int) map(losRotationes[0], -PI, PI, 0, veryBiImg.width);
//        int yPos = (int) map(losRotationes[1], -PI, PI, 0, veryBiImg.height);
//
//        back.loadPixels();
//        veryBiImg.loadPixels();
//        for (int y = 0; y < back.height; y++) {
//            for(int x = 0; x < back.width; x++) {
//                int pos = (y * back.width) + x;
//                int xPosNewXd = xPos + x,
//                    yPosNewXd = yPos;
//                //xPosNewXd *
//                int posBi = (yPosNewXd * veryBiImg.width) + xPos;
//                //int value = veryBiImg.pixels[]
//                back.pixels[pos] = veryBiImg.pixels[posBi];
//            }
//            yPos++;
//        }
//
//
//
//        back.updatePixels();
////        veryBiImg.updatePixels();
////        back.endDraw();
//
//        return back;
//    }

    private float massGenerator(){
        float randomMass = 0;
        for(int i = 0; i < numberOfPlanets; i ++){
            randomMass = random(100,1000);
            massList[i] = randomMass;
        }
        return randomMass;
    }

    public static Settings getSettings() {
        return settings;
    }
}
