package com.ypl.test.common.util.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author admin
 */
public class HttpUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    public static String sendHttps(Map<String, String> param, String requestUrl) throws Exception {
        CloseableHttpClient httpClient = createSSLClientDefault();
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        UrlEncodedFormEntity urlEntity;
        try {
            httpPost = new HttpPost(requestUrl);
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            urlEntity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);

            httpPost.setEntity(urlEntity);
            httpPost.setConfig(RequestConfig.custom().setConnectTimeout(30000)
                    .setSocketTimeout(30000).build());
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            int statusCode = response.getStatusLine().getStatusCode();
            // 如果响应码是200
            if (HttpStatus.SC_OK == statusCode) {
                return EntityUtils.toString(entity);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
            httpClient.close();
        }
        return null;
    }

    /**
     * 创建链接
     */
    public static CloseableHttpClient createSSLClientDefault() throws Exception {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,
                new HttpUtil.AllTrustStrategy()).build();
        SSLConnectionSocketFactory sslSf = new SSLConnectionSocketFactory(
                sslContext);
        return HttpClients.custom().setSSLSocketFactory(sslSf).build();
    }

    /**
     * 生成请求URL
     *
     * @param parameters
     * @return
     */
    public static String buildUriStr(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    /**
     * 加载证书
     */
    private static class AllTrustStrategy implements TrustStrategy {

        @Override
        public boolean isTrusted(X509Certificate[] x509Certificates, String s)
                throws CertificateException {
            return true;
        }
    }

}
