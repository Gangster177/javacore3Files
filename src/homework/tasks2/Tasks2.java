package homework.tasks2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Tasks2 {
    public static void main(String[] args) {
        GameProgress gp1 = new GameProgress(100, 70, 32, 143.52);
        GameProgress gp2 = new GameProgress(78, 83, 15, 92.64);
        GameProgress gp3 = new GameProgress(84, 96, 5, 36.96);
        saveProgress("C:/Game/savegames/save1.dat", gp1);
        saveProgress("C:/Game/savegames/save2.dat", gp2);
        saveProgress("C:/Game/savegames/save3.dat", gp3);
        ArrayList<String> nameSP = new ArrayList<>();
        Collections.addAll(nameSP, "save1.dat", "save2.dat", "save3.dat");
        zipFiles("C:/Game/savegames", nameSP);
        cleanFile(nameSP);

    }

    public static void saveProgress(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String path, ArrayList<String> fileToZip) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path + "/zip.zip"))) {
            for (String name : fileToZip) {
                try (FileInputStream fis = new FileInputStream(path + "/" + name)) {
                    ZipEntry entry = new ZipEntry(name);
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void cleanFile(ArrayList<String> nameSP) {
        File delete;
        for (String name : nameSP) {
            delete = new File("C:/Game/savegames/" + name);
            delete.delete();
        }
    }
}
