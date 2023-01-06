package io.ecocode.ios.rules;

import io.ecocode.ios.checks.ReportIssue;
import io.ecocode.ios.checks.ReportIssueRecorder;
import org.junit.Test;
import org.sonar.api.batch.fs.internal.DefaultInputFile;
import org.sonar.api.batch.fs.internal.TestInputFileBuilder;
import org.sonar.api.batch.sensor.internal.SensorContextTester;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ReportIssueRecorderTest {

    private static final String TEST_ROOT = "src/test/resources";
    private static final String TEST_FILENAME = "swift/main.swift";

    @Test
    public void recordIssues() {

        SensorContextTester context = SensorContextTester.create(new File(TEST_ROOT));
        DefaultInputFile testFile = new TestInputFileBuilder("", TEST_FILENAME)
                .setLanguage("swift")
                .setLines(10)
                .setOriginalLineEndOffsets(new int[10])
                .setOriginalLineStartOffsets(new int[10])
                .setModuleBaseDir(Paths.get(TEST_ROOT))
                .build();
        context.fileSystem().add(testFile);

        List<ReportIssue> issues = new ArrayList<>();
        issues.add(new ReportIssue("ruleId", "message", testFile.path().toString(), 3));

        ReportIssueRecorder recorder = new ReportIssueRecorder(context);
        recorder.recordIssues(issues, "TestRepo");

        assertThat(context.allIssues()).hasSize(1);

    }
}
