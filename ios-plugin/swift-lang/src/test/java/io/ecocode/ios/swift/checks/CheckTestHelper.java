package io.ecocode.ios.swift.checks;

import io.ecocode.ios.swift.EcoCodeSwiftVisitor;
import io.ecocode.ios.swift.Swift;
import io.ecocode.ios.swift.antlr.ParseTreeAnalyzer;
import io.ecocode.ios.swift.antlr.SwiftAntlrContext;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.internal.DefaultInputFile;
import org.sonar.api.batch.fs.internal.TestInputFileBuilder;
import org.sonar.api.batch.sensor.internal.SensorContextTester;

import java.io.File;
import java.nio.file.Paths;

public class CheckTestHelper {

    private static final String TEST_ROOT = "src/test/resources";
    private static final int LINE_COUNT = 100;

    public static SensorContextTester analyzeTestFile(String relativePath) {
        SensorContextTester context = SensorContextTester.create(new File(TEST_ROOT));
        DefaultInputFile testFile = new TestInputFileBuilder("", relativePath)
                .setType(InputFile.Type.MAIN)
                .setLines(LINE_COUNT)
                .setOriginalLineEndOffsets(new int[LINE_COUNT])
                .setOriginalLineStartOffsets(new int[LINE_COUNT])
                .setModuleBaseDir(Paths.get(TEST_ROOT))
                .setLanguage("swift").build();
        context.fileSystem().add(testFile);

        final SwiftAntlrContext antlrContext = new SwiftAntlrContext();
        new ParseTreeAnalyzer(Swift.KEY, InputFile.Type.MAIN, antlrContext, context)
                .analyze(new EcoCodeSwiftVisitor());

        return context;
    }
}
