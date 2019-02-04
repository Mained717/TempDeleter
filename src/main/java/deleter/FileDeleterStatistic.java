package deleter;


/**
 * Created by Sergiy.K on 11-Jul-17.
 */

public class FileDeleterStatistic {
    private String date;
    private String pcName;
    private String fileCounter;
    private String freeSpace;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
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
                ", pcName='" + pcName + '\'' +
                ", fileCounter='" + fileCounter + '\'' +
                ", freeSpace='" + freeSpace + '\'' +
                '}';
    }
}
