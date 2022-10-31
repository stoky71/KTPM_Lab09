package com.example.SpringBootCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUD.entity.ChuyenBay;
import com.example.SpringBootCRUD.repository.ChuyenBayRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/api/redis")
public class ChuyenBayController {

	@Autowired
	private ChuyenBayRepository ChuyenBayRepository;
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		@GetMapping("/chuyenbay")
		public List<ChuyenBay> listChuyenBays() {
	//		return chuyenBayImpl.listChuyenBay();
			return ChuyenBayRepository.findAll();
		}
	 	@GetMapping("/chuyenbay/dad")
	    public List<ChuyenBay> getChuyenBayTuDAD(){
	        return ChuyenBayRepository.findChuyenBaystoGaDiDAD();
	    }

	    @GetMapping("/chuyenbay/doadai8to10")
	    public List<ChuyenBay> getChuyenBayDoDaiTu8To10(){
	        return ChuyenBayRepository.findChuyenBayDoDaiHon8VaNhoHon10();
	    }
	    @GetMapping("/chuyenbay/{id}")
	    public ResponseEntity<ChuyenBay> getMayBayByMaCB(@PathVariable("id") String macb) throws Exception{
	    	ChuyenBay chuyenBay = ChuyenBayRepository.findById(macb)
	    			.orElseThrow(() -> new Exception("Không có mã chuyến bay"+macb));
	    	System.out.println("Chuyến bay có mã là" + macb + ":\n" + gson.toJson(chuyenBay));
	    	return ResponseEntity.ok().body(chuyenBay);
	    }
	    @PostMapping("/chuyenbay/")
		public ChuyenBay createChuyenBay(@RequestBody ChuyenBay chuyenBay) {
			return  ChuyenBayRepository.save(chuyenBay);
		}
	    @PutMapping("/chuyenbay/{id}")
	    public ResponseEntity<ChuyenBay> updateChuyenbay(@PathVariable("id") String macb, @RequestBody ChuyenBay chuyenBayDetails) throws Exception{
	    	ChuyenBay chuyenBay = ChuyenBayRepository.findById(macb)
	    			.orElseThrow(() -> new Exception("Không tìm thấy chuyến bay có mã " + macb));
	    	chuyenBay.setMacb(chuyenBayDetails.getMacb());
	    	chuyenBay.setGadi(chuyenBayDetails.getGadi());
	    	chuyenBay.setGaden(chuyenBayDetails.getGaden());
	    	chuyenBay.setDodai(chuyenBayDetails.getDodai());
	    	chuyenBay.setGiodi(chuyenBayDetails.getGiodi());
	    	chuyenBay.setGioden(chuyenBayDetails.getGioden());
	    	chuyenBay.setChiPhi(chuyenBayDetails.getChiPhi());
	    	ChuyenBayRepository.save(chuyenBay);
	    	
	    	System.out.println("Cập nhật thành công thông tin chuyến bay có macb là" +macb+":\n" +gson.toJson(chuyenBay));
	    	return ResponseEntity.ok().body(chuyenBay);
	    }
	    @DeleteMapping("/chuyenbay/{id}")
	    public ResponseEntity<ChuyenBay> deleteChuyenBay(@PathVariable("id") String macb) throws Exception{
	    	ChuyenBayRepository.findById(macb)
	    			.orElseThrow(() -> new Exception("Không tìm thấy chuyến bay có mã " + macb));
	    	ChuyenBayRepository.deleteById(macb);
	    	System.out.println("Xóa thành công chuyến bay có mã là" +macb);
	    	return ResponseEntity.ok().build();
	    }
}
