import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread! Data flowing via Piped Streams.";
            System.out.println("Writer: Writing data...");
            pos.write(message.getBytes());
            pos.close(); // Important: signal end of data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.println("Reader: Reading data...");
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) throws IOException {
        // Create pipe streams
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        // Start writer and reader threads
        WriterThread writer = new WriterThread(pos);
        ReaderThread reader = new ReaderThread(pis);

        writer.start();
        reader.start();
    }
}
