import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> carImages = new ArrayList<>();
    ArrayList<Point> carPoints = new ArrayList<>();

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y) {
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        BufferedImage volvoImage = null ;
        BufferedImage saabImage = null ;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            volvoImage = ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

            saabImage = ImageIO.read(
                    DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        carImages.add(volvoImage);
        carImages.add(saabImage);

        carPoints.add(new Point());
        carPoints.add(new Point());
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < carImages.size(); i++) {
            g.drawImage(carImages.get(i),
                    carPoints.get(i).x,
                    carPoints.get(i).y,
                    null);
        }
    }
}