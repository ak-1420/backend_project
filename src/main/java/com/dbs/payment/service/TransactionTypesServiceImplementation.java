package com.dbs.payment.service;

import com.dbs.payment.entity.TransferTypes;
import com.dbs.payment.repository.TransferTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypesServiceImplementation implements TransactionTypesService{

    @Autowired
    private TransferTypesRepository transferTypesRepository;

    @Override
    public TransferTypes addTransferTypes(TransferTypes transferTypes) {
        return transferTypesRepository.save(transferTypes);
    }

    @Override
    public List<TransferTypes> fetchAllTransferTypes() {
        return transferTypesRepository.findAll();
    }

    @Override
    public Optional<TransferTypes> fetchTransferTypes(String transferTypeCode) {
        return transferTypesRepository.findById(transferTypeCode);
    }

    @Override
    public Optional<TransferTypes> updateTransferType(String transferTypeCode, TransferTypes transferTypes) {
        Optional<TransferTypes> oTT = transferTypesRepository.findById(transferTypeCode);
        if(oTT.isPresent()){
            TransferTypes tt = oTT.get();
            tt.setTransferTypeDescription(transferTypes.getTransferTypeDescription());
            transferTypesRepository.save(tt);
        }
        return transferTypesRepository.findById(transferTypeCode);
    }

    @Override
    public String deleteTransferTypes(String transferTypeCode) {
        Optional<TransferTypes> oTT = transferTypesRepository.findById(transferTypeCode);
        if(oTT.isPresent()){
            transferTypesRepository.deleteById(transferTypeCode);
            return "record deleted successfully!";
        }
        return "unable to delete the record!";
    }
}
