package geometry;

public class TextRectangle extends Rectangle {
    private String text;

    public TextRectangle(String text, Point topLeft, int width, int height) {
        super(topLeft, width, height);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
