package com.qwc.sample.web.dao;

import com.qwc.sample.web.model.Hello;
import org.springframework.stereotype.Repository;

/**
 * @author GeekQWC
 */
@Repository
public interface HelloMapper {
    Hello query();
}
