package builder.ex02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// HTML 파일을 이용하여 문서를 만드는 클래스
public class HTMLBuilder implements Builder{
    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        try{
            writer = new PrintWriter(new FileWriter(filename));
        }catch(IOException e){
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String string) {
        writer.println("<p>" + string + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>"+items[i]+"</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult(){
        return filename;
    }
}
