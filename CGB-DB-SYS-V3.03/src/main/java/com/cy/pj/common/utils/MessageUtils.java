package com.cy.pj.common.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MessageUtils {
	public static void SendMessage(Throwable t) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G2MMBgtcYn15qaJCiE1", "W3TedlbDHxLCJpYUpj4GdRYg7cWXjr");
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
		request.setSysDomain("dysmsapi.aliyuncs.com");
		request.setSysVersion("2017-05-25");
		request.setSysAction("SendSms");
		request.putQueryParameter("RegionId", "cn-hangzhou");
		request.putQueryParameter("PhoneNumbers", "15205698133");
		request.putQueryParameter("SignName", "ABC商城");
		request.putQueryParameter("TemplateCode", "SMS_202812794");
		request.putQueryParameter("TemplateParam", "{\"code\":\"" + t.getMessage()+"\"}");
		try {
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}

