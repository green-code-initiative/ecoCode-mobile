package io.ecocode.ios.swift;

import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonarsource.analyzer.commons.BuiltInQualityProfileJsonLoader;

public class EcoCodeSwiftProfile implements BuiltInQualityProfilesDefinition {
    @Override
    public void define(Context context) {
        NewBuiltInQualityProfile ecoCodeProfile = context.createBuiltInQualityProfile(Swift.PROFILE_NAME, Swift.KEY);
        BuiltInQualityProfileJsonLoader.load(ecoCodeProfile, Swift.REPOSITORY_KEY, Swift.PROFILE_PATH);
        ecoCodeProfile.done();
    }
}
