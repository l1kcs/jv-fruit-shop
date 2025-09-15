package core.basesyntax.io;

import core.basesyntax.service.ReportGenerator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(ReportGenerator reportGenerator, File output) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(output))) {
            bufferedWriter.write(reportGenerator.getReport());
        } catch (IOException e) {
            throw new RuntimeException("can't reach file " + output, e);
        }
    }
}
