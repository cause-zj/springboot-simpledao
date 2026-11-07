package com.cause.service;

import com.cause.dao.DemoItemDao;
import com.cause.domain.DemoItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoItemService {

    private final DemoItemDao demoItemDao;

    public DemoItemService(DemoItemDao demoItemDao) {
        this.demoItemDao = demoItemDao;
    }

    public List<DemoItem> list() {
        return demoItemDao.listActive();
    }
}
