package deleter;

import lombok.Data;

/**
 * Created by Sergiy.K on 11-Jul-17.
 */
@Data
public class FileDeleterStatistic{
    private String date;
    private String fileCounter;
    private String freeSpace;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileCounter() {
        return fileCounter;
    }

    public void setFileCounter(String fileCounter) {
        this.fileCounter = fileCounter;
    }

    public String getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(String freeSpace) {
        this.freeSpace = freeSpace;
    }

    @Override
    public String toString() {
        return "FileDeleterStatistic{" +
                "date='" + date + '\'' +
                ", fileCounter='" + fileCounter + '\'' +
                ", freeSpace='" + freeSpace + '\'' +
                '}';
    }
}
