package io.ecocode.ios.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.sonar.api.batch.fs.InputFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public abstract class AntlrContext {

    private InputFile file;
    private CommonTokenStream stream;
    private ParseTree root;
    private SourceLine[] lines;

    public void loadFromFile(InputFile file, Charset charset) throws IOException {
        loadFromStreams(file, file.inputStream(), file.inputStream(), charset);
    }

    public abstract void loadFromStreams(InputFile inputFile, InputStream file, InputStream linesStream,
                                         Charset charset) throws IOException;

    public SourceLine[] getLines() {
        return lines;
    }

    public Token[] getTokens() {
        return this.stream.getTokens().toArray(new Token[0]);
    }

    public int[] getLineAndColumn(final int global) {

        for (final SourceLine line : this.lines) {
            if (line.getEnd() > global) {
                return new int[]{line.getLine(), global - line.getStart()};
            }
        }
        return new int[0];
    }

    public InputFile getFile() {
        return file;
    }

    protected void setFile(InputFile file) {
        this.file = file;
    }

    public CommonTokenStream getStream() {
        return stream;
    }

    public ParseTree getRoot() {
        return root;
    }

    protected void setStream(CommonTokenStream stream) {
        this.stream = stream;
    }

    protected void setRoot(ParseTree root) {
        this.root = root;
    }

    protected void setLines(SourceLine[] lines) {
        this.lines = lines;
    }
}
