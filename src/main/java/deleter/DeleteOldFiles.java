package deleter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created on 12-Jun-17.
 */
public class DeleteOldFiles {
    static ArrayList<String> folders = new ArrayList<>();
    static long currentTime = System.currentTimeMillis();
    static int count = 0;
    static long space = 0;

    static {
        folders.add("C:\\Automation\\Screenshot");
        folders.add("C:\\Automation\\Tmp");
        folders.add("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Local\\Temp");
    }

    public static void main(String[] args) {
        for (String folder : folders) {
            deleteFiles(new File(folder));
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        FileDeleterStatistic newReport = new FileDeleterStatistic();
        newReport.setDate(dateFormat.format(new Date()));
        newReport.setFileCounter(count + ".");
        newReport.setFreeSpace(space / (1024 * 1024) + " Mb");

        System.out.println(newReport);

        new PostSender().sendPost(newReport);

        System.out.println("Deleted " + count + " files");
        System.out.println(space / (1024 * 1024) + " Mb");
    }

    private static void deleteFiles(File file) {
        if (file.isDirectory()) {
            if (file.listFiles() == null) {
                file.delete();
                return;
            }
            for (File f : file.listFiles()) {
                deleteFiles(f);
            }
        } else {
            long lastModified = currentTime - file.lastModified();
            if (lastModified > 1000 * 60 * 60 * 24 ) {
                long fileSize = file.length();
                boolean isDeleted = file.delete();
                System.out.println(file.getAbsoluteFile() + " - " + (isDeleted ? "deleted" : "not deleted"));
                if (isDeleted) {
                    count++;
                    space = space + fileSize;
                }
            }
        }
    }
}
