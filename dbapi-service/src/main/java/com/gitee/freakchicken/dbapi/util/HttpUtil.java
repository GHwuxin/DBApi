package com.gitee.freakchicken.dbapi.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @program: dolphinscheduler
 * @description:
 * @author: jiangqiang
 * @create: 2020-12-10 16:58
 **/
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static JSONObject post(String url, String map) {
        JSONObject result = new JSONObject();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            StringEntity entity = new StringEntity(map);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();

            HttpEntity responseEntity = response.getEntity();
            String responseString = EntityUtils.toString(responseEntity);

//            System.out.println(responseString);
            result.put("success", true);
            result.put("data", responseString);

            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put("success", false);
            result.put("data", e.getMessage());

            return result;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
