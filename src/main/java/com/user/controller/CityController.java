package com.user.controller;

import com.user.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Turgay.Can on 2017-02-14.
 */
@Controller
public class CityController {

        @Autowired
        private CityService cityService;

        @GetMapping("/")
        @ResponseBody
        @Transactional(readOnly = true)
        public String helloWorld() {
            return this.cityService.getCity("Bath", "UK").getName();
        }

    }