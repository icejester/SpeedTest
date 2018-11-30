package org.jrm.downloader;

public class DownloaderFactory
{
    public Downloader genDownloader()
    {
        return new HttpDownloader("http://speedcheck.cdn.on.net/100meg.test");
    }

    public Downloader genDownloader(DownloadType type)
    {
        switch (type)
        {
            case HTTP: return new HttpDownloader("http://speedcheck.cdn.on.net/100meg.test");
            default: return null;
        }
    }
}
