package org.jrm.downloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;

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
    Date testStartTime, testEndTime;
    Long byteSize = 0l;
    Integer downloadRate;
    String objectURL;
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
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1)
            {
                byteSize += data.length;
                //fileOS.write(data, 0, byteContent);
            }
        }
        catch (Exception ex)
        {
            // TODO: HANDLE THIS
            System.out.println("Caught some exception: \n");
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
        Long mbitSize = byteSize / 125000;
        Long elapsed = ((testEndTime.getTime() - testStartTime.getTime()) / 1000);

        rFloat = mbitSize.floatValue()/elapsed.floatValue();
        return rFloat;
    }

}
