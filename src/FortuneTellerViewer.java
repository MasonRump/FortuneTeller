import javax.swing.SwingUtilities;

public class FortuneTellerViewer {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame Frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}
