import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public Main() {
        setTitle("Suffix Array Program");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        JLabel inputLabel = new JLabel("Input String:");
        inputTextArea = new JTextArea(3, 20);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        // Create output panel
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        JLabel outputLabel = new JLabel("Suffix Array:");
        outputTextArea = new JTextArea(10, 20);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Suffix Array");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSuffixArray();
            }
        });
        buttonPanel.add(generateButton);

        // Add panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(outputPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void generateSuffixArray() {
        String input = inputTextArea.getText().trim();
        if (!input.isEmpty() && !input.contains(" ")) {
            // Generate suffix array
            String[] suffixes = new String[input.length()];
            for (int i = 0; i < input.length(); i++) {
                suffixes[i] = input.substring(i);
            }
            Arrays.sort(suffixes);

            // Display suffix array
            StringBuilder result = new StringBuilder();
            for (String suffix : suffixes) {
                result.append(suffix).append('\n');
            }
            outputTextArea.setText(result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Input cannot contain spaces");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
