package com.adam.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092300575689";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKaJcTATnjN6aihbmE+4wyX6O7CGjkWsibEbb8ASmLfn2lVS6AYafu2a2lYFeC91zBRdlwY2Mo2oShUp9fCsn4l24rk3Q86gbqI4GLwLh1//j+yYA9nn9w+eBA7PyzIDutpvWUfIK9zhZm6dU6qlqDIoYk8jn6Cda7y7F4oqp0IHUix3RwFCmBeEdDq8ZSMpRYny04ZqkdGUMkZxrORTO6EcHSqRikQ1FHXS3ud2wCRSwRDTlWBl1ZZcr9toyN0eP49BHBpN+bwyGm4PcKLql/VPi30yFVtOttkbvg9FH2nCpfuXoB9TsvdxPfxCpxwYCo4hG31QsaTG/EcPRQRIztAgMBAAECggEAJbiNe9N4uFEha+ewAOshcVUZZU7Mb3fCdmikixex/99wVM/bRYfX4cOXjJuuHfZWZCIqOXQMwUSUovbGknt5QfPbRasBIdzSF5unobPbUeV6Mc4u0hxRNTQUhv1PfW4KdbAr+9TXOO1is5eE0mE9G8Ib9xPA80EdMb841dzXQaBx57JKYEeakOsBlimG21faNPdklqXCikYG2GnogGIg5sN+T2kkkrfdyWPTIfkv+JCKFiV1aA245/vBa1XIMPXYLXglAXFeboR9BHqJudY5EGfsqJE8tTzqfl0h/5sjnyEdxzIkYq7ulDWC5HNK2XBuitKoORL3Up+KHHO3kzrwAQKBgQDpvnCJo517TPv9vupzVj4cp6Ki7aRKG54W1UtddwjDRsDlviCGcysUoLOPI552BqRoRbGjbv7NcUVPAjRtUmR/MwivYjbgTF1te7kUL7FoSyfycsYPMfr7FL3NRykNdtMsY3ulxi+5ljXcRM3DqllTCAYSSo+AhMRJMisTtvW47QKBgQCXllRzbRQSg3dHG7UrabTHUDASyKA2js9ONt/8qMutn/UKw4vL041FrVU8J/4RzoAtQqgzivBUPjrAMQKYOEmz5o0GIdJM/wFSojYWTaBQfO4Ldyy6cayORvlzTGxLY7JGmw0eFEBK36RxRGOdKWz3N417QK3kvnRKAJ/b4lOkAQKBgFQwgK5CnTVM/DJf8mgKdyKxCnYurA75NY650oRenGxhbpcRTPvAPZMXcrUquid+qvbXq2zXTLVIiBM2ExYRKBtckVNCR8uwFbKaboYjy31qHIBJ8KaGdQS8asSmTdYIp3UEfAOwh34L6Whl68r+719ls3IhIuDCcUR/6l4WdxjdAoGAWFmI7SF1Ink3Kt2uURgyAjztV/VQ05uWndqD3+mtlIt3MYfZUboCS8sDs6UHgu9da4O/LxNakW8XpO6ruXaNFmpYZWuO+8tgxP3AEm25809tGoeiLSSV0vLw7s9rCuGXhWlXUuGwuzLv0AhxGqeLV+cr8ds3vut2Ma99fJXD9AECgYEAhITb1jw6X11ZTpdfTRrv5zXPOGmVYFifD+dEJzTGw0CdifZktCJJogrqRHzheCGC19EXTMCSjMYAcpsHXqunDtwAtkJvevGoFUfcgvvZNk36XCJ3hjazonn5ADzwsBWFUflMJfiRxl1ST9mmCx30iIiAeKcMf7/cnlg1+UdfX1U=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3CRzvOgPl3CcHmKo5ZxeVsO46fZ/rqoP3IAMnsgZBtyp+lgnv8SVxWiM6q78boiraU+sUEYsxSpACoPvM3QKh2VHiEuPMEse/klV1+S6WW399cZ1jo2LDG7hkCkgP8yqyGnngZSOsg/BFdqx94tortyzQQFb/1fRb/1bXXsH2AQTiN2qiWA1d4zT2E+6yNfrK4AcrGDCGzNtfaK9jU73Xhfu9AoIyHfg3Z/tbD44eMyYkKxcmg1Q9ev1r/0NxVVo5dP0rSjqkzDqCKpb2pv4x3pjQrNcZu3fLtmAhMHI2UMr3aH2Lf0P4fhlXNll4hXdd+3CMDRCSnSLgkP2a/qJAwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\test";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


