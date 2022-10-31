package com.example.SpringBootCRUD.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootCRUD.entity.ChuyenBay;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@RestController
@RequestMapping("/api/resttemplate")
public class RestTemplateController {

	@Autowired
	private RestTemplate restTemplate;
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@GetMapping("/chuyenbay")
	public List<Object> getChuyenBays() {
		String url="http://localhost:8081/api/chuyenbay";
		
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		System.out.println("Danh sách chuyến bay:\n" +gson.toJson(Arrays.asList(objects)));
		return Arrays.asList(objects);
	}
	@GetMapping("/chuyenbay/{id}")
	public List<Object> getChuyenBaysById(@PathVariable("id") String macb) {
		String url="http://localhost:8081/api/chuyenbay" + macb;
		
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		System.out.println("Chuyến bay" + macb + ":\n" +gson.toJson(Arrays.asList(objects)));
		return Arrays.asList(objects);
	}
	@PostMapping("/chuyenbay")
	public String createChuyenBay(@RequestBody ChuyenBay chuyenBay) {
		HttpEntity<ChuyenBay> createChuyenBay = new HttpEntity<>(chuyenBay);
		System.out.println("Thêm thành công chuyến bay:\n" + gson.toJson(createChuyenBay.getBody()));
		return restTemplate.exchange("http://localhost:8081/api/chuyenbay/add", HttpMethod.POST, createChuyenBay, String.class).getBody();
	}
	@PutMapping("/chuyenbay/{id}")
	public void updateChuyenbay(@PathVariable("id") String macb, @RequestBody ChuyenBay chuyenBay) {
		String url="http://localhost:8081/api/chuyenbay" + macb;
		restTemplate.put(url, chuyenBay);
	}
	@DeleteMapping("/chuyenbay/{id}")
	public void deleteChuyenbay(@PathVariable("id") String macb) {
		String url="http://localhost:8081/api/chuyenbay" + macb;
		restTemplate.delete(url);
	}
}
