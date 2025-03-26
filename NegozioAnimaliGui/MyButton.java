import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    private static final Color DEFAULT_BACKGROUND = new Color(240, 240, 240);
    private static final Color HOVER_BACKGROUND = new Color(220, 220, 220);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 16);

    public MyButton(String text) {
        super(text);
        setupButton();
    }

    private void setupButton() {
        setFont(BUTTON_FONT);
        setFocusPainted(false);
        setBackground(DEFAULT_BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // Hover effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(HOVER_BACKGROUND);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(DEFAULT_BACKGROUND);
            }
        });
    }
}