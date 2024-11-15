import java.io.*;

class lowercase extends FilterOutputStream {
    public lowercase(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        if (b >= 'A' && b <= 'Z') {
            b = b + ('a' - 'A');
        }
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++) {
            write(b[i]);
        }
    }
}

public class Upper {
    public static void main(String[] args) {
        String input = "JAI SHREE MAHAKAALLLLL.";

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                lowercase lowercase = new lowercase(baos)) {

            lowercase.write(input.getBytes());
            String output = baos.toString();
            System.out.println("Original: " + input);
            System.out.println("Converted: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
