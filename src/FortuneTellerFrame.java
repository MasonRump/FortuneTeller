import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;
    private JButton readFortuneButton, quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private Random random;

    public FortuneTellerFrame() {
        super("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Screen size calcs
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);

        random = new Random();

        setLayout(new BorderLayout());

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        initializeFortunes();
    }

    private void createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("fortune.png");
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }

    private void createMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());

        fortuneArea = new JTextArea();
        fortuneArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        fortuneArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        add(middlePanel, BorderLayout.CENTER);
    }

    private void createBottomPanel() {
        JPanel bottomPanel = new JPanel();

        readFortuneButton = new JButton("Read Fortune");
        readFortuneButton.setFont(new Font("SanSerif", Font.BOLD, 24));
        readFortuneButton.addActionListener(e -> showRandomFortune());

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SanSerif", Font.BOLD, 24));
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void intitializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will discover a hidden talent for juggling.");
        fortunes.add("A surprise snack will brighten your day.");
        fortunes.add("Beware of low-flying pigeons.");
        fortunes.add("You will accidentally become a meme.");
        fortunes.add("A mysterious package will arrive at your door.");
        fortunes.add("You will find a forgotten $20 bill in your coat pocket.");
        fortunes.add("Your pet will reveal a secret life.");
        fortunes.add("You will invent a new dance move.");
        fortunes.add("You will get all green lights on your way home.");
        fortunes.add("You will master the art of doomscrolling.");
        fortunes.add("The cat distribution system will favor you today.");
        fortunes.add("You will get the baby the next time you eat a king cake.");
    }

    private void showRandomFortune() {
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);
        lastFortuneIndex = index;

        fortuneArea.append(fortunes.get(index) + "\n");
    }
}
