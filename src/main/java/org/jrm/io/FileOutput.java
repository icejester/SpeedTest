package org.jrm.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Class model for FileOutput
 * @author Jared R Mallas
 * @version 1.0
 */
public class FileOutput
{
    public static final Logger logger = LogManager.getLogger(FileOutput.class);
    String filePath;
    Writer out = null;

    /**
     * Constructor for FileOutput
     * @param filePath String containing a full or relative path to a file
     */
    public FileOutput(String filePath) {
        this.filePath = filePath;

        try
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        }
        catch(FileNotFoundException e)
        {
            // TODO: Handle this exception
            logger.error("Unable to open file for write " + filePath);
        }
    }

    /**
     * Method for writing the contents of a String to a file
     * @param toWrite String to write to file.
     */
    public void writeFile(String toWrite)
    {
        try
        {
            out.write(toWrite);
            out.close();
        }
        catch(Exception e)
        {
            // TODO: Handle this exception
            logger.error("File write error: " + filePath);
        }
    }
}