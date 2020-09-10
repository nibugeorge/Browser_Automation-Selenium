package Utils;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ExtentManager {
    public static Properties prop = new Properties();
    static InputStream input = null;
    static String Path;

    public static ExtentReports Instance() throws Exception
    {
        ExtentReports extent = null;
        Path = Config.REPORT_FILEPATH;
        extent = new ExtentReports(Path,false);
        extent.loadConfig(new File(Config.REPORTCONFIG_FILEPATH));

        //System.out.println(Path);
        return extent;
    }
}
