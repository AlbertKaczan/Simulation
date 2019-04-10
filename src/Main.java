import org.apache.commons.cli.*;
import processing.core.*;
import processing.opengl.*;
import peasy.*;
import peasy.org.apache.commons.math.geometry.*;

import java.beans.Expression;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Settings;

public class Main extends PApplet {
    public static PApplet processing;

    static  Settings settings = new Settings();
    public static final String STRING = "TIME";

    PeasyCam cam;

    Storage values;

    public static int numberOfPlanets;
    int numberOfHoles;

    Planet[] terazMa;

    Planet[] planets;

    float[] massList;

    PVector[] locations;

    PVector[] velocities;

    PVector[] accelerations;


    PGraphics nextBackground;

    public static void main(String[] args) {
        PApplet.main("Main", args);

        settings = new Settings();
        settings.addSlider(1, 70, 25, STRING);

        settings.createWindow();
        settings.setVisible(true);
    }

    public void settings() {
        //size(1000,1000,P3D);}
        fullScreen(P3D);
    }

    public void setup(){
        processing = this;

        cam = new PeasyCam(this, 0, 0, 0, 5000);

        cam.setMaximumDistance(7000);

        values = new Storage();

        numberOfPlanets = 20;
        numberOfHoles = 1;
        planets = new Planet[numberOfPlanets];



        massList = new float[numberOfPlanets];
        massGenerator();

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
            PVector acceleration = new PVector(random(-0.15f, 0.15f), random(-0.15f, 0.15f), random(-0.15f, 0.15f));
            accelerations[i] = acceleration;
        }

        PVector hole = new PVector();
        for(int i = 0; i < it; i++) {
            planets[i] = new Planet(locations[i],velocities[i],accelerations[i],massList[i],map(massList[i],100,500,20,40));
        }

        planets[planets.length - numberOfHoles] = new Planet(new PVector(0, 0, 0),new PVector(0,0,0),hole,25000,25);
        //planets[planets.length - numberOfHoles + 1] = new Planet(new PVector(-width, 0, 0),hole,hole,70000,25);
//        PVector loc0 = new PVector(1500,0,0);
//        PVector loc1 = new PVector(0,0,1500);
//        PVector loc2 = new PVector(-1500,0,0);
//        PVector loc3 = new PVector(0,0,-1500);
//        PVector loc4 = new PVector(0,1500,0);
//        PVector loc5 = new PVector(0,-1500,0);
//
//
//        PVector loc6 = new PVector(0,0,0);
//
//        PVector vel0 = new PVector(0,0,-initAcc);
//        PVector vel1 = new PVector(0,initAcc,0);
//        PVector vel2 = new PVector(0,0,initAcc);
//        PVector vel3 = new PVector(-initAcc,0,-initAcc);
//        PVector vel4 = new PVector(-initAcc,0,-initAcc);
//        PVector vel5 = new PVector(initAcc,0,initAcc);
//
//        PVector vel6 = new PVector(0,0,0);
//
//        PVector acc0 = new PVector(0,0,0);
//        PVector acc1 = new PVector(0,0,0);
//        PVector acc2 = new PVector(0,0,0);
//        PVector acc3 = new PVector(0,0,0);
//        PVector acc4 = new PVector(0,0,0);
//        PVector acc5 = new PVector(0,0,0);
//
//        PVector acc6 = new PVector(0,0,0);
//
//
//        planets[0] = new Planet(loc0,vel0,acc0,massList[0],map(massList[0],100,1000,20,70));
//        planets[1] = new Planet(loc1,vel1,acc1,massList[1],map(massList[1],100,1000,20,70));
//        planets[2] = new Planet(loc2,vel2,acc2,massList[2],map(massList[2],100,1000,20,70));
//        planets[3] = new Planet(loc3,vel3,acc3,massList[3],map(massList[3],100,1000,20,70));
//        planets[4] = new Planet(loc4,vel4,acc4,massList[4],map(massList[4],100,1000,20,70));
//        planets[5] = new Planet(loc5,vel5,acc5,massList[5],map(massList[5],100,1000,20,70));

//        planets[6] = new Planet(loc6,vel6,acc6,50000,25);

            //planets[planets.length - numberOfHoles] = new Planet(new PVector(width/2, 0, 0),new PVector(0,0,-1f),hole,50000,25);
            //planets[planets.length - numberOfHoles + 1] = new Planet(new PVector(-width/2, 0, 0),hole,hole,100000,25);

        terazMa = planets;

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
            randomMass = random(100,500);
            massList[i] = randomMass;
        }
        return randomMass;
    }

    public static Settings getSettings(){
        return settings;
    }

    public void keyPressed() {
        if(key == 's') {
            values.saveConfig(terazMa);
        }
        super.keyPressed();
    }

}
