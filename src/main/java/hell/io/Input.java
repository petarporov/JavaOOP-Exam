package hell.io;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input implements InputReader{

    private BufferedReader reader;

    public Input() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
