package org.jrm.data;

import java.util.Date;

public class DownloadRecord
{
    Date testStartTime, testEndTime;
    Long byteSize;
    Integer downloadRate;

    public DownloadRecord(Long startMilli, Long stopMilli, Long mbSize, Integer rate)
    {
        testStartTime = new Date(startMilli);
        testEndTime = new Date(stopMilli);
        byteSize = mbSize;
        downloadRate = rate;
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

    public Integer getDownloadRate() {
        return downloadRate;
    }
}
