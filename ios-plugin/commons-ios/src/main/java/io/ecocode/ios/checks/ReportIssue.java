package io.ecocode.ios.checks;

import javax.annotation.Nullable;
import java.util.Objects;

public class ReportIssue {

    private final String ruleId;
    private final String message;
    @Nullable
    private final String filePath;
    @Nullable
    private final Integer lineNumber;

    public ReportIssue(String ruleId, String message, @Nullable String filePath, @Nullable Integer lineNumber) {
        this.ruleId = ruleId;
        this.message = message;
        this.filePath = filePath;
        this.lineNumber = lineNumber;
    }

    public ReportIssue(String ruleId, String message) {
        this.ruleId = ruleId;
        this.message = message;
        this.filePath = null;
        this.lineNumber = null;
    }

    public String getRuleId() {
        return ruleId;
    }

    public String getMessage() {
        return message;
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportIssue that = (ReportIssue) o;
        return Objects.equals(lineNumber, that.lineNumber) &&
                Objects.equals(ruleId, that.ruleId) &&
                Objects.equals(message, that.message) &&
                Objects.equals(filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruleId, message, filePath, lineNumber);
    }
}
