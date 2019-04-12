import processing.core.PVector;

import java.io.Serializable;
import java.util.ArrayList;

import static processing.core.PApplet.constrain;


public class Planet implements Serializable {
    int counter;

    PVector vel;
    PVector position;
    PVector acc;
    PVector gaccSum;

    float m;
    float r;
    float G = (float) 6.674 * 0.001f;
    float initmass;

    int a = (int) Main.processing.random(50, 200);
    int b = (int) Main.processing.random(50, 200);
    int c = (int) Main.processing.random(50, 200);

    ArrayList<PVector> orbit;

    Planet(PVector location, PVector velocity, PVector acceleration, float mass, float radius) {
        position = location;
        vel = velocity;
        acc = acceleration;
        gaccSum = new PVector(0, 0);
        m = mass;
        r = radius;
        orbit = new ArrayList<>();
    }

    Planet(PVector location, PVector velocity, PVector acceleration, float mass, float radius,int a, int b, int c) {
        position = location;
        vel = velocity;
        acc = acceleration;
        gaccSum = new PVector(0, 0);
        m = mass;
        r = radius;
        orbit = new ArrayList<>();
        this.a = a;
        this.b = b;
        this.c = c;
        initmass = mass;
    }

    void update() {

        vel.add(acc);

        position.add(vel);

        acc.mult(0);

        if (counter++ > r/2) {
            orbit.add(position.copy());
            counter = 0;
        }
        if (orbit.size() > 500) {
            orbit.remove(0);
        }
    }

    void applyForce(PVector force) {
        PVector f = PVector.div(force, m);
        acc.add(f);
    }

    PVector attract(Planet p) {
        PVector force = PVector.sub(position, p.position);

        float d = force.mag();
        d = constrain(d, r, 10000);

        force.normalize();

        float gForce = (G * m * p.m) / (d * d);

        force.mult(gForce);

        return force;
    }

    void display() {
        Main.processing.noStroke();
        Main.processing.fill(a, b, c);
        Main.processing.pushMatrix();
        Main.processing.translate(position.x, position.y, position.z);
        Main.processing.sphere(r);
        Main.processing.popMatrix();

        for (int i = 1; i < orbit.size(); i++) {
            if (orbit.size() > 2) {
                Main.processing.stroke(a, b, c);
                Main.processing.line(orbit.get(i).x, orbit.get(i).y, orbit.get(i).z, orbit.get(i - 1).x, orbit.get(i - 1).y, orbit.get(i - 1).z);
            }
        }
    }
}
