package com.xuxl.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuxl.redis.util.RedisUtil;


@RestController
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class) ;

	
	@Autowired
	RedisUtil redisUtil;
	
	/**
	 * Redis get 
	 * @return
	 */
	@GetMapping("/getRedis")
	public String testGet(@RequestParam String key){
		
		Object o = redisUtil.get(key);
		return o!=null?o.toString():"";
	}
	
	/**
	 * Redis set 
	 * @return
	 */
	@GetMapping("/setRedis")
	public String testSet(@RequestParam String key,@RequestParam String value){
		
		redisUtil.set(key, value);
		Object o = redisUtil.get(key);
		return o!=null?o.toString():"";
	}
}
