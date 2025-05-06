import java.io.*;

public class Funciones {
    void createFolder(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    void createFile(String path, String fileName, String content) throws IOException {
        File file = new File(path, fileName);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
    }

    String[] showListFiles(String path) {
        File folder = new File(path);
        String[] pathContent = folder.list();
        return pathContent;
    }

    String showFile(String path, String fileName) throws IOException {
        File file = new File(path, fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        StringBuilder line = new StringBuilder();

        line.append(br.readLine());

        while (line != null) {
            line.append(br.readLine());
        }

        return line.toString();
    }

    boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path, fileName);
        FileWriter fw = new FileReader(file);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bw.write(newContent);
        bw.close();
    }
}
