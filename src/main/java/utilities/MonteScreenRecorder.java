package utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class MonteScreenRecorder extends ScreenRecorder
{
    public static ScreenRecorder screenRecorder;
    public String name;

    // Method Name: MonteScreenRecorder
    // Method Description: This method init the monte carlo recorder and provides configuration
    // Method Parameters: GraphicsConfiguration, Rectangle, 4 X Format (fileFormat, screenFormat, mouseFormat, audioFormat),
    //                    File, String
    // Method Return: None
    public MonteScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    // Method Name: createMovieFile
    // Method Description: This method creates a movie file
    // Method Parameters: Format
    // Method Return: File
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException
    {
        if (!movieFolder.exists())
        {
            movieFolder.mkdirs();
        }
        else if (!movieFolder.isDirectory())
        {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }

        System.out.println("file is now created");
        return new File(movieFolder,
                name + "." + Registry.getInstance().getExtension(fileFormat));
    }

    // Method Name: startRecord
    // Method Description: This method starts the record
    // Method Parameters: String
    // Method Return: None
    public static void startRecord(String methodName) throws Exception
    {
        File file = new File("./test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();
        screenRecorder = new MonteScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        screenRecorder.start();
    }

    // Method Name: stopRecord
    // Method Description: This method stops the record
    // Method Parameters: None
    // Method Return: None
    public static void stopRecord() throws Exception
    {
        screenRecorder.stop();
        System.out.println("file stop recording");
    }
}
