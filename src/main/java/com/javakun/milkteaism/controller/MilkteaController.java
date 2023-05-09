package com.javakun.milkteaism.controller;

import com.javakun.milkteaism.model.Milktea;
import com.javakun.milkteaism.service.MilkteaService;
import com.javakun.milkteaism.utils.ExcelExport;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MilkteaController {
    @Autowired
    private MilkteaService milkteaService;

    @GetMapping("/getAllMilktea")
    public ResponseEntity<List<Milktea>> getAllMilktea() {
        return new ResponseEntity<>(milkteaService.getAllMilktea(), HttpStatus.OK);
    }

    @PostMapping("/addMilktea")
    public ResponseEntity<Milktea> saveMilktea(@RequestBody Milktea milktea) {
        return new ResponseEntity<>(milkteaService.addMilktea(milktea) , HttpStatus.CREATED);
    }

    @GetMapping("/getMilktea")
    public ResponseEntity<Page<Milktea>> getMilktea(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "milkteaId")  String sort) {
        return new ResponseEntity<>(milkteaService.findMilkteaByMilkteaId(page,size, sort), HttpStatus.OK);
    }

    @PostMapping("/export")
    public void exportToExcel(HttpServletResponse response) {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Milktea> listMilktea = milkteaService.getAllMilktea();

        ExcelExport excelExport = new ExcelExport(listMilktea);

        excelExport.export(response);
    }
}
