package org.jrm.speedtest;

import org.jrm.data.DownloadRecord;
import org.jrm.downloader.Downloader;
import org.jrm.downloader.DownloaderFactory;
import org.jrm.persistence.PersistenceFactory;
import org.jrm.persistence.PersistenceType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class model for a rest controller that returns the last "speed test" performed by this program
 * @author Jared Mallas
 * @version 1.0
 */
@RestController
public class SpeedTest
{
    /**
     * Invoked on 'get' will acquire some sort of persistence layer (for records of past speed tests)
     * fetch the last record and return its results
     * @return String representation of a locally performed speed test
     */
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
