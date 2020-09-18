import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Application {

    interface Archiver {

        void archive(File directory, File archive) throws IOException;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the compression algorithm that you want : ");

        String s = new Scanner(System.in).nextLine();

        File directory = new File("Files");

        if (s.equals("zip")) {
            ZipArchiver zipArchiver = new ZipArchiver();
            File zipArchive = new File("archive.zip");
            zipArchiver.archive(directory, zipArchive);
            System.out.println("Your zip archive has been created .");

        } else if (s.equals("7zip")) {

            SevenZipArchiver sevenZipArchiver = new SevenZipArchiver();
            File sevenZipArchive = new File("archive.7z");
            sevenZipArchiver.archive(directory, sevenZipArchive);
            System.out.println("Your 7zip archive has been created .");

        } else {
            System.out.println("Invalid input . Please enter if you want zip or 7zip compression .");
            return;
        }


    }

}
