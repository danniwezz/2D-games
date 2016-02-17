package com.game;

import com.game.Display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Daniel on 2016-02-17.
 */
public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private boolean running = false;
    private Thread thread;



    public Game(String title, int width, int height){
        this.height = height;
        this.width = width;
        this.title = title;
    }

    private void init(){
        display = new Display(title, width, height);
    }
    private void tick(){

    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //draw here
        g.fillRect(0, 0, width, height);

        //end drawing
        bs.show();
        g.dispose();
    }
    public void run(){

        init();

        while (running) {
            tick();
            render();
        }

        stop();

    }
    public synchronized void start(){
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
