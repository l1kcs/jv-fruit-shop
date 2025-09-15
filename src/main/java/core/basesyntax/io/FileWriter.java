package core.basesyntax.io;

import core.basesyntax.service.ReportGenerator;
import java.io.File;

public interface FileWriter {
    void write(String reportGenerator, File output);
}
