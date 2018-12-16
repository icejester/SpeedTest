package org.jrm.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class model for FileInput
 * @author Jared R Mallas
 * @version 1.0
 */
public class FileInput
{
    public static final Logger logger = LogManager.getLogger(FileInput.class);

    public String filePath;
    private BufferedReader in = null;

    /**
     * Constructor for FileInput
     * @param filePath String containing a full or relative path to a readable file
     */
    public FileInput(String filePath)
    {
        this.filePath = filePath;

        try
        {
            in = new BufferedReader(new FileReader(filePath));
        }
        catch (FileNotFoundException e)
        {
            // TODO: Handle this exception
            logger.error("File: " + filePath + " not found");
            this.filePath = null;
        }
    }

    /**
     * Method to read an entire file into a String
     * @return String containing the contents of a file
     */
    public String readFile()
    {
        String rString = new String();
        String line;
        try
        {
            while ((line = in.readLine()) != null)
            {
                rString += line;
                rString += '\n';
            }
            // remove trailing '\n'
            rString = rString.substring(0, rString.length() -1);
        }
        catch (Exception e)
        {
            // TODO: Handle this exception
            logger.error("File read error: " + filePath);
        }
        return rString;
    }

    /**
     * Method to fetch a single line from a file
     * @return string containing the next line
     */
    public String readLine()
    {
        String rString = null;

        try
        {
            rString = in.readLine();
        }
        catch (IOException e)
        {
            // TODO: Handle this exception
            logger.error("File Read Error: " + filePath);
        }
        return rString;
    }

    /**
     * Close file that is opened by constructor
     */
    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                // TODO: Handle this exception
                logger.error("Unable to close file handle " + in.toString());
                e.printStackTrace();
            }
        }
    }
}