package model;

public class TransferRecord {
    public String fromAccount;
    public String toAccount;
    public long amount;

    public static TransferRecord parse(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) return null;

        try {
            TransferRecord record = new TransferRecord();
            record.fromAccount = parts[0].trim();
            record.toAccount = parts[1].trim();
            record.amount = Long.parseLong(parts[2].trim());
            return record;
        } catch (Exception e) {
            return null;
        }
    }
}