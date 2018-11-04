package nuc.bsd.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.io.codec.Base64;

import nuc.bsd.report.Impl.PdfReport;

public class EChartsUtil {
	private static String url = "http://localhost:9090";
	private static final Logger logger = LoggerFactory.getLogger(EChartsUtil.class);
	public static boolean generateEChartsImage(String optJson, String outFile) {
		boolean isSuccess = true;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("opt", optJson);
						String post = post(url, map, "utf-8");
			JSONObject myJsonObject = new JSONObject(post);
			if(myJsonObject.getInt("code")==1) {
				logger.info("图表服务器生成成功");
				isSuccess = GenerateImage(myJsonObject.getString("data"), outFile);
			}else {
				isSuccess = false;
				logger.error("图表服务器生成失败"+myJsonObject.getString("msg"));
			}
		} catch (ParseException e) {
			isSuccess = false;
			logger.error("上传的json字符串解析失败:"+optJson);
		
		} catch (IOException e) {
			isSuccess = false;
			logger.error("图表服务器连接失败:"+e.getMessage());
			
		}

		return isSuccess;
	}

	private static String post(String url, Map<String, String> map, String encoding)
			throws ParseException, IOException {
		String body = "";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
		CloseableHttpResponse response = client.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			body = EntityUtils.toString(entity, encoding);
		}
		EntityUtils.consume(entity);
		response.close();
		return body;
	}

	private static boolean GenerateImage(String imgStr, String imgFilePath) {
		if (imgStr == null)
			return false;
		try {
			byte[] b = Base64.decode(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}

			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			ImageUtil.trimBlank(imgFilePath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
