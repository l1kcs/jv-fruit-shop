package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input list cannot be null");
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");
            FruitTransactionService transactionService = new FruitTransactionServiceImpl();
            transactionService.createTransaction(Operation.fromCode(data[0].trim()),
                    data[1].trim(),
                    Integer.parseInt(data[2].trim()));
        }
        return Storage.getRecords();
    }
}
