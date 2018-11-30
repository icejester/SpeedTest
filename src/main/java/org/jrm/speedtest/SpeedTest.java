package org.jrm.speedtest;

import org.jrm.downloader.Downloader;
import org.jrm.downloader.DownloaderFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeedTest
{
    @RequestMapping("/SpeedTest")
    public String index()
    {
        String returnString;
        Downloader dl = new DownloaderFactory(null).genDownloader();

        dl.download();

        returnString = dl.getDownloadRate().toString() + "mb/s\n";
        return returnString;
    }
}
