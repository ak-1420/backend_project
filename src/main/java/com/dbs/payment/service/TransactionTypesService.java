package com.dbs.payment.service;

import com.dbs.payment.entity.TransferTypes;

import java.util.List;
import java.util.Optional;

public interface TransactionTypesService {
    TransferTypes addTransferTypes(TransferTypes transferTypes);

    List<TransferTypes> fetchAllTransferTypes();

    Optional<TransferTypes> fetchTransferTypes(String transferTypeCode);

    Optional<TransferTypes> updateTransferType(String transferTypeCode, TransferTypes transferTypes);

    String deleteTransferTypes(String transferTypeCode);
}
