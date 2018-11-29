package org.jrm;

import org.jrm.data.DownloadRecord;
import org.jrm.util.TimeUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Long startMilli, stopMilli, elapsed;
        Integer elapsedSeconds;

        List<String> urlList = new ArrayList();
        urlList.add("http://speedtest-ny.turnkeyinternet.net/100mb.bin");
        urlList.add("http://speedtest-ca.turnkeyinternet.net/100mb.bin");
        urlList.add("http://speedcheck.cdn.on.net/100meg.test");

        urlList.add("http://speedtest-ny.turnkeyinternet.net/1000mb.bin");
        urlList.add("http://speedtest-ca.turnkeyinternet.net/1000mb.bin");

        urlList.add("http://speedtest-ny.turnkeyinternet.net/10000mb.bin");
        urlList.add("http://speedtest-ca.turnkeyinternet.net/10000mb.bin");

        System.out.println("Beginning download...");
        startMilli = System.currentTimeMillis();

        try(BufferedInputStream inputStream = new BufferedInputStream(new URL("https://player.vimeo.com/external/192234799.hd.mp4?s=1582f4b69a08f0ae1966f393a081a9050e9a644e&profile_id=119&oauth2_token_id=57447761&download=1").openStream());
            FileOutputStream fileOS = new FileOutputStream("./dload.out"))
        {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1)
            {
                fileOS.write(data, 0, byteContent);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Caught some exception: \n");
            ex.printStackTrace();
        }


        stopMilli = System.currentTimeMillis();
        elapsed = (stopMilli - startMilli);
        elapsedSeconds = (elapsed.intValue() / 1000);
        System.out.println("Download complete...");
        // System.out.println("Download complete " + elapsedSeconds + " seconds elapsed");

        File outFile = new File("./dload.out");
        Long mbitSize = (((outFile.length() / 1024) / 1024) * 8);

        Integer rate = (mbitSize.intValue()/elapsedSeconds);

        outFile.delete();

        // System.out.println("Download speed: " + rate + " mb/second");

        DownloadRecord dr = new DownloadRecord(startMilli, stopMilli, mbitSize, rate);

        System.out.println(TimeUtils.dateToString(dr.getTestStartTime()) + " " + dr.getDownloadRate() + "mb/s");

    }
}
