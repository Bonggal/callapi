/**
 * Alipay.com Inc.
 * Copyright (c) 2004‐2020 All Rights Reserved.
 */
package com.example.callapi;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.InputStream;

/**
 * @author Bonggal Siahaan (bonggal.siahaan@dana.id)
 * @version $Id: Main.java, v 0.1 2020‐08‐25 08.56 bonggalsiahaan Exp $$ */
public class Main {
    public static void main(String[] args) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(3000)
                    .setSocketTimeout(3000)
                    .build();
            HttpPost http =  new HttpPost("https://api.line.me/v2/bot/message/push");
            http.setHeader("Content-Type", "application/json");
            http.setHeader("Authorization", "Bearer XnCBwik9VIpEiUQ7Aj7C5MleJWtGRNIjQCeFREMfmEJtHRtkNVFh7Nwp4DMKwbrIdynToBeDCXDK4x4NLaxjUH/hPGnoL1YS6Yp5PVJtwiAK9flD0be2Jkhn4nv42OGXT70IIPoLNHsfM9A0mEkdwZ1uVqf4Zpty/byVYiReBuM=");
            String bodyMessage= "{\n" +
                    "  \"messages\": [\n" +
                    "    {\n" +
                    "      \"altText\": \"Test - manual from postman by Bonggal-123\",\n" +
                    "      \"contents\": {\n" +
                    "        \"footer\": {\n" +
                    "          \"layout\": \"vertical\",\n" +
                    "          \"contents\": [\n" +
                    "            {\n" +
                    "              \"color\": \"#118eea\",\n" +
                    "              \"action\": {\n" +
                    "                \"label\": \"See transaction detail\",\n" +
                    "                \"type\": \"uri\",\n" +
                    "                \"uri\": \"https://liff.line.me/1654276026-EzD1k1QQ/m/line?action=transaction&bizOrderId=2020070310121420010100166761600169253\"\n" +
                    "              },\n" +
                    "              \"style\": \"link\",\n" +
                    "              \"type\": \"button\"\n" +
                    "            }\n" +
                    "          ],\n" +
                    "          \"type\": \"box\"\n" +
                    "        },\n" +
                    "        \"hero\": {\n" +
                    "          \"size\": \"full\",\n" +
                    "          \"aspectRatio\": \"2:1\",\n" +
                    "          \"aspectMode\": \"cover\",\n" +
                    "          \"type\": \"image\",\n" +
                    "          \"url\": \"https://a.m.dana.id/resource/imgs/sendmoney/line/sent.png\"\n" +
                    "        },\n" +
                    "        \"type\": \"bubble\",\n" +
                    "        \"body\": {\n" +
                    "          \"layout\": \"vertical\",\n" +
                    "          \"contents\": [\n" +
                    "            {\n" +
                    "              \"contents\": [\n" +
                    "                {\n" +
                    "                  \"weight\": \"bold\",\n" +
                    "                  \"text\": \"This is Test bubble chat from bonggal\\n\\n\",\n" +
                    "                  \"type\": \"span\"\n" +
                    "                },\n" +
                    "                {\n" +
                    "                  \"color\": \"#ff0000\",\n" +
                    "                  \"text\": \"Test - manual from postman by Bonggal\",\n" +
                    "                  \"type\": \"span\"\n" +
                    "                }\n" +
                    "              ],\n" +
                    "              \"type\": \"text\",\n" +
                    "              \"wrap\": true\n" +
                    "            }\n" +
                    "          ],\n" +
                    "          \"type\": \"box\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      \"type\": \"flex\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"to\": \"U608458010a280badf2db31ff45dbaa82\"\n" +
                    "}";
            StringEntity entity = new StringEntity(bodyMessage, ContentType.create("application/json", "UTF-8"));
            http.setEntity(entity);
            http.setConfig(requestConfig);

            CloseableHttpResponse response = httpclient.execute(http);
            System.out.println(response.getStatusLine());
            InputStream is = response.getEntity().getContent();
            System.out.println(IOUtils.toString(is));
            response.close();
            httpclient.close();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}