package com.snakegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;

    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 120;

    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;

    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    
    Rectangle[] obstacles;

   
    Rectangle playAgainButton = new Rectangle(200, 350, 200, 50);

    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!running) {
                    if (playAgainButton.contains(e.getX(), e.getY())) {
                        restartGame();
                    }
                }
            }
        });

        initObstacles();
        startGame();
    }

   
    public void initObstacles() {
        obstacles = new Rectangle[]{
            new Rectangle(200, 200, 50, 50),
            new Rectangle(350, 300, 50, 50)
        };
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void restartGame() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';

        for (int i = 0; i < bodyParts; i++) {
            x[i] = 100 - i * UNIT_SIZE;
            y[i] = 100;
        }

        newApple();
        running = true;
        timer.restart();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Draw obstacles
            g.setColor(Color.gray);
            for (Rectangle r : obstacles) {
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            // Draw snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            // Score
            g.setColor(Color.white);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            g.drawString("Score: " + applesEaten, 10, 30);

        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U': y[0] = y[0] - UNIT_SIZE; break;
            case 'D': y[0] = y[0] + UNIT_SIZE; break;
            case 'L': x[0] = x[0] - UNIT_SIZE; break;
            case 'R': x[0] = x[0] + UNIT_SIZE; break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    
    public void checkObstacleCollision() {
        Rectangle head = new Rectangle(x[0], y[0], UNIT_SIZE, UNIT_SIZE);

        for (Rectangle r : obstacles) {
            if (head.intersects(r)) {
                running = false;
            }
        }
    }

    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        if (x[0] < 0 || x[0] >= SCREEN_WIDTH || y[0] < 0 || y[0] >= SCREEN_HEIGHT) {
            running = false;
        }

        checkObstacleCollision();

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 60));
        g.drawString("Game Over !!", 150, 200);

        g.setFont(new Font("Ink Free", Font.BOLD, 30));
        g.setColor(Color.white);
        g.drawString("Score: " + applesEaten, 240, 260);

        // Play Again Button
        g.setColor(Color.white);
        g.fillRect(playAgainButton.x, playAgainButton.y,
                playAgainButton.width, playAgainButton.height);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Play Again",
                playAgainButton.x + 35, playAgainButton.y + 32);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') direction = 'L';
                    break;

                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') direction = 'R';
                    break;

                case KeyEvent.VK_UP:
                    if (direction != 'D') direction = 'U';
                    break;

                case KeyEvent.VK_DOWN:
                    if (direction != 'U') direction = 'D';
                    break;
            }
        }
    }
}
