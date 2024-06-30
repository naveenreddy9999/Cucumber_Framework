package pdfReader;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;
import java.time.Duration;
import java.util.*;

public class reader {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        String name = "pdf";

        String url = null;

        switch (name.toLowerCase()) {
            case "pdf" -> {
                url = "https://filesamples.com/formats/pdf";
                break;
            }
            case "csv" -> {
                url = "https://filesamples.com/formats/csv";
                break;
            }
        }


        String downloadLocation = "C:\\Users\\NAVEBAND\\IdeaProjects\\CucumberFramework\\src\\download";
        File directory = new File(downloadLocation);
        FileUtils.cleanDirectory(directory);

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        chromeOptions.setAcceptInsecureCerts(true);
        prefs.put("download.default_directory", downloadLocation);
        chromeOptions.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[text()='Download'])[1]")).click();
        Thread.sleep(3000);
        File file = new File(downloadLocation);
        File[] listOfFiles = file.listFiles();

        boolean isFileAvailable = false;

        assert listOfFiles != null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                readFileDetails(listOfFile);
                isFileAvailable = true;
            }
        }

        System.out.println(isFileAvailable);
        driver.close();
    }

    public static void readFileDetails(File listOfFile) throws IOException, CsvValidationException {
        String fileName = listOfFile.getName();
        System.out.println("File Name ::" + fileName);
        List<String> listColumn1 = new ArrayList<>();
        List<String> listColumn2 = new ArrayList<>();

        if (fileName.endsWith(".csv")) {
            try {
                CSVReader reader = new CSVReader(new FileReader(listOfFile));
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    listColumn1.add(nextLine[0]);
                    listColumn2.add(nextLine[1]);
                }
            } catch (Exception ignore) {

            }
            System.out.println(listColumn1);
            System.out.println(listColumn2);
        } else if (fileName.endsWith(".pdf")) ;
        {
            PdfReader reader = new PdfReader(listOfFile.getAbsolutePath());
            int numberOfPages = reader.getNumberOfPages();
            System.out.println("Page Count ::"+numberOfPages +"\n");
            String allText = "";
            for (int i = 1; i <= numberOfPages; i++) {
                String pageText = PdfTextExtractor.getTextFromPage(reader, i);
                allText += pageText;
            }
            System.out.println(allText);
            reader.close();
        }
    }
}
