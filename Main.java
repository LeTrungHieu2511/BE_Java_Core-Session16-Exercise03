package vn.edu.rikkei.session16.ex03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    private static final int WIDTH = 55;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.print("""
                --- GHI NHẬT KÝ HỆ THỐNG VỚI CONSUMER & SUPPLIER ---
                Sự kiện 1: "USER_LOGIN"
                Sự kiện 2: "UPDATE_DATABASE"
                Sự kiện 3: "SYSTEM_BACKUP"
                """);

        // Supplier: không nhận tham số, mỗi lần get() trả về thời gian hiện tại
        Supplier<String> timeSupplier = () -> LocalDateTime.now().format(FORMATTER);

        // Consumer: nhận thông điệp log và in vào dòng của bảng, không trả về gì
        Consumer<String> logger = msg -> printOutput(" -> " + msg);

        printOutput(null);
        printOutput(centerText(" NHẬT KÝ HỆ THỐNG CONSUMER-SUPPLIER "));
        printOutput(null);

        AuditLogger.logEvent(timeSupplier, logger, "USER_LOGIN");
        AuditLogger.logEvent(timeSupplier, logger, "UPDATE_DATABASE");
        AuditLogger.logEvent(timeSupplier, logger, "SYSTEM_BACKUP");

        printOutput(null);
    }

    // content == null thì in đường viền, ngược lại thì in 1 dòng có nội dung
    static void printOutput(String content) {
        if (content == null) {
            System.out.printf("+%s+%n", "-".repeat(WIDTH));
        } else {
            System.out.printf("|%-" + WIDTH + "s|%n", content);
        }
    }

    private static void printDivider() {
        System.out.printf("|%s|%n", "-".repeat(WIDTH));
    }

    private static String centerText(String text) {
        int padding = Math.max((WIDTH - text.length()) / 2, 0);
        return " ".repeat(padding) + text;
    }
}