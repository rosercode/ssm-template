package cool.wangshuo.template;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author wangshuo
 * @date 2023/4/30 21:02
 * 文件上传测试 <br>
 */

public class FileUploadTest {


    private String api1 = "http://127.0.0.1:9633/api/upload/test1";
    private String api2 = "http://127.0.0.1:9633/api/upload/test2";


    @Test
    public void test1() {
        fileUploadClient(api2, "imageFile", "1.jpg");
    }


    @Test
    public void test2() {
        fileUploadClient(api1, "imageFile", "1.jpg");
    }


    public void fileUploadClient(String url, String name, String file_path){
        try {
            // 创建连接
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setDoOutput(true);

            // 设置请求方法为POST
            con.setRequestMethod("POST");

            // 设置请求头信息
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // 设置请求参数
            String boundary = "===" + System.currentTimeMillis() + "===";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            // 构建请求体
            OutputStream out = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
            writer.append("--" + boundary).append("\r\n");
            writer.append("Content-Disposition: form-data; name=\"" + name+ "\"; filename=\"" + file_path + "\"").append("\r\n");
            writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(file_path)).append("\r\n");
            writer.append("Content-Transfer-Encoding: binary").append("\r\n");
            writer.append("\r\n");
            writer.flush();
            FileInputStream fileInputStream = new FileInputStream(new File(file_path));
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            fileInputStream.close();
            writer.append("\r\n").flush();
            writer.append("--" + boundary + "--").append("\r\n").flush();

            // 获取响应状态码
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            // 读取响应内容
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 打印响应结果
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
