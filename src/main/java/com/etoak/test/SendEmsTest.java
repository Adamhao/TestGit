package com.etoak.test;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2018/11/12 18:58.
 */
public class SendEmsTest {

    private static String url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    public static void main(String[] args) {

        try {
            sendEms("238479","17685811854");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();

        }

    }

    /**
     *
     * @param content 短信内容
     * @param mobile 接受验证码的手机号
     */
    public static void sendEms(String content,String mobile) throws IOException, DocumentException {

        if(content == null || mobile == null) {
            return;
        }

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost post = new HttpPost(url);

        //请求值或返回值的编码格式

        {
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("account", "C22826040"));
            list.add(new BasicNameValuePair("password", "df4f5bc5159f14331ba66904b55a32ec"));
            list.add(new BasicNameValuePair("content", "您的验证码是：" + content + "。请不要把验证码泄露给其他人。"));
            list.add(new BasicNameValuePair("mobile", mobile));
            //list.add(new BasicNameValuePair("format","json"));

            HttpEntity entity = new UrlEncodedFormEntity(list, Consts.UTF_8);

            post.setEntity(entity);
        }



        CloseableHttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();

        //判断服务端是否成功相应
        if(statusCode == HttpStatus.SC_OK) {

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity,"UTF-8");

            //System.out.println(result);

            Document doc = DocumentHelper.parseText(result);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }

        }


    }
}
