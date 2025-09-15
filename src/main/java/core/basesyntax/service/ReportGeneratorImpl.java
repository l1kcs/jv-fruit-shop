package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        if (Storage.getFruits() == null || Storage.getFruits().isEmpty()) {
            return HEADER;
        }
        return HEADER + System.lineSeparator()
                + Storage.getFruits().entrySet().stream()
                        .map(fruit
                                -> fruit.getKey() + "," + fruit.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
