package homework.tasks1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Tasks1new {
    public static void main(String[] args) {
        StringBuilder report = new StringBuilder();

        ArrayList<File> file = new ArrayList<>();
        Collections.addAll(file,
                new File("C:/Game", "scr"),
                new File("C:/Game", "res"),
                new File("C:/Game", "savegames"),
                new File("C:/Game", "temp"),
                new File("C:/Game/scr", "main"),
                new File("C:/Game/scr", "test"),
                new File("C:/Game/res", "drawables"),
                new File("C:/Game/res", "vectors"),
                new File("C:/Game/res", "icons")
        );
        for (File f : file) {
            if (f.mkdir()) {
                report.append("Directory name : " + f.getName()
                        + " Path : " + f.getPath()
                        + "\n");
            }
        }
        Collections.addAll(file,
                new File("C:/Game/scr/main", "Main.java"),
                new File("C:/Game/scr/main", "Utils.java"),
                new File("C:/Game/temp", "temp.txt")
        );
        for (File f : file) {
            try {
                if (f.createNewFile()) {
                    report.append("File name : " + f.getName()
                            + " Path : " + f.getPath()
                            + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        File fileTemp = new File("C:/Game/temp/temp.txt");
        try (FileOutputStream fos = new FileOutputStream(fileTemp)) {
            byte[] bytes = report.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileInputStream fin = new FileInputStream(fileTemp)) {
            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

