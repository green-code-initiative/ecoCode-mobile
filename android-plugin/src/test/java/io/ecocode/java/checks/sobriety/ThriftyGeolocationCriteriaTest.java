package io.ecocode.java.checks.sobriety;

import org.junit.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class ThriftyGeolocationCriteriaTest {

    @Test
    public void verifyOnlyRequest() {
        CheckVerifier.newVerifier().onFile("src/test/files/sobriety/ThriftyGeolocationCriteriaCheckOnlyRequest.java")
                .withCheck(new ThriftyGeolocationCriteriaRule())
                .verifyIssues();
    }

    @Test
    public void verifyNoCriteria() {
        CheckVerifier.newVerifier().onFile("src/test/files/sobriety/ThriftyGeolocationCriteriaCheckNoCriteria.java")
                .withCheck(new ThriftyGeolocationCriteriaRule())
                .verifyIssues();
    }

    @Test
    public void verifyWrongCriteria() {
        CheckVerifier.newVerifier().onFile("src/test/files/sobriety/ThriftyGeolocationCriteriaCheckWrongCriteria.java")
                .withCheck(new ThriftyGeolocationCriteriaRule())
                .verifyIssues();
    }

    @Test
    public void verifyNoIssue() {
        CheckVerifier.newVerifier().onFile("src/test/files/sobriety/ThriftyGeolocationCriteriaCheckNoIssue.java")
                .withCheck(new ThriftyGeolocationCriteriaRule())
                .verifyNoIssues();
    }
}
