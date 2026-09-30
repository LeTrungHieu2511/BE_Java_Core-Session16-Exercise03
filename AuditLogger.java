package vn.edu.rikkei.session16.ex03;

import java.util.function.Consumer;
import java.util.function.Supplier;

// module ghi log gọn nhẹ: thời gian lấy từ Supplier, đầu ra giao cho Consumer
public class AuditLogger {

    // timeSupplier chỉ được gọi get() tại thời điểm ghi log (Deferred Execution)
    public static void logEvent(Supplier<String> timeSupplier, Consumer<String> logger, String eventName) {
        String timestamp = timeSupplier.get();
        String fullMessage = "[" + timestamp + "] - SỰ KIỆN: " + eventName;
        logger.accept(fullMessage);
    }
}