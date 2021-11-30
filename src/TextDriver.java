import java.io.*;

class TextDriver
{
    static public String ReadText(String path)
    {
        String source = "";
        String pathname = path;
        String line;
        source = new String();

        try {

            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            line = reader.readLine();

            while (line != null) {

                line += '\n';
                source += line;
                line = reader.readLine();
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

        return source;
    }

    static public void WriteText(String path, String text)
    {
        try(FileWriter writer = new FileWriter(path, false))
        {

            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}