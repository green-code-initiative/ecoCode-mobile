package io.ecocode.ios.rules;

import io.ecocode.ios.checks.ReportIssue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportIssueTest {

    @Test
    public void equals() {
        ReportIssue issue1 = new ReportIssue("1", "msg", "/test/path", 20);
        ReportIssue issue2 = new ReportIssue("1", "msg", "/test/path", 20);

        assertThat(issue1).isEqualTo(issue2);
    }

    @Test
    public void notEqual() {
        ReportIssue issue1 = new ReportIssue("1", "msg", "/test/path", 20);
        ReportIssue issue2 = new ReportIssue("2", "msg", "/test/path", 20);

        assertThat(issue1).isNotEqualTo(issue2);
    }
}
