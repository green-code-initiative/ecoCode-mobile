package io.ecocode.ios.swift.antlr;

import io.ecocode.ios.antlr.AntlrContext;
import io.ecocode.ios.antlr.ParseTreeItemVisitor;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.InputFile.Type;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.io.IOException;
import java.nio.charset.Charset;

public class ParseTreeAnalyzer {

    private static final int EXECUTOR_TIMEOUT = 10000;

    private static final Logger LOGGER = Loggers.get(ParseTreeAnalyzer.class);

    private final String languageKey;
    private final Type type;
    private final AntlrContext antlrContext;
    private final SensorContext sensorContext;

    public ParseTreeAnalyzer(String languageKey, Type type, AntlrContext antlrContext, SensorContext sensorContext) {
        this.languageKey = languageKey;
        this.type = type;
        this.antlrContext = antlrContext;
        this.sensorContext = sensorContext;
    }

    public void analyze(final ParseTreeItemVisitor... visitors) {

        FilePredicate hasLang = sensorContext.fileSystem().predicates().hasLanguage(languageKey);
        FilePredicate hasType = sensorContext.fileSystem().predicates().hasType(type);
        FilePredicate langAndType = sensorContext.fileSystem().predicates().and(hasLang, hasType);
        final Charset charset = sensorContext.fileSystem().encoding();

        for (InputFile inf : sensorContext.fileSystem().inputFiles(langAndType)) {

            // Visit source files
            try {
                antlrContext.loadFromFile(inf, charset);
                ParseTreeItemVisitor visitor = new CustomTreeVisitor(visitors);
                visitor.fillContext(sensorContext, antlrContext);
            } catch (IOException e) {
                LOGGER.warn("Unexpected error while analyzing file " + inf.filename(), e);
            }

        }

    }
}
