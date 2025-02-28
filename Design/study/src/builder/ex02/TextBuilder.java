package builder.ex02;

// 텍스트(일반 문자열)을 이용하여 문서를 만드는 클래스
public class TextBuilder implements Builder{
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("==============\n");
        buffer.append("⎾"+ title + "⏌");
        buffer.append("\n");
    }

    @Override
    public void makeString(String string) {
        buffer.append("◆" + string + "\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append(" •" + items[i] + "\n");
            buffer.append("\n");
        }
    }

    @Override
    public void close() {
        buffer.append("====================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
