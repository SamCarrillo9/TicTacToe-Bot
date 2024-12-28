package OtherProjects.TicTacToeV5;

import java.awt.*;

class BoardCanvas {
    DrawingPanel boardType;
    Graphics pen;

    BoardCanvas(int size, int type){
        if (type == 1)
            setBlue(size);
        else
            setBrown(size);
    }
    void setBlue(int size){
        boardType = new DrawingPanel(size, size);
        pen = boardType.getGraphics();

        boardType.setBackground(new Color(3, 60, 79));

        int red = 90;
        int green = 120;
        int blue = 110;
        pen.setColor(new Color(red, green, blue));
        int b = 500;
        int c = 0;
        int d = 10;
        double colorAdd = 1.0;
        for (int a = 500; a>= 0; a -= d){
            pen.drawLine(a, 0, 500, b);
            b-=d;
            pen.drawLine(a, 0, 0, c);
            c+=d;
            pen.setColor( new Color((int)(red + colorAdd),(int)(green + colorAdd),(int)(blue + colorAdd)) );
            colorAdd+=1.8;
        }
        pen.setColor(new Color(red, green, blue));

        b = 0;
        c = 500;
        colorAdd = 1.0;
        for (int a = 500; a>= 0; a -= d){
            pen.drawLine(a, 500, 500, b);
            b+=d;
            pen.drawLine(a, 500, 0, c);
            c-=d;
            pen.setColor( new Color((int)(red + colorAdd),(int)(green + colorAdd),(int)(blue + colorAdd)) );
            colorAdd+=1.8;
        }
        //dark grid lines make it look 3d
        pen.setColor(new Color(102, 103, 103));
        pen.fillRect(159, 0, 4,500);
        pen.fillRect(322, 0, 4,500);
        pen.fillRect(0, 159, 500,4);
        pen.fillRect(0, 322, 500,4);
        //light grid lines
        pen.setColor(new Color(140, 141, 141));
        pen.fillRect(163, 0, 6,500);
        pen.fillRect(326, 0, 6,500);
        pen.fillRect(0, 163, 500,6);
        pen.fillRect(0, 326, 500,6);


        Color XsAndOsColor = new Color(255, 255, 255);
        pen.setColor(XsAndOsColor);

    }

    void setBrown(int size){
        boardType = new DrawingPanel(size, size);
        pen = boardType.getGraphics();

        boardType.setBackground(new Color(211, 180, 136));

        Color backgroundDots1 = new Color(190, 155, 124);

        int diameterLimit = 50;
        for (int yLimit = 0; yLimit <= 500; yLimit+=diameterLimit){
            for(int xLimit = 0; xLimit < 500; xLimit+=diameterLimit) {
                pen.setColor(backgroundDots1);
                int x = (int)(Math.random() * diameterLimit + 1);
                int y = (int)(Math.random() * diameterLimit + 1);
                int diameter = (int) (Math.random() * (diameterLimit * 0.8) + (diameterLimit * 0.6));
                pen.fillOval(xLimit + x - (diameter / 2), yLimit + y - (diameter / 2), diameter, diameter);

                pen.setColor(new Color(189, 167, 147));
                pen.drawOval(xLimit + x - (diameter / 2), yLimit + y - (diameter / 2), diameter, diameter);
            }
        }

        Color backgroundDots2 = new Color(199, 149, 99);

        for (int ylimit = 0; ylimit <= 500; ylimit+=diameterLimit){
            for(int xlimit = 0; xlimit < 500; xlimit+=diameterLimit) {
                pen.setColor(backgroundDots2);
                int x = (int)(Math.random() * diameterLimit + 1);
                int y = (int)(Math.random() * diameterLimit + 1);
                int diameter = (int) (Math.random() * (diameterLimit * 0.6) + (diameterLimit * 0.4));
                pen.fillOval(xlimit + x - (diameter / 2), ylimit + y - (diameter / 2), diameter, diameter);

                pen.setColor(new Color(201, 162, 123));
                pen.drawOval(xlimit + x - (diameter / 2), ylimit + y - (diameter / 2), diameter, diameter);
            }
        }
        Color lineBrown = new Color(82, 65, 48);

        pen.setColor(lineBrown);

        pen.fillRect(163, 0, 6,500);
        pen.fillRect(326, 0, 6,500);

        pen.fillRect(0, 163, 500,6);
        pen.fillRect(0, 326, 500,6);


        Color XsAndOsBlackBrown = new Color(18, 5, 7);
        pen.setColor(XsAndOsBlackBrown);

    }

}
