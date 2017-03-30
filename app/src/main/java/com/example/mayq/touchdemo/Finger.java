package com.example.mayq.touchdemo;

/**
 * Created by mayq on 2016/12/2.
 */

public class Finger {
        private int id;
        private float x;
        private float y;

        public Finger(int id, float x, float y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
}
