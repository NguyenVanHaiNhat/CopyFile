import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourceFilePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tệp đích: ");
        String targetFilePath = scanner.nextLine();

        System.out.println("Đường dẫn nguồn : " + sourceFilePath);
        System.out.println("Đường dẫn đích : " + targetFilePath);

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            System.exit(1);
        }

        File targetFile = new File(targetFilePath);
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại. Vui lòng chọn tên tệp khác.");
            System.exit(1);
        }

        try (
                FileReader reader = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(reader);

                FileWriter writer = new FileWriter(targetFile);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            int character;
            int characterCount = 0;

            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(character);
                characterCount++;
            }

            System.out.println("Sao chép thành công. Số ký tự trong tệp: " + characterCount);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi sao chép tệp.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
