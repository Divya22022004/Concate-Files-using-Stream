import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConcatenateFiles {
    public static void main(String[] args) {
        String file1 = "file1.txt";  // First file to concatenate
        String file2 = "file2.txt";  // Second file to concatenate
        String outputFile = "output.txt";  // Output file

        try (
            FileInputStream fis1 = new FileInputStream(file1);  // Stream for first file
            FileInputStream fis2 = new FileInputStream(file2);  // Stream for second file
            FileOutputStream fos = new FileOutputStream(outputFile)  // Output stream for concatenated content
        ) {
            // Write content from first file
            writeFileToStream(fis1, fos);

            // Write content from second file
            writeFileToStream(fis2, fos);

            System.out.println("Files concatenated successfully into " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to read from InputStream and write to OutputStream
    private static void writeFileToStream(FileInputStream fis, FileOutputStream fos) throws IOException {
        byte[] buffer = new byte[1024];  // Buffer to hold chunks of data
        int bytesRead;
        
        while ((bytesRead = fis.read(buffer)) != -1) {  // Read data in chunks
            fos.write(buffer, 0, bytesRead);  // Write the data to the output file
        }
    }
}
