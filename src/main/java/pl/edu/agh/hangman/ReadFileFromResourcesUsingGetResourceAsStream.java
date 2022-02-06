package pl.edu.agh.hangman;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ReadFileFromResourcesUsingGetResourceAsStream
{
    public String GetFullFilePath(String fileName) throws URISyntaxException {
            URL res = ReadFileFromResourcesUsingGetResourceAsStream.class.getClassLoader().getResource(fileName);
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            return  absolutePath;
        }

    public String getRandomLine(String fileLoc) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(fileLoc));
        ArrayList<String> lines = new ArrayList<String>();

        String line =null;
        while( (line = reader.readLine())!= null )
            lines.add(line);

        // Choose a random one from the list
        return lines.get(new Random().nextInt(lines.size()));
    }



    private InputStream getFileAsIOStream(final String fileName)
    {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private void printFileContent(InputStream is) throws IOException
    {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
        }
    }
}
