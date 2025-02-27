package builder.ex02;

public class TextBuilder extends Builder{
    private StringBuffer buffer = new StringBuffer();

    @Override
    void makeTitle(String title) {
        buffer.append("==============\n");
        buffer.append("⎾"+ title + "⏌");
        buffer.append("\n");
    }

    @Override
    void makeString(String string) {
        buffer.append("◆" + string + "\n");
        buffer.append("\n");
    }

    @Override
    void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append(" •" + items[i] + "\n");
            buffer.append("\n");
        }
    }

    @Override
    void close() {
        buffer.append("====================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
