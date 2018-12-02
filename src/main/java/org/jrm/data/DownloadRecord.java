package org.jrm.data;

import java.util.Date;

public class DownloadRecord
{
    private static DownloadRecord inst = null;
    private DownloadRecord () {}

    Date testStartTime, testEndTime;
    Long byteSize;
    Float downloadRate;

    public static DownloadRecord getInstance()
    {
        synchronized (DownloadRecord.class)
        {
            if (inst == null)
            {
                inst = new DownloadRecord();
            }
        }

        return inst;
    }

    public void setTestStartTime(Date testStartTime) {
        this.testStartTime = testStartTime;
    }

    public void setTestEndTime(Date testEndTime) {
        this.testEndTime = testEndTime;
    }

    public void setByteSize(Long byteSize) {
        this.byteSize = byteSize;
    }

    public void setDownloadRate(Float downloadRate) {
        this.downloadRate = downloadRate;
    }

    public Date getTestStartTime() {
        return testStartTime;
    }

    public Date getTestEndTime() {
        return testEndTime;
    }

    public Long getByteSize() {
        return byteSize;
    }

    public Float getDownloadRate() {
        return downloadRate;
    }
}
