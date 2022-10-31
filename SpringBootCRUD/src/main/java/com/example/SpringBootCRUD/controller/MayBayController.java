package com.example.SpringBootCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUD.entity.MayBay;
import com.example.SpringBootCRUD.repository.MayBayRepository;

@RestController
@RequestMapping("/api")
public class MayBayController {

	@Autowired
	private MayBayRepository MayBayRepository;
	
	@GetMapping("/maybay/maybaytambay10k")
    public List<MayBay> getMayBayHon10000(){
        return MayBayRepository.findMayBayCoTamBayLonHon10k();
    }
}
