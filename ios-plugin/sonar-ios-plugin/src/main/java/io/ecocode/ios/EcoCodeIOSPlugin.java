package io.ecocode.ios;

import io.ecocode.ios.swift.EcoCodeSwiftProfile;
import io.ecocode.ios.swift.EcoCodeSwiftRulesDefinition;
import io.ecocode.ios.swift.SwiftSensor;
import org.sonar.api.Plugin;

public class EcoCodeIOSPlugin implements Plugin  {

    @Override
    public void define(Context context) {

        context.addExtensions(SwiftSensor.class, EcoCodeSwiftProfile.class, EcoCodeSwiftRulesDefinition.class);
    }
}
