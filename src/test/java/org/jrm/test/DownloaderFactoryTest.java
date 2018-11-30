package org.jrm.test;

import org.jrm.downloader.DownloadType;
import org.jrm.downloader.DownloaderFactory;
import org.jrm.downloader.HttpDownloader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DownloaderFactoryTest {

    DownloaderFactory df;

    @BeforeEach
    void setUp()
    {
        df = new DownloaderFactory(null);
    }

    @AfterEach
    void tearDown()
    {
        df = null;
    }

    @DisplayName("Default downloader should be plain, unauthenticated http")
    @Test
    void genDownloader()
    {
        assertTrue(df.genDownloader() instanceof HttpDownloader);
    }

    @DisplayName("Generate downloader by HTTP type")
    @Test
    void genDownloaderHTTP()
    {
        assertTrue(df.genDownloader(DownloadType.HTTP) instanceof HttpDownloader);
    }

    //TODO: write tests / impls for other download types
}