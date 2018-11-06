package nuc.bsd.report.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchProBlmRep {

	private String schoolName;
	
	private List<ClsProBlmRep> clsProBlemReps = new ArrayList<ClsProBlmRep>();
	public void addClsProBlmRep(ClsProBlmRep obj) {
		clsProBlemReps.add(obj);
		
	}
	
	

	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}



	private String r0,r1,r2,r3,r4,r5;
	private String r6,r7,r8,r9,r10;
	private String r11,r12,r13,r14,r15;
	private Map<String,List<CommonBean>> r16;
	private String r17,r18,r19,r20,r21,r22;
	public String getR0() {
		
		return schoolName;
	}
	public String getR1() {
		int result=0;
		int num = 0;
		for(ClsProBlmRep obj: clsProBlemReps) {
			result += Integer.parseInt(obj.getTestStuNum());
			num++;
		}
		//result = result/num; 
		return String.valueOf(result);
	}
	/*R11-R15的处理方式*/
	public String getR11() {
		StringBuffer sb = new StringBuffer();
		for(ClsProBlmRep obj: clsProBlemReps) {
			sb.append(obj.getTestDeficiencyList());
			
		}

		return sb.toString();
	}
	//第7页的表格处理方式
	public Map<String,List<CommonBean>> getR16() {
		Map<String,List<CommonBean>> hpBeans = new HashMap<String,List<CommonBean>>();
		for(ClsProBlmRep obj: clsProBlemReps) {
			CommonBean commonBean = new CommonBean();
			commonBean.setGradeName(obj.getGradeName());
			commonBean.setClassName(obj.getClassName());
			commonBean.setT0(Integer.parseInt(obj.getAnxiousPotentialriskNum()));
			commonBean.setT1(Integer.parseInt(obj.getAnxiousRiskNum()));
			
			String key = obj.getGradeName();
			List<CommonBean> commonBeans = hpBeans.get(key);
			if(commonBeans != null) {
				commonBeans.add(commonBean);
			}else {
				commonBeans = new ArrayList<CommonBean>();
				commonBeans.add(commonBean);
				hpBeans.put(key, commonBeans);
			}
			
		}

		return hpBeans;
	}
	//第8页的表格处理方式
	public String getR17() {
		StringBuffer sb = new StringBuffer();
		for(ClsProBlmRep obj: clsProBlemReps) {
			sb.append(obj.getAnxiousRiskList());
			
		}

		return sb.toString();
	}
}
