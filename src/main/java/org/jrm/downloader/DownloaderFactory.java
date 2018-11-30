package org.jrm.downloader;

public class DownloaderFactory
{
    String target;

    public Downloader genDownloader()
    {
        return new HttpDownloader(target);
    }

    public Downloader genDownloader(DownloadType type)
    {
        switch (type)
        {
            case HTTP: return new HttpDownloader(target);
            default: return null;
        }
    }

    public DownloaderFactory(String target)
    {
        this.target = "http://speedtest-ny.turnkeyinternet.net/100mb.bin";
    }
}
