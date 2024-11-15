import java.io.*;

class LowerCaseInputStream extends FilterInputStream {
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c)); // Convert uppercase to lowercase
    }
}

public class Upl {
    public static void main(String[] args) {
        try {
            System.out.println("Enter text: ");
            InputStream in = new LowerCaseInputStream(System.in); // Wrapping System.in for user input
            int c;
            while ((c = in.read()) != -1 && c != '\n') { // Read until new line
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
