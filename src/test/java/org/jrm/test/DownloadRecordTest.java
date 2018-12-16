package org.jrm.test;

import org.jrm.data.DownloadRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DownloadRecordTest
{
    DownloadRecord dr, dr2;
    Float DownloadRate;

    @BeforeEach
    void setUp()
    {
        dr = DownloadRecord.getInstance();
        dr.setDownloadRate(DownloadRate);
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Verify that you get a singleton")
    @Test
    void getInstance()
    {
        dr2 = DownloadRecord.getInstance();
        assertEquals(DownloadRate, dr2.getDownloadRate(), "Rate should be set to 100 already...");
    }
}