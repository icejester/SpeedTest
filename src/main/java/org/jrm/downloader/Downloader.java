package org.jrm.downloader;

import java.util.Date;

/**
 * Interface model for a downloader
 * @author Jared Mallas
 * @version 1.0
 * @see HttpDownloader
 */
public interface Downloader
{
    void download();
    Date getStartTime();
    Date getEndTime();
    Float getDownloadRate();
}
