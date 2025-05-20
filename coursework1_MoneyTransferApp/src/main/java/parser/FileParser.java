package parser;

import exception.TransferException;
import model.TransferRecord;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileParser {
    private final String INPUT_FOLDER = "input";
    private final String ARCHIVE_FOLDER = "archive";
    private final String REPORT_FILE = "report.txt";

    private Map<String, Long> accounts = new HashMap<>();

    public void parseFiles() {
        File inputDir = new File(INPUT_FOLDER);
        File archiveDir = new File(ARCHIVE_FOLDER);
        if (!archiveDir.exists()) {
            archiveDir.mkdir();
        }

        File[] files = inputDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            System.out.println("Нет файлов для обработки.");
            return;
        }

        for (File file : files) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());

                for (String line : lines) {
                    try {
                        TransferRecord record = TransferRecord.parse(line);

                        if (record == null) {
                            System.out.println("Некорректная строка: " + line);
                            continue;
                        }

                        processTransfer(record);

                    } catch (TransferException te) {
                        System.out.println("Ошибка перевода: " + te.getMessage());
                    }
                }

                Thread.sleep(100);

                Path targetPath = Paths.get(ARCHIVE_FOLDER, file.getName());
                Files.move(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Файл " + file.getName() + " перемещён в архив.");

            } catch (IOException | InterruptedException e) {
                System.out.println("Ошибка при обработке файла " + file.getName() + ": " + e.getMessage());
            }
        }

        saveReport();
    }

    private void processTransfer(TransferRecord record) throws TransferException {
        if (record.amount <= 0) {
            throw new TransferException("Сумма должна быть положительной: " + record.amount);
        }

        if (!record.fromAccount.matches("\\d{10}") || !record.toAccount.matches("\\d{10}")) {
            throw new TransferException("Неверный формат номера счёта.");
        }

        accounts.put(record.fromAccount,
                accounts.getOrDefault(record.fromAccount, 0L) - record.amount);
        accounts.put(record.toAccount,
                accounts.getOrDefault(record.toAccount, 0L) + record.amount);
    }

    public void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE))) {
            for (Map.Entry<String, Long> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Отчёт сохранён в " + REPORT_FILE);
        } catch (IOException e) {
            System.out.println("Не удалось сохранить отчёт: " + e.getMessage());
        }
    }

    public void printReport() {
        try {
            Files.lines(Paths.get(REPORT_FILE)).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Файл отчёта не найден.");
        }
    }
}