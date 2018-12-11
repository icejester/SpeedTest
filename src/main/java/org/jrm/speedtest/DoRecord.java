package org.jrm.speedtest;

import org.jrm.downloader.Downloader;
import org.jrm.downloader.DownloaderFactory;
import org.jrm.persistence.Persistence;
import org.jrm.persistence.PersistenceFactory;
import org.jrm.persistence.PersistenceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class model for a rest controller that performs a "speed test"
 * @author Jared Mallas
 * @version 1.0
 */@RestController
public class DoRecord
{
    /**
     * Endpoint to initiate a local speed test and persist that test in memory or a DB.
     * @return String acknowledging completion
     */
    @RequestMapping("/doRecord")
    public String index()
    {
        String returnString = "Download complete\n";
        Persistence pl = new PersistenceFactory().getPersistence(PersistenceType.MEMORY);
        // Persistence pl = new PersistenceFactory().getPersistence(PersistenceType.MONGO);
        Downloader dl = new DownloaderFactory(null).genDownloader();

        dl.download();

        pl.setRecord(dl.getStartTime(), dl.getEndTime(), dl.getDownloadRate());

        return returnString;
    }
}
