package org.jrm.persistence;

import org.jrm.data.DownloadRecord;

import java.util.Date;

public interface Persistence
{
    void setRecord(Date testStartTime, Date testEndTime, Float downloadRate);
    DownloadRecord getRecord();
}
