package com.qzb.msg.service.common;

import com.alibaba.fastjson.JSONObject;
import com.qzb.msg.service.pojo.common.OkResult;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * OkService.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-23 21:56:17
 */
@Slf4j
@Service
public class OkService {

    /**
     * post 请求.
     *
     * @param url   url
     * @param requestBody requestBody
     * @return  return
     */
    public OkResult post(final String url, final Object requestBody) {
        String bodyJson = JSONObject.toJSONString(requestBody);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), bodyJson);
        Request request = new Request.Builder()
                .headers(Headers.of(new HashMap<>()))
                .url(url)
                .post(body)
                .build();
        Call call = new OkHttpClient()
                .newBuilder()
                .callTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .build()
                .newCall(request);
        OkResult okResult = new OkResult(404, "404接口报错");
        try {
            Response response = call.execute();
            okResult.setCode(response.code());
            okResult.setBody(response.body().string());
        } catch (IOException e) {
            log.error("接口请求报错：", e);
            okResult.setBody("接口请求报错");
        }
        return okResult;
    }

}
