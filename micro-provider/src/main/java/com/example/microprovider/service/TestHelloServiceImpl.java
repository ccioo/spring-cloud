package com.example.microprovider.service;

import com.example.api.DubboService;
import com.example.microcommon.exception.UserException;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wen.yang
 */
@RestController
public class TestHelloServiceImpl implements DubboService {

    @Override
    public String testAccess() {
        throw new UserException("业务异常啦");
    }
}
