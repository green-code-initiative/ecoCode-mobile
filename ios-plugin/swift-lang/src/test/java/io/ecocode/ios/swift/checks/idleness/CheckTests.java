package io.ecocode.ios.swift.checks.idleness;

import io.ecocode.ios.swift.checks.CheckTestHelper;
import org.junit.Test;
import org.sonar.api.batch.sensor.internal.SensorContextTester;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTests {

    @Test
    public void idleTimerDisabled_trigger() {
        SensorContextTester context = CheckTestHelper.analyzeTestFile("checks/IdleTimerDisabled_trigger.swift");
        assertThat(context.allIssues()).hasSize(1);
    }

    @Test
    public void idleTimerDisabled_no_trigger() {
        SensorContextTester context = CheckTestHelper.analyzeTestFile("checks/IdleTimerDisabled_no_trigger.swift");
        assertThat(context.allIssues()).hasSize(0);
    }
}
