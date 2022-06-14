package com.mik.nav.service;

import com.mik.nav.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;



}
