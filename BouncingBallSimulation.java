import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallSimulation extends JPanel implements ActionListener {

    private int ballX = 100, ballY = 100;
    private int ballDiameter = 30;
    private int xVelocity = 2, yVelocity = 3;

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    private Timer timer;

    public BouncingBallSimulation() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        timer = new Timer(10, this); // 10 ms delay
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update position
        ballX += xVelocity;
        ballY += yVelocity;

        // Bounce on walls
        if (ballX <= 0 || ballX + ballDiameter >= WIDTH) {
            xVelocity *= -1;
        }

        if (ballY <= 0 || ballY + ballDiameter >= HEIGHT) {
            yVelocity *= -1;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball Simulation");
        BouncingBallSimulation simulation = new BouncingBallSimulation();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(simulation);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
