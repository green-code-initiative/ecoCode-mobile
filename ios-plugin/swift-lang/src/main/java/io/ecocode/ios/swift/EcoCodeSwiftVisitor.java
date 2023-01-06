package io.ecocode.ios.swift;

import io.ecocode.ios.antlr.AntlrContext;
import io.ecocode.ios.antlr.ParseTreeItemVisitor;
import io.ecocode.ios.checks.RuleCheck;
import io.ecocode.ios.swift.checks.idleness.IdleTimerDisabledCheck;
import org.antlr.v4.runtime.tree.ParseTree;
import org.sonar.api.batch.sensor.SensorContext;

import java.util.ArrayList;
import java.util.List;

public class EcoCodeSwiftVisitor implements ParseTreeItemVisitor {

    private List<RuleCheck> checks = new ArrayList<>();

    public EcoCodeSwiftVisitor() {

        // Load checks
        checks.add(new IdleTimerDisabledCheck());

    }

    @Override
    public void apply(ParseTree tree) {
        for (RuleCheck check : checks) {
            check.apply(tree);
        }
    }

    @Override
    public void fillContext(SensorContext context, AntlrContext antlrContext) {
        for (RuleCheck check : checks) {
            check.fillContext(context, antlrContext);
        }
    }
}
