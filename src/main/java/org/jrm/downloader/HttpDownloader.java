package org.jrm.downloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class model for an http based downloader. Will attempt to download the contents of
 * a given http url.
 * @author Jared Mallas
 * @version 1.0
 * @see org.jrm.downloader.Downloader
 * @see HttpDownloader
 */
public class HttpDownloader implements Downloader
{
    private static final Logger logger = LogManager.getLogger(HttpDownloader.class);

    public static int KB = 1024;
    public static int MBITSIZE = 125000;
    public static int MILLIS = 1000;

    Date testStartTime, testEndTime;
    Long byteSize = 0l;
    Integer downloadRate;
    String objectURL;

    // TODO: figure out how to safely gen a temp file...
    String tempFile = "./dload.out";

    public HttpDownloader(String objectURL)
    {
        this.objectURL = objectURL;
    }

    @Override
    public void download()
    {
        testStartTime = new Date();
        try(BufferedInputStream inputStream = new BufferedInputStream(new URL(objectURL).openStream());
            FileOutputStream fileOS = new FileOutputStream(tempFile))
        {
            // byte data[] = new byte[1024];
            byte data[] = new byte[KB];
            int byteContent;
            // while ((byteContent = inputStream.read(data, 0, 1024)) != -1)
            while ((byteContent = inputStream.read(data, 0, KB)) != -1)
            {
                byteSize += data.length;
                //fileOS.write(data, 0, byteContent);
            }
        }
        catch (Exception ex)
        {
            logger.warn("Caught some exception: \n");
            ex.printStackTrace();
        }
        testEndTime = new Date();
        // File oFile = new File(tempFile);
        // byteSize = oFile.length();
        // oFile.delete();
    }

    @Override
    public Date getStartTime() {
        return testStartTime;
    }

    @Override
    public Date getEndTime() {
        return testEndTime;
    }

    @Override
    public Float getDownloadRate()
    {
        Float rFloat;
        // Long mbitSize = byteSize / 125000;
        Long mbitSize = byteSize / MBITSIZE;
        // Long elapsed = ((testEndTime.getTime() - testStartTime.getTime()) / 1000);
        Long elapsed = ((testEndTime.getTime() - testStartTime.getTime()) / MILLIS);

        rFloat = mbitSize.floatValue()/elapsed.floatValue();
        return rFloat;
    }

}
