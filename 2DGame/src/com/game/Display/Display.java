package com.game.Display;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Created by Daniel on 2016-02-17.
 */
    public class Display {
        private JFrame frame;
        private Canvas canvas;

        private String title;
        private int width, height;

        public Display(String title, int width, int height) {
            this.title = title;
            this.width = width;
            this.height = height;


            this.createDisplay();
        }

        public void createDisplay() {
            this.frame = new JFrame(this.title);
            this.frame.setSize(this.width, this.height);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setResizable(false);
            this.frame.setLocationRelativeTo((Component)null);
            this.frame.setVisible(true);

            canvas = new Canvas();
            canvas.setPreferredSize(new Dimension(width, height));
            canvas.setMaximumSize(new Dimension(width, height));
            canvas.setMinimumSize(new Dimension(width, height));

            frame.add(canvas);
            frame.pack();

        }

    public Canvas getCanvas(){
        return canvas;
    }
    }

