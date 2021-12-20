package com.gitee.freakchicken.dbapi.service;

import com.gitee.freakchicken.dbapi.dao.IPMapper;
import com.gitee.freakchicken.dbapi.util.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IPService {

    @Autowired
    IPMapper ipMapper;

    @Transactional
    public void on(String mode, String ip) {
        ipMapper.turnOn(mode);
        ipMapper.saveIP(ip, mode);
        Cache.status = null;
    }

    @Transactional
    public void off() {
        ipMapper.turnoff();
        Cache.status = null;
    }

    public Map<String, String> detail() {
        if (Cache.status == null) {
//            log.info("sql 查询 ipRules");
            List<Map<String, String>> ipRule = ipMapper.getIPRule();
            Map<String, String> status = ipMapper.getStatus();
            ipRule.stream().forEach(t -> {
                String type = t.get("type");
                String ip = t.get("ip");
                if (type.equals("white")) {
                    status.put("whiteIP", ip);
                } else if (type.equals("black")) {
                    status.put("blackIP", ip);
                }
            });
            // set cache
            Cache.status = status;
//            log.info("set cache");
            return status;
        } else {
//            log.info("get from cache");
            return Cache.status;
        }
    }

    public boolean check(String mode, String ipList, String originIp) {
        String[] items = ipList.split("\n");
        Set<String> set = Arrays.asList(items).stream().map(t -> t.trim())
                .filter(t -> StringUtils.isNoneBlank(t)).collect(Collectors.toSet());

        if (mode.equals("black")) {
            if (set.contains(originIp)) {
                return false;
            } else
                return true;
        } else if (mode.equals("white")) {
            if (set.contains(originIp)) {
                return true;
            } else
                return false;
        }
        return false;
    }
}
