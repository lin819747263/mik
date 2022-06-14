package com.mik.nav.service;

import com.mik.nav.mapper.NavCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavCardService {

    @Autowired
    NavCardMapper navCardMapper;

}
