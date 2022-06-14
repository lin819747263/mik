package com.mik.nav;

import com.mik.cache.template.RedisRepository;
import com.mik.core.model.CommonResult;
import com.mik.log.annotation.AuditLog;
import com.mik.nav.mapper.StudentMapper;
import com.mik.nav.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RedisRepository redisRepository;

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/hello")
    @AuditLog(operation = "hello")
    public CommonResult<String> hello(){
        return CommonResult.success("hello");
    }

//    @GetMapping("error")
//    public String error() {
//        throw new ServiceException("1" ,"666");
//    }

    @GetMapping("cache")
    public void cache() {
        redisRepository.getRedisTemplate().opsForValue().set("test", "test");
    }

    @GetMapping("newStu")
    public void newStu(){
        studentMapper.insert(new Student().setName("小明").setAge(20));
    }
}
