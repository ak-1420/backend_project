package com.dbs.payment.controller;

import com.dbs.payment.entity.TransferTypes;
import com.dbs.payment.repository.TransferTypesRepository;
import com.dbs.payment.service.TransactionTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transfer-types")
public class TransferTypesController {

    @Autowired
    private TransactionTypesService transactionTypesService;

    @PostMapping("/add")
    public TransferTypes addTransferTypes(@RequestBody TransferTypes transferTypes){
        return transactionTypesService.addTransferTypes(transferTypes);
    }

    @GetMapping("/all")
    public List<TransferTypes> fetchAllTransferTypes(){
        return transactionTypesService.fetchAllTransferTypes();
    }

    @GetMapping("/{transferTypeCode}")
    public Optional<TransferTypes> fetchTransferTypes(@PathVariable String transferTypeCode){
       return transactionTypesService.fetchTransferTypes(transferTypeCode);
    }

    @PatchMapping("/{transferTypeCode}")
    public Optional<TransferTypes> updateTransferType(@PathVariable String transferTypeCode ,@RequestBody TransferTypes transferTypes){
        return transactionTypesService.updateTransferType(transferTypeCode , transferTypes);
    }


    @DeleteMapping("/{transferTypeCode}")
    public String deleteTransferTypes(String transferTypeCode){
        return transactionTypesService.deleteTransferTypes(transferTypeCode);
    }



}
