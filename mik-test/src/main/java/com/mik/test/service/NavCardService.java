package com.mik.test.service;

import com.mik.test.mapper.NavCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavCardService {

    @Autowired
    NavCardMapper navCardMapper;

}
