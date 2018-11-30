package org.jrm.downloader;

import java.util.Date;

public interface Downloader
{
    void download();
    Date getStartTime();
    Date getEndTime();
    Float getDownloadRate();
}
