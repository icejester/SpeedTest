package org.jrm.speedtest;

import org.jrm.data.DownloadRecord;
import org.jrm.downloader.Downloader;
import org.jrm.downloader.DownloaderFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoRecord
{
    @RequestMapping("/doRecord")
    public String index()
    {

        String returnString = "Download complete\n";
        DownloadRecord dr = DownloadRecord.getInstance();
        Downloader dl = new DownloaderFactory(null).genDownloader();

        dl.download();

        dr.setTestStartTime(dl.getStartTime());
        dr.setTestEndTime(dl.getEndTime());
        dr.setDownloadRate(dl.getDownloadRate());
        return returnString;
    }
}
