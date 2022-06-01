package com.mik.test.controller;

import com.mik.test.service.NavCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class NavCardController {

    @Autowired
    NavCardService navCardService;

}
