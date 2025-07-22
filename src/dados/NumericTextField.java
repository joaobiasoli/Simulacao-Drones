package dados;

import javax.swing.*;
import javax.swing.text.*;

public class NumericTextField extends JTextField {
    public NumericTextField(int columns) {
        super(columns);
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new NumericDocumentFilter());
    }

    private static class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("\\d*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("\\d*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}