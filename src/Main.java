import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JLayeredPane layeredPane = frame.getLayeredPane();

        CarSticker carSticker = new CarSticker();
        carSticker.setBounds(0, 0, 800, 800);
        layeredPane.add(carSticker);

        frame.setVisible(true);
    }
}

class CarSticker extends JPanel {
    private final double DEFAULT_HEIGHT = 1000;
    private final double DEFAULT_WIDTH = 1000;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) getComponentGraphics(g);
        setStyle(g2d);
        Area path = getBodyShape();
        g2d.setColor(new Color(232, 246, 65, 255));
        g2d.fill(path);

        setStyle(g2d);
        g2d.draw(path);

        Area area = new Area(new Ellipse2D.Double(getComponentWidth(173), getComponentHeight(551), getComponentWidth(170), getComponentHeight(170)));
        area.subtract(new Area(new Ellipse2D.Double(getComponentWidth(221), getComponentHeight(601), getComponentWidth(74), getComponentHeight(74))));
        g2d.fill(area);

        area = new Area(new Ellipse2D.Double(getComponentWidth(641), getComponentHeight(551), getComponentWidth(170), getComponentHeight(170)));
        area.subtract(new Area(new Ellipse2D.Double(getComponentWidth(689), getComponentHeight(601), getComponentWidth(74), getComponentHeight(74))));
        g2d.fill(area);
    }

    private Area getBodyShape() {
        Path2D path = new Path2D.Double();
        path.moveTo(getComponentWidth(58), getComponentHeight(560));
        path.curveTo(
                getComponentWidth(61), getComponentHeight(520),
                getComponentWidth(78), getComponentHeight(481),
                getComponentWidth(114), getComponentHeight(428)
        );
        path.curveTo(
                getComponentWidth(274), getComponentHeight(195),
                getComponentWidth(653), getComponentHeight(252),
                getComponentWidth(763), getComponentHeight(433)
        );
        path.curveTo(
                getComponentWidth(887), getComponentHeight(436),
                getComponentWidth(964), getComponentHeight(478),
                getComponentWidth(968), getComponentHeight(581)
        );
        path.curveTo(
                getComponentWidth(975), getComponentHeight(600),
                getComponentWidth(987), getComponentHeight(619),
                getComponentWidth(952), getComponentHeight(644)
        );
        path.lineTo(getComponentWidth(831), getComponentHeight(644));
        path.curveTo(
                getComponentWidth(820), getComponentHeight(488),
                getComponentWidth(613), getComponentHeight(512),
                getComponentWidth(622), getComponentHeight(653)
        );
        path.lineTo(getComponentWidth(362), getComponentHeight(653));
        path.curveTo(
                getComponentWidth(365), getComponentHeight(488),
                getComponentWidth(144), getComponentHeight(508),
                getComponentWidth(157), getComponentHeight(653)
        );
        path.lineTo(getComponentWidth(73), getComponentHeight(653));
        path.curveTo(
                getComponentWidth(42), getComponentHeight(636),
                getComponentWidth(32), getComponentHeight(614),
                getComponentWidth(34), getComponentHeight(587)
        );
        path.curveTo(
                getComponentWidth(41), getComponentHeight(578),
                getComponentWidth(48), getComponentHeight(569),
                getComponentWidth(58), getComponentHeight(560)
        );

        path.moveTo(getComponentWidth(439), getComponentHeight(479));
        path.lineTo(getComponentWidth(490), getComponentHeight(479));

        Area area = new Area(path);

        path = new Path2D.Double();
        path.moveTo(getComponentWidth(165), getComponentHeight(429));
        path.curveTo(
                getComponentWidth(230), getComponentHeight(350),
                getComponentWidth(309), getComponentHeight(328),
                getComponentWidth(390), getComponentHeight(314)
        );
        path.lineTo(getComponentWidth(390), getComponentHeight(429));
        path.lineTo(getComponentWidth(165), getComponentHeight(429));

        area.subtract(new Area(path));

        path = new Path2D.Double();
        path.moveTo(getComponentWidth(427), getComponentHeight(312));
        path.curveTo(
                getComponentWidth(586), getComponentHeight(316),
                getComponentWidth(651), getComponentHeight(370),
                getComponentWidth(701), getComponentHeight(432)
        );
        path.lineTo(getComponentWidth(427), getComponentHeight(432));
        path.lineTo(getComponentWidth(427), getComponentHeight(312));

        area.subtract(new Area(path));

        path = new Path2D.Double();
        path.moveTo(getComponentWidth(847), getComponentHeight(480));
        path.curveTo(
                getComponentWidth(890), getComponentHeight(472),
                getComponentWidth(918), getComponentHeight(491),
                getComponentWidth(934), getComponentHeight(530)
        );
        path.curveTo(
                getComponentWidth(881), getComponentHeight(537),
                getComponentWidth(858), getComponentHeight(515),
                getComponentWidth(847), getComponentHeight(480)
        );

        area.subtract(new Area(path));

        return area;
    }

    private void setStyle(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
    }

    private double getComponentWidth(double width) {
        return getWidth() * width / DEFAULT_WIDTH;
    }

    private double getComponentHeight(double height) {
        return getHeight() * height / DEFAULT_HEIGHT;
    }
}
