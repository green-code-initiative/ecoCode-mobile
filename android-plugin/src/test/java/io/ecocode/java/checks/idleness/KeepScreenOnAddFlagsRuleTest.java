package io.ecocode.java.checks.idleness;

import org.junit.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class KeepScreenOnAddFlagsRuleTest {

    @Test
    public void verify() {
        CheckVerifier.newVerifier().onFile("src/test/files/idleness/KeepScreenOnAddFlagsCheck.java")
                .withCheck(new KeepScreenOnAddFlagsRule())
                .verifyIssues();
    }
}
