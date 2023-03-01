package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(path = "/test",produces = "application/json")
	@CrossOrigin
	public  RefererResponse test(@RequestHeader("referer")String referer){
		System.out.println("received from :: "+referer);
		return new RefererResponse(referer);
	}

	public static class RefererResponse{

		RefererResponse(String referer){
			this.referer = referer;
		}
		private String referer;

		public void setReferer(String referer) {
			this.referer = referer;
		}

		public String getReferer() {
			return referer;
		}
	}
}
