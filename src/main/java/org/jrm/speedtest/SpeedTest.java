package org.jrm.speedtest;

import org.jrm.data.DownloadRecord;
import org.jrm.downloader.Downloader;
import org.jrm.downloader.DownloaderFactory;
import org.jrm.persistence.PersistenceFactory;
import org.jrm.persistence.PersistenceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeedTest
{
    @RequestMapping("/SpeedTest")
    public String index()
    {

        String returnString;
        DownloadRecord dr = new PersistenceFactory().getPersistence(PersistenceType.MEMORY).getRecord();
        returnString = dr.getTestStartTime().toString() + " ";
        returnString += dr.getDownloadRate().toString() + " mb/s\n";

        return returnString;
    }
}
