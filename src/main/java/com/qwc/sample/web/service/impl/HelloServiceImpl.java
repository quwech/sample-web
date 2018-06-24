package com.qwc.sample.web.service.impl;

import com.qwc.sample.web.dao.HelloMapper;
import com.qwc.sample.web.model.Hello;
import com.qwc.sample.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GeekQWC
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    HelloMapper helloMapper;

    @Override
    public Hello query() {
        return helloMapper.query();
    }
}
