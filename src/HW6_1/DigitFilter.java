package HW6_1;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DigitFilter extends DocumentFilter {
    private static final String DIGITS = "\\d+";
    private static final String Dot = "\\.";
    private static final String DDD = "\\d+\\.\\d+";
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException, BadLocationException {

        if (string.matches(DIGITS) || string.matches(Dot) || string.matches(DDD)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
        if (string.matches(DIGITS) || string.matches(Dot) || string.matches(DDD)) {
            super.replace(fb, offset, length, string, attrs);
        }
    }
}
