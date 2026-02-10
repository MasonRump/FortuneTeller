import javax.swing.SwingUtilities;

public class FortuneTellerViewer {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
