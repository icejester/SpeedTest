package org.jrm.persistence;

import org.jrm.data.DownloadRecord;

import java.util.Date;

/**
 * Class model for an "in memory" implementation of persistence
 * @author Jared Mallas
 * @version 1.0
 * @see org.jrm.persistence.Persistence
 */
public class MemoryPersistence implements Persistence
{
    private static MemoryPersistence inst = null;
    private MemoryPersistence () {}

    static MemoryPersistence getInstance()
    {
        synchronized (MemoryPersistence.class)
        {
            if (inst == null)
            {
                inst = new MemoryPersistence();
            }
        }

        return inst;
    }

    @Override
    public void setRecord(Date testStartTime, Date testEndTime, Float downloadRate)
    {
        DownloadRecord dr = DownloadRecord.getInstance();
        dr.setTestStartTime(testStartTime);
        dr.setTestEndTime(testEndTime);
        dr.setDownloadRate(downloadRate);
    }

    @Override
    public DownloadRecord getRecord() {
        return DownloadRecord.getInstance();
    }
}
