package org.jrm.persistence;

import org.jrm.data.DownloadRecord;

import java.util.Date;

/**
 * Interface model for persistence. Provides methods to get a record and set a record.
 * @author Jared Mallas
 * @version 1.0
 */
public interface Persistence
{
    void setRecord(Date testStartTime, Date testEndTime, Float downloadRate);
    DownloadRecord getRecord();
}
