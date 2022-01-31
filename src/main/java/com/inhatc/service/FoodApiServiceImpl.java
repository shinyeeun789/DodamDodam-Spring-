package com.inhatc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.inhatc.domain.FoodVO;
import com.inhatc.persistence.FoodApiDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class FoodApiServiceImpl implements FoodApiService {

	@Inject
	private FoodApiDAO dao;
	
	@Override
	public void parsingData(String foodInfo) throws Exception {
		
		FoodVO foodVO = new FoodVO();
		
		String[] snacks = {"����", "���ڷ�", "������ó����ǰ", "��ó����ǰ", "ĵ���", "���̽���ũ", "ȥ������", "�ٷ�(�׻���)", "����", "�ż����ǽ�ǰ",
				"������", "ź���", "���� �Ǵ� �߰��� ����ǰ", "Ŀ��", "�׻�Ŀ��", "ȥ������", "�׻���", "�����ǰ", "���ݸ�����ǰ", "��/ä����", "�� �� ä�ֽ�", "ȫ������", "����", "ź������"};
		String[] processeds = {"�Ｎ�����ǰ", "��������ǰ", "Ƣ���ǰ", "�мⰡ����","�мⰡ������ǰ","���깰����ǰ", "��Ÿ����ǰ", "�������ǰ"};
		String[] manufacturers = {"���","��⵵","ö��","�泲","�ֽ�ȸ�� ","�� : ","F1","F2","F2(��)","F2 .","F2.","F3","F-3���ȸ�����","F4","���Կ�)�� ","("};
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(foodInfo);
		
		JSONArray parse_list = (JSONArray)obj.get("list");
		
		for(int i=0; i<parse_list.size(); i++) {
			JSONObject food = (JSONObject) parse_list.get(i);
			
			// ������ �ڿ� �ּ� �ڸ���
			StringTokenizer stn = new StringTokenizer(food.get("manufacture").toString(), "-_:/|, ", true);
			String strManu = stn.nextToken();
			if (Arrays.asList(manufacturers).contains(strManu)) {
				foodVO.setManufacturer(stn.nextToken());
			} else {
				foodVO.setManufacturer(strManu);
			}
			
			String allergy = (String) food.get("allergy");
			String[] splitIngredient = {};
			if (allergy != null) {
				splitIngredient = food.get("allergy").toString().split(",");
			}
			
			foodVO.setFoodName((String) food.get("prdlstNm"));
			foodVO.setIngredient((String) food.get("allergy"));
			
			// ī�װ� �и��ϱ�
			String prdkind = (String) food.get("prdkind");
			if (Arrays.asList(snacks).contains(prdkind)) {
				foodVO.setCategory("����");
			} else if (Arrays.asList(processeds).contains(prdkind)) {
				foodVO.setCategory("������ǰ");
			} else if (prdkind.equals("����")) {
				foodVO.setCategory("��");
			} else {
				foodVO.setCategory("��Ÿ");
			}
			
			if (splitIngredient.length >= 5) {
				foodVO.setRisk(3);
			} else if (splitIngredient.length >= 3) {
				foodVO.setRisk(2);
			} else if (splitIngredient.length >= 1) {
				foodVO.setRisk(1);
			} else {
				foodVO.setRisk(0);
			}
			
			foodVO.setImage((String) food.get("imgurl1"));
			
			System.out.println(foodVO.getManufacturer() + " - " + foodVO.getFoodName());
			
			dao.insertApiFoods(foodVO);
			
		}
		
	}
	
}
