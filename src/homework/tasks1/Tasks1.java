package homework.tasks1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tasks1 {
    public static void main(String[] args) {
        StringBuilder report = new StringBuilder();

        File dirSrc = new File("C://Game", "scr");
        File dirRes = new File("C://Game", "res");
        File dirSavegames = new File("C://Game", "savegames");
        File dirTemp = new File("C://Game", "temp");
        dirSrc.mkdir();
        dirRes.mkdir();
        dirSavegames.mkdir();
        dirTemp.mkdir();

        File dirResAdd1 = new File(dirSrc, "main");
        File dirResAdd2 = new File(dirSrc, "test");
        if (dirResAdd1.mkdir()) {
            report.append("Directory name : " + dirResAdd1.getName()
                    + " Path : " + dirResAdd1.getPath()
                    + "\n");
        }
        if (dirResAdd2.mkdir()) {
            report.append("Directory name : " + dirResAdd2.getName()
                    + " Path : " + dirResAdd2.getPath()
                    + "\n");
        }

        File fileResMain = new File(dirResAdd1, "Main.java");
        File fileResUtils = new File(dirResAdd1, "Utils.java");
        try {
            if (fileResMain.createNewFile()) {
                report.append("File name : " + fileResMain.getName()
                        + " Path : " + fileResMain.getPath()
                        + "\n");
            }
            if (fileResUtils.createNewFile()) {
                report.append("File name : " + fileResUtils.getName()
                        + " Path : " + fileResUtils.getPath()
                        + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dirResDrawables = new File(dirRes, "drawables");
        File dirResVectors = new File(dirRes, "vectors");
        File dirResIcons = new File(dirRes, "icons");
        if (dirResDrawables.mkdir()) {
            report.append("Directory name : " + dirResDrawables.getName()
                    + " Path : " + dirResDrawables.getPath()
                    + "\n");
        }
        if (dirResVectors.mkdir()) {
            report.append("Directory name : " + dirResVectors.getName()
                    + " Path : " + dirResVectors.getPath()
                    + "\n");
        }
        if (dirResIcons.mkdir()) {
            report.append("Directory name : " + dirResIcons.getName()
                    + " Path : " + dirResIcons.getPath()
                    + "\n");
        }

        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            if (fileTemp.createNewFile()) {
                report.append("File name : " + fileTemp.getName()
                        + " Path : " + fileTemp.getPath()
                        + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

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
