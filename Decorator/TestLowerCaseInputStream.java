import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

/* UML: ConcreteDecorator - modifies behavior of the wrapped InputStream */
class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}

/* UML: Client - tests the LowerCaseInputStream decorator */
public class TestLowerCaseInputStream {
    
    public static void main(String[] args) {
        String text = "Hello, THIS is A Test!";
        
        // UML: Concrete Component - raw input source for data
        InputStream baseStream = new ByteArrayInputStream(text.getBytes());

        // UML: Applying ConcreteDecorator (LowerCaseInputStream) to modify behavior
        try (InputStream in = new LowerCaseInputStream(baseStream)) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
