package project3;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
public class NginxLogAnalyzer {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].equals("--path")) {
            System.out.println("Usage: java -jar nginx-log-analyzer.jar --path <logFilePath>");
            System.exit(1);
        }

        String logFilePath = args[1];
        LogReport logReport = analyzeLogs(logFilePath);

        if (logReport != null) {
            logReport.setLogFilePath(logFilePath);
            String markdownReport = logReport.toMarkdown();
            System.out.println(markdownReport);
        } else {
            System.exit(1);
        }
    }

    private static LogReport analyzeLogs(String logFilePath) {
        try (Stream<String> lines = Files.lines(Paths.get(logFilePath))) {
            return lines.map(NginxLogAnalyzer::parseLogLine)
                .collect(LogReport::new, LogReport::accumulate, LogReport::combine);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static TypedLogRecord parseLogLine(String logLine) {

        String[] logParts = logLine.split("\\s+");
        return new TypedLogRecord(
            logParts[0],
            logParts[1],
            OffsetDateTime.parse(logParts[3].substring(1, logParts[3].length() - 1)),
            logParts[5].substring(1),
            Integer.parseInt(logParts[6]),
            Long.parseLong(logParts[7]),
            logParts[9].equals("\"-\"") ? null : logParts[9].substring(1, logParts[9].length() - 1),
            logParts[11].substring(1, logParts[11].length() - 1)
        );
    }
}

class TypedLogRecord {
    private String remoteAddr;
    private String remoteUser;
    private OffsetDateTime timestamp;
    private String request;
    private int status;
    private long bodyBytesSent;
    private String referer;
    private String userAgent;

    public TypedLogRecord(String remoteAddr, String remoteUser, OffsetDateTime timestamp,
        String request, int status, long bodyBytesSent, String referer, String userAgent) {
        this.remoteAddr = remoteAddr;
        this.remoteUser = remoteUser;
        this.timestamp = timestamp;
        this.request = request;
        this.status = status;
        this.bodyBytesSent = bodyBytesSent;
        this.referer = referer;
        this.userAgent = userAgent;

    }
    public String getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public long getBodyBytesSent() {
        return bodyBytesSent;
    }

    // Геттеры

    @Override
    public String toString() {
        return "TypedLogRecord{" +
            "remoteAddr='" + remoteAddr + '\'' +
            ", remoteUser='" + remoteUser + '\'' +
            ", timestamp=" + timestamp +
            ", request='" + request + '\'' +
            ", status=" + status +
            ", bodyBytesSent=" + bodyBytesSent +
            ", referer='" + referer + '\'' +
            ", userAgent='" + userAgent + '\'' +
            '}';
    }


}

class LogReport {
    private String logFilePath;
    private int totalRequests;
    private Map<String, Integer> resourceFrequency;
    private Map<Integer, Integer> responseCodeFrequency;
    private long totalResponseSize;

    public LogReport() {
        this.totalRequests = 0;
        this.resourceFrequency = new HashMap<>();
        this.responseCodeFrequency = new HashMap<>();
        this.totalResponseSize = 0;
    }
    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }
    public void accumulate(TypedLogRecord logRecord) {
        totalRequests++;
        resourceFrequency.merge(logRecord.getRequest(), 1, Integer::sum);
        responseCodeFrequency.merge(logRecord.getStatus(), 1, Integer::sum);
        totalResponseSize += logRecord.getBodyBytesSent();
    }

    public void combine(LogReport other) {
        totalRequests += other.totalRequests;
        other.resourceFrequency.forEach((resource, count) ->
            resourceFrequency.merge(resource, count, Integer::sum));
        other.responseCodeFrequency.forEach((code, count) ->
            responseCodeFrequency.merge(code, count, Integer::sum));
        totalResponseSize += other.totalResponseSize;
    }

    public String toMarkdown() {
        StringBuilder markdownReport = new StringBuilder();
        markdownReport.append("#### Общая информация\n\n");
        markdownReport.append("|        Метрика        |     Значение |\n");
        markdownReport.append("|:---------------------:|-------------:|\n");
        markdownReport.append("|       Файл(-ы)        | `" + logFilePath + "` |\n");
        // Добавьте остальные метрики...

        markdownReport.append("\n#### Запрашиваемые ресурсы\n\n");
        markdownReport.append("|     Ресурс      | Количество |\n");
        markdownReport.append("|:---------------:|-----------:|\n");
        resourceFrequency.forEach((resource, count) ->
            markdownReport.append("|  `" + resource + "`  |      " + count + " |\n"));

        markdownReport.append("\n#### Коды ответа\n\n");
        markdownReport.append("| Код |          Имя          | Количество |\n");
        markdownReport.append("|:---:|:---------------------:|-----------:|\n");
        responseCodeFrequency.forEach((code, count) ->
            markdownReport.append("| " + code + " |          " + getResponseName(code) + "           |       " + count + " |\n"));

        return markdownReport.toString();
    }

    private String getResponseName(int responseCode) {
        return String.valueOf(responseCode);
    }
}


