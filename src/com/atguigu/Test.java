package com.atguigu;

import net.qiyuesuo.sdk.SDKClient;
import net.qiyuesuo.sdk.api.ContractService;
import net.qiyuesuo.sdk.bean.contract.ContractDetail;
import net.qiyuesuo.sdk.bean.sign.Signatory;
import net.qiyuesuo.sdk.common.json.JSONUtils;
import net.qiyuesuo.sdk.impl.ContractServiceImpl;

public class Test {

	 public static String url = "http://172.16.8.157:9182";
	    public static String accessKey = "YjImR0Dd5P";
	    public static String accessSecret = "o3JrPkTo31juQZ3waag9BtGvdxHp6D";
	    
	public static void main(String[] args) throws Exception {
		   SDKClient client = new SDKClient(url, accessKey, accessSecret);
	        ContractService contractService = new ContractServiceImpl(client);
	        Signatory signatoryBuy = new Signatory();
	        //方法调用
	        ContractDetail contractDetail = contractService.detail(2724188189669622134L);
	        System.out.println(contractDetail.getSignatories().get(0).getAuthMode().toString());
	       // System.out.println(JSONUtils.toJson(contractDetail));

	}

}
