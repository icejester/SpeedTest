package org.jrm.data;

import java.util.Date;

public class DownloadRecord
{
    Date testStartTime, testEndTime;
    Long byteSize;
    Float downloadRate;

    public DownloadRecord (Date startDate, Date stopDate, Float rate)
    {
        testStartTime = startDate;
        testEndTime = stopDate;
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

    public Float getDownloadRate() {
        return downloadRate;
    }
}
