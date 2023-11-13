package com.NopCom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
    Properties properties;
    public ReadConfig()  {
        File src= new File("./Configuration/config.properties");
        try {
            FileInputStream fileInputStream =new FileInputStream(src);
            properties =new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Exception is:" + e.getMessage());
        }

    }
    public String getApplicationURL()
    {
        return properties.getProperty("url");
    }
    public String getAdminEmail()
    {
        return properties.getProperty("adminEmail");
    }
    public String getAdminPassword()
    {
        return properties.getProperty("adminPassword");
    }
    public String getChromePath()
    {
        return properties.getProperty("chromePath");
    }
    public String getEdgePath()
    {
        return properties.getProperty("edgePath");
    }



}
