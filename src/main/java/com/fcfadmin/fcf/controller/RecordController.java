package com.fcfadmin.fcf.controller;

import com.fcfadmin.fcf.model.RecordDto;
import com.fcfadmin.fcf.model.Requirement;
import com.fcfadmin.fcf.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping()
    public List<RecordDto> getRecordsBySimilarity(@RequestBody Requirement requirement) {
        return this.recordService.getRecordsBySimilarity(requirement.getRecord(), requirement.getWeights());
    }
}
