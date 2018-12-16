package org.jrm.downloader;

/**
 * Class model for a downloader factory. Will return an object that will download a file
 * @author Jared Mallas
 * @version 1.0
 * @see Downloader
 */
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
        //TODO: Determine how to select a random url from list of known good urls
        this.target = "http://speedtest-ny.turnkeyinternet.net/100mb.bin";
    }
}
