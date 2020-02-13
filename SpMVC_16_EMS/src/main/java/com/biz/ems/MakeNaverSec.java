package com.biz.ems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeNaverSec {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		Map<String, String> envList = System.getenv();
		
		String saltPass = envList.get("NAVER");
		
		System.out.println("SaltPass : " + saltPass);
		
		System.out.println("NAVER ID :");
		String naverID = scan.nextLine();
		
		System.out.println("Naver PASSWORD : ");
		String naverPass = scan.nextLine();
		
		System.out.println("DB User :");
		String DBUserID = scan.nextLine();
		
		System.out.println("DB PASSWORD : ");
		String DBPassword = scan.nextLine();
		
		// 암호화 설정
		
		pbEnc.setAlgorithm("PBEwithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String encNaverId = pbEnc.encrypt(naverID);
		String encNaverPass = pbEnc.encrypt(naverPass);
		String encDBUserId = pbEnc.encrypt(DBUserID);
		String encDBPassword = pbEnc.encrypt(DBPassword);
		
		System.out.printf("Naver : %s, %s\n", naverID, naverPass);
		System.out.printf("encNaver : %s, %s\n", encNaverId, encNaverPass);
		System.out.printf("DB : %s, %s\n", DBUserID, DBPassword);
		System.out.printf("encDB : %s, %s\n", encDBUserId, encDBPassword);
		
		
		String saveNaverID = String.format("naver.username=ENC(%s)" , encNaverId);
		String saveNaverPass = String.format("naver.password=ENC(%s)" , encNaverPass);
		String saveDBuserID = String.format("mysql.user=ENC(%s)" , encDBUserId);
		String saveDBPassword = String.format("mysql.password=ENC(%s)" , encDBPassword);
		
		String profileName = "./src/main/webapp/"
							+ "WEB-INF/spring/"
							+ "naver.email.secret.properties";
		
		String WEB_INF = "./src/main/webapp/WEB-INF/spring";
		String naver_pro = "naver.email.secret.properties";
		File proFile = new File(WEB_INF,naver_pro);
		
//		PrintWriter out = new PrintWriter(profileName);
		
		try {
			PrintWriter out = new PrintWriter(proFile);
			out.println(saveNaverID);
			out.println(saveNaverPass);
			out.println(saveDBuserID);
			out.println(saveDBPassword);
			
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
		
	}
	
}
















