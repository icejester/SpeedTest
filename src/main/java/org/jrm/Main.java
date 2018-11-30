package org.jrm;

import org.jrm.data.DownloadRecord;
import org.jrm.downloader.DownloaderFactory;
import org.jrm.downloader.Downloader;
import org.jrm.util.TimeUtils;


public class Main
{
    public static void main(String[] args)
    {
        Downloader dl = new DownloaderFactory().genDownloader();

        dl.download();

        // DownloadRecord dr = new DownloadRecord(dl.getStartTime().getTime(), dl.getEndTime().getTime(), 100l, dl.getDownloadRate());
        DownloadRecord dr = new DownloadRecord(dl.getStartTime(), dl.getEndTime(), dl.getDownloadRate());

        System.out.println(TimeUtils.dateToString(dr.getTestStartTime()) + " " + dr.getDownloadRate() + "mb/s");

    }
}
