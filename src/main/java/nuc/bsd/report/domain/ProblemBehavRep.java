package nuc.bsd.report.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import nuc.bsd.util.DateUtil;

public class ProblemBehavRep {
	private String id;
	private String schoolId;
	private String gradeId;
	private String classId;
	private String stuId;
	private String name;
	private String age;
	private String gender;
	private String className;
	private String testDate;
	private String missRate;
	private String elapsedTime;
	private String idxL;
	private String idxF;
	private String idxC;
	private String emotion;
	private String anxiety;
	private String depression;
	private String uncontroll;
	private String fail;
	private String somatization;
	private String oddBehav;
	private String interpersonal;
	private String socialPress;
	private String degenerate;
	private String bully;
	private String attention;
	private String inattention;
	private String mania;
	private String addiction;
	private String netAddiction;
	private String phoneAddiction;
	private String weariness;
	private String hateSchool;
	private String hateTeacher;
	private String hateStudy;
	private String anxExam;
	private String autolesionIdx;
	private String helplessnessIdx;
	private String interpersonalIdx;
	private String addictionIdx;
	private String bullyIdx;
	private String behavIdx;
	private String maniaIdx;
	private String poorHealthIdx;
	private String wearinessIdx;
	private String distractionIdx;
	private String anxExamIdx;
	private String conflictIdx;
    private int isGenerate;
    private String generatePath;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTestDate() {
		return DateUtil.formatYMD(testDate);
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getMissRate() {
		return missRate;
	}

	public void setMissRate(String missRate) {
		this.missRate = missRate;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getIdxL() {
		return idxL;
	}

	public void setIdxL(String idxL) {
		this.idxL = idxL;
	}

	public String getIdxF() {
		return idxF;
	}

	public void setIdxF(String idxF) {
		this.idxF = idxF;
	}

	public String getIdxC() {
		return idxC;
	}

	public void setIdxC(String idxC) {
		this.idxC = idxC;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getAnxiety() {
		return anxiety;
	}

	public void setAnxiety(String anxiety) {
		this.anxiety = anxiety;
	}

	public String getDepression() {
		return depression;
	}

	public void setDepression(String depression) {
		this.depression = depression;
	}

	public String getUncontroll() {
		return uncontroll;
	}

	public void setUncontroll(String uncontroll) {
		this.uncontroll = uncontroll;
	}

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

	public String getSomatization() {
		return somatization;
	}

	public void setSomatization(String somatization) {
		this.somatization = somatization;
	}

	public String getOddBehav() {
		return oddBehav;
	}

	public void setOddBehav(String oddBehav) {
		this.oddBehav = oddBehav;
	}

	public String getInterpersonal() {
		return interpersonal;
	}

	public void setInterpersonal(String interpersonal) {
		this.interpersonal = interpersonal;
	}

	public String getSocialPress() {
		return socialPress;
	}

	public void setSocialPress(String socialPress) {
		this.socialPress = socialPress;
	}

	public String getDegenerate() {
		return degenerate;
	}

	public void setDegenerate(String degenerate) {
		this.degenerate = degenerate;
	}

	public String getBully() {
		return bully;
	}

	public void setBully(String bully) {
		this.bully = bully;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getInattention() {
		return inattention;
	}

	public void setInattention(String inattention) {
		this.inattention = inattention;
	}

	public String getMania() {
		return mania;
	}

	public void setMania(String mania) {
		this.mania = mania;
	}

	public String getAddiction() {
		return addiction;
	}

	public void setAddiction(String addiction) {
		this.addiction = addiction;
	}

	public String getNetAddiction() {
		return netAddiction;
	}

	public void setNetAddiction(String netAddiction) {
		this.netAddiction = netAddiction;
	}

	public String getPhoneAddiction() {
		return phoneAddiction;
	}

	public void setPhoneAddiction(String phoneAddiction) {
		this.phoneAddiction = phoneAddiction;
	}

	public String getWeariness() {
		return weariness;
	}

	public void setWeariness(String weariness) {
		this.weariness = weariness;
	}

	public String getHateSchool() {
		return hateSchool;
	}

	public void setHateSchool(String hateSchool) {
		this.hateSchool = hateSchool;
	}

	public String getHateTeacher() {
		return hateTeacher;
	}

	public void setHateTeacher(String hateTeacher) {
		this.hateTeacher = hateTeacher;
	}

	public String getHateStudy() {
		return hateStudy;
	}

	public void setHateStudy(String hateStudy) {
		this.hateStudy = hateStudy;
	}

	public String getAnxExam() {
		return anxExam;
	}

	public void setAnxExam(String anxExam) {
		this.anxExam = anxExam;
	}

	public String getAutolesionIdx() {
		return autolesionIdx;
	}

	public void setAutolesionIdx(String autolesionIdx) {
		this.autolesionIdx = autolesionIdx;
	}

	public String getHelplessnessIdx() {
		return helplessnessIdx;
	}

	public void setHelplessnessIdx(String helplessnessIdx) {
		this.helplessnessIdx = helplessnessIdx;
	}

	public String getInterpersonalIdx() {
		return interpersonalIdx;
	}

	public void setInterpersonalIdx(String interpersonalIdx) {
		this.interpersonalIdx = interpersonalIdx;
	}

	public String getAddictionIdx() {
		return addictionIdx;
	}

	public void setAddictionIdx(String addictionIdx) {
		this.addictionIdx = addictionIdx;
	}

	public String getBullyIdx() {
		return bullyIdx;
	}

	public void setBullyIdx(String bullyIdx) {
		this.bullyIdx = bullyIdx;
	}

	public String getBehavIdx() {
		return behavIdx;
	}

	public void setBehavIdx(String behavIdx) {
		this.behavIdx = behavIdx;
	}

	public String getManiaIdx() {
		return maniaIdx;
	}

	public void setManiaIdx(String maniaIdx) {
		this.maniaIdx = maniaIdx;
	}

	public String getPoorHealthIdx() {
		return poorHealthIdx;
	}

	public void setPoorHealthIdx(String poorHealthIdx) {
		this.poorHealthIdx = poorHealthIdx;
	}

	public String getWearinessIdx() {
		return wearinessIdx;
	}

	public void setWearinessIdx(String wearinessIdx) {
		this.wearinessIdx = wearinessIdx;
	}

	public String getDistractionIdx() {
		return distractionIdx;
	}

	public void setDistractionIdx(String distractionIdx) {
		this.distractionIdx = distractionIdx;
	}

	public String getAnxExamIdx() {
		return anxExamIdx;
	}

	public void setAnxExamIdx(String anxExamIdx) {
		this.anxExamIdx = anxExamIdx;
	}

	public String getConflictIdx() {
		return conflictIdx;
	}

	public void setConflictIdx(String conflictIdx) {
		this.conflictIdx = conflictIdx;
	}

	private String r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21,
			r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42,
			r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58;

	public String getR0() {
		return id;
	}

	public String getR1() {
		return name;
	}

	public String getR2() {
		return age;
	}

	public String getR3() {
		return gender;
	}

	public String getR4() {
		return className;
	}

	public String getR5() {
		return this.getTestDate();
	}

	public String getR6() {
		return missRate;
	}

	public String getR7() {
		return elapsedTime;
	}

	public String getR8() {
		return idxL;
	}

	public String getR9() {
		return idxF;
	}

	public String getR10() {
		return idxC;
	}

	public String getR11() {
		String data = missRate.substring(0, missRate.length()-1);
		float v = Float.parseFloat(data);
		if (v < 0.333) {
			return "正常";
		}
		return "有嫌疑";

	}

	public String getR12() {
		int bidx = elapsedTime.indexOf("分");
		int eidx = elapsedTime.indexOf("秒");		
		String mins = elapsedTime.substring(0, bidx);
		String secs = 		elapsedTime.substring(bidx+1, eidx);
		int min = Integer.parseInt(mins.trim());
		int sec = Integer.parseInt(secs.trim());
		//float v = Float.parseFloat(elapsedTime);
		if ((min*60+sec) > 450) {
			return "正常";
		}
		return "有嫌疑";
	}

	public String getR13() {
		Integer v = Math.round(Float.parseFloat(idxL));
		if (v >= 0 && v <= 12) {
			return "正常";
		} else if (v >= 13 && v <= 18) {
			return "有嫌疑";
		}
		return "";
	}

	public String getR14() {
		Integer v = Math.round(Float.parseFloat(idxF));
	
		if (v >= 0 && v < 10) {
			return "正常";
		} else if (v >= 10 && v <= 15) {
			return "有嫌疑";
		}
		return "";
	}

	public String getR15() {
		Integer v = Math.round(Float.parseFloat(idxC));
		if (v >= 0 && v <= 5) {
			return "正常";
		} else if (v >= 6 && v <= 10) {
			return "有嫌疑";
		}
		return "";
	}

	public List<Integer> getR16() {
		List<Integer> data = new ArrayList<Integer>();
		/*
		 * anxiety焦虑,depression抑郁,somatization(躯体化),uncontroll无控制感,fail(失败感),oddBehav（
		 * 不寻常行为）,emotion（情绪维度得分),
		 */
		data.add(Math.round(Float.parseFloat(anxiety)));
		data.add(Math.round(Float.parseFloat(depression)));
		data.add(Math.round(Float.parseFloat(somatization)));
		data.add(Math.round(Float.parseFloat(uncontroll)));

		data.add(Math.round(Float.parseFloat(fail)));
		data.add(Math.round(Float.parseFloat(oddBehav)));
		data.add(Math.round(Float.parseFloat(emotion)));

		/* socialPress(社会压力）,degenerate(交往退缩),bully（欺负），Interpersonal(人际问题) */
		data.add(Math.round(Float.parseFloat(socialPress)));
		data.add(Math.round(Float.parseFloat(degenerate)));
		data.add(Math.round(Float.parseFloat(bully)));
		data.add(Math.round(Float.parseFloat(interpersonal)));

		/* attention(注意力问题), inattention(注意力不集中),mania(狂躁) */
		data.add(Math.round(Float.parseFloat(inattention)));
		data.add(Math.round(Float.parseFloat(mania)));
		data.add(Math.round(Float.parseFloat(attention)));
		/* addiction(成瘾问题), netAddiction( 网络成瘾), phoneAddiction(手机成瘾) */
		data.add(Math.round(Float.parseFloat(netAddiction)));
		data.add(Math.round(Float.parseFloat(phoneAddiction)));
		data.add(Math.round(Float.parseFloat(addiction)));
		/*
		 * Weariness(厌学状况),
		 * hateSchool(讨厌学校),hateTeacher(讨厌老师),hateStudy(讨厌学习),anxExam(考试焦虑)
		 */
		data.add(Math.round(Float.parseFloat(hateSchool)));
		data.add(Math.round(Float.parseFloat(hateTeacher)));
		data.add(Math.round(Float.parseFloat(hateStudy)));
		data.add(Math.round(Float.parseFloat(anxExam)));
		data.add(Math.round(Float.parseFloat(weariness)));
		return data;
	}

	public String getR17() {
		return name;
	}

	public List<String> getR18() {
		List<String> data = new ArrayList<String>();
		/*
		 * 存在风险：T ≥ 70分 潜在风险：60 ≤ T＜70分 无风险：T＜60分
		 */
		Integer v = Math.round(Float.parseFloat(emotion));
		if (v >= 70) {
			data.add("情绪问题存在风险");
		} else if (v >= 60 && v < 70) {
			data.add("存在的负面情绪较多。有时会觉得紧张不安或悲伤难过，害怕失败，甚至伴随一些奇怪的想法和身体上的疼痛。这些消极的情绪和体验会形成恶性循环，导致情绪调节较困难。");
		} else if (v < 60) {
			data.add("不存在情绪问题。平时情绪很稳定，心态平和，心情愉悦，身心健康。");
		}
		v = Math.round(Float.parseFloat(interpersonal));
		if (v >= 70) {
			data.add("人际关系状况不太好。常常不能与他人保持融洽的关系。可能觉得他人都比自己优秀，也可能是很难设身处地地体谅他人的痛苦。常常只能沉浸在自己的感受中，使得不会主动与别人沟通并真诚地对待他人。");
		} else if (v >= 60 && v < 70) {
			data.add("有时候不能与他人保持融洽的关系，较少主动地与他人沟通并真诚地对待他人。");
		} else if (v < 60) {
			data.add("人际关系状况良好。能与他人保持融洽的关系，既能够承认自己，又能够尊重别人，能体谅他人的痛苦并想方设法帮助他人。");
		}
		v = Math.round(Float.parseFloat(attention));
		if (v >= 70) {
			data.add("可能存在注意力缺陷症状。不能集中注意力完成一件事，注意力的保持时间很短。有时虽然表现得很亢奋，不用休息，但很难专注于完成一件事。");
		} else if (v >= 60 && v < 70) {
			data.add("可能存在一定程度上的注意力缺陷症状。有时不能专注于学习，常常会分心；有时头脑中会有各种各样的想法闪过，导致不能专注于某件事上。");
		} else if (v < 60) {
			data.add("做事情时能达到全神贯注，有效地将思维活动集中到需要的地方。");
		}
		v = Math.round(Float.parseFloat(addiction));
		if (v >= 70) {
			data.add("对网络和手机使用的控制力非常低。");
		} else if (v >= 60 && v < 70) {
			data.add("对网络和手机使用的控制力一般。");
		} else if (v < 60) {
			data.add("对网络和手机使用的控制力非常高。");
		}
		v = Math.round(Float.parseFloat(weariness));
		if (v >= 70) {
			data.add("有厌学倾向。学习兴趣很低，甚至讨厌学校、讨厌老师、讨厌学习。在考试前，时常会感到紧张焦虑，很难在考试中取得好成绩。");
		} else if (v >= 60 && v < 70) {
			data.add("可能有一点厌学倾向。表现为学习兴趣不高，学习本身不能带来快乐，对学校和老师也有一定的意见。面对考试时，有时会感到焦虑。");
		} else if (v < 60) {
			data.add("不存在厌学问题。对学校和老师很满意，学习兴趣非常高。能够主动地学习，并且享受学习带来的快感，面对考试也能从容应对。");
		}
		return data;
	}

	public String getR19() {
		/*
		 * 无风险：当前没有焦虑症状，可能感到心态平静，放松，不容易感到害怕，不会总是担心事情可能会出现问题，情绪平静、放松、稳定。
		 * 潜在风险：可能有焦虑症状，容易感觉到危险和威胁，容易紧张、恐惧、担忧、不安，神经过敏，情绪变化较大。
		 * 存在风险：有明显的焦虑症状，非常容易感觉到危险和威胁，非常容易紧张、恐惧、担忧、不安，神经过敏，情绪变化很大。
		 * 即便是对于一些在他人看来是不太可能会发生的事情，也会常常无缘无故地担心和害怕。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(anxiety));
		if (v >= 70) {
			data = "存在风险";
			r20 = "有明显的焦虑症状，非常容易感觉到危险和威胁，非常容易紧张、恐惧、担忧、不安，神经过敏，情绪变化很大。即便是对于一些在他人看来是不太可能会发生的事情，也会常常无缘无故地担心和害怕。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r20 = "可能有焦虑症状，容易感觉到危险和威胁，容易紧张、恐惧、担忧、不安，神经过敏，情绪变化较大。";
		} else if (v < 60) {
			data = "无风险";
			r20 = "当前没有焦虑症状，可能感到心态平静、放松，不容易感到害怕，不会总是担心事情可能会出现问题，情绪平静、放松、稳定。";
		}
		return data;
	}

	public String getR20() {
		return r20;
	}

	public String getR21() {
		/*
		 * 抑郁 无风险：比较乐观、积极向上，看待事情总是首先看到事情好的一面，对未来有信心，抱有希望。
		 * 潜在风险：具有轻微的抑郁症状。比较容易看到生活中的一些事情的负面影响，导致情绪较为低落，容易感到悲伤、无助，灰心丧气，有时甚至丧失了对生活的兴趣。
		 * 存在风险：具有非常明显的抑郁症状。生活中的很多事情都比较容易激起负性认知，看到事情的阴暗面，导致情绪非常低落，活动水平下降，绝望、内疚、郁闷、
		 * 沮丧是经常感受到的情绪。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(depression));
		if (v >= 70) {
			data = "存在风险";
			r22 = "具有非常明显的抑郁症状。生活中的很多事情都比较容易激起负性认知，看到事情的阴暗面，导致情绪非常低落，活动水平下降，绝望、内疚、郁闷、沮丧是经常感受到的情绪。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r22 = "具有轻微的抑郁症状。比较容易看到生活中的一些事情的负面影响，导致情绪较为低落，容易感到悲伤、无助，灰心丧气，有时甚至丧失了对生活的兴趣。";
		} else if (v < 60) {
			data = "无风险";
			r22 = "比较乐观、积极向上，看待事情总是首先看到事情好的一面，对未来有信心，抱有希望。";
		}
		return data;

	}

	public String getR22() {
		return r22;
	}

	public String getR23() {
		/*
		 *  躯体化 无风险：没有心理和身体上的相关病症，属于健康人群。
		 * 潜在风险：具有一定的躯体化症状，例如时常有头痛、乏力、失眠、胃痛等身体不适表现，学习效率下降。
		 * 存在风险：躯体化症状明显，总是伴随着身体上的不适感，例如头痛、乏力、失眠、胃痛，经常因为生病而请假休息，但是又检查不出任何身体疾病。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(somatization));
		if (v >= 70) {
			data = "存在风险";
			r24 = "躯体化症状明显，总是伴随着身体上的不适感，例如头痛、乏力、失眠、胃痛，经常因为生病而请假休息，但是又检查不出任何身体疾病。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r24 = "具有一定的躯体化症状，例如时常有头痛、乏力、失眠、胃痛等身体不适表现，学习效率下降。";
		} else if (v < 60) {
			data = "无风险";
			r24 = "没有心理和身体上的相关病症，属于健康人群。";
		}
		return data;
	}

	public String getR24() {
		return r24;
	}

	public String getR25() {
		/*
		 *  无控制感 无风险：可以有效地掌控自己的生活，控制自己的行为，把握自己的命运，而不会被其他意外的、不可控制的外部因素所驱使。
		 * 潜在风险：控制感比较低，遇到困难时会更多地想到自己的不足之处。并把潜在的困难看得比实际上还要严重，容易产生焦虑、抑郁等负性情绪体验，降低行为的主动性。
		 * 存在风险：控制感非常低，遇到困难时往往把潜在的困难看的十分严重，甚至逐渐失去了应对微小困难的勇气，让本人持续处于巨大压力之下，被焦虑、
		 * 抑郁等负性情绪体验围绕，倾向于以消极的方式应对生活上的各种问题，并且有意识地回避具有挑战性的活动。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(uncontroll));
		if (v >= 70) {
			data = "存在风险";
			r26 = "控制感非常低，遇到困难时往往把潜在的困难看的十分严重，甚至逐渐失去了应对微小困难的勇气，让本人持续处于巨大压力之下，被焦虑、抑郁等负性情绪体验围绕，倾向于以消极的方式应对生活上的各种问题，并且有意识地回避具有挑战性的活动。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r26 = "潜在风险：控制感比较低，遇到困难时会更多地想到自己的不足之处。并把潜在的困难看得比实际上还要严重，容易产生焦虑、抑郁等负性情绪体验，降低行为的主动性。";
		} else if (v < 60) {
			data = "无风险";
			r26 = "可以有效地掌控自己的生活，控制自己的行为，把握自己的命运，而不会被其他意外的、不可控制的外部因素所驱使。";
		}
		return data;
	}

	public String getR26() {
		return r26;
	}

	public String getR27() {
		/*
		 *  失败感 无风险：心态乐观，个人需求得到满足，为自己所做的事情感到愉快或成功。即使偶尔做的事情未获得成功，仍会相信自己下一次能做好。
		 * 潜在风险：经常感到失败，做的事情经常未能获得成功。情绪低落，难过、自责、懊恼万分。
		 * 存在风险：总是感到失败，觉得自己做什么都不会成功，心灰意冷，万念俱灰。因为害怕失败而不愿轻易尝试新鲜事物，有抑郁的情绪，甚至会出现攻击性行为。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(fail));
		if (v >= 70) {
			data = "存在风险";
			r28 = "总是感到失败，觉得自己做什么都不会成功，心灰意冷，万念俱灰。因为害怕失败而不愿轻易尝试新鲜事物，有抑郁的情绪，甚至会出现攻击性行为。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r28 = "经常感到失败，做的事情经常未能获得成功。情绪低落，难过、自责、懊恼万分。";
		} else if (v < 60) {
			data = "无风险";
			r28 = "心态乐观，个人需求得到满足，为自己所做的事情感到愉快或成功。即使偶尔做的事情未获得成功，仍会相信自己下一次能做好。";
		}
		return data;
	}

	public String getR28() {
		return r28;
	}

	public String getR29() {
		/*
		 *  不寻常行为 无风险：有正常的思维和想法，主客观一致，内在统一和谐。
		 * 潜在风险：有可能有一些特殊的想法，和别人感觉不到的感觉，周围的人可能有表达过认为自己有些奇怪的想法。
		 * 存在风险：可能拥有一些特殊的想法，和别人感觉不到的感觉，周围的人可能有表达过认为自己有些奇怪的想法，或人际关系不是特别和谐，可能存在心理健康的风险。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(oddBehav));
		if (v >= 70) {
			data = "存在风险";
			r30 = "可能拥有一些特殊的想法，和别人感觉不到的感觉，周围的人可能有表达过认为自己有些奇怪的想法，或人际关系不是特别和谐，可能存在心理健康的风险。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r30 = "有可能有一些特殊的想法，和别人感觉不到的感觉，周围的人可能有表达过认为自己有些奇怪的想法。";
		} else if (v < 60) {
			data = "无风险";
			r30 = "有正常的思维和想法，主客观一致，内在统一和谐。";
		}
		return data;

	}

	public String getR30() {
		return r30;
	}

	public String getR31() {
		/*
		 *  社会压力 无风险：具有良好的社交技能和社交能力。与他人的关系比较和谐，在集体中能自由地表达自己的想法。在面对压力和挫折时，能够得到他人给予的社会支持。
		 * 潜在风险：在社交技能和社交能力方面可能存在一定问题，与人相处时会不知所措，与他人的关系不是很和谐。过多地约束自己的言行，以致无法充分地表达自己的思想感情。
		 * 存在风险：在社交技能和社交能力方面存在严重问题。在与人交往时（尤其是公共场合下），会不由自主地感到紧张、害怕，以致手足无措、语无伦次。不能和谐地与他人相处
		 * ，无法维持与周围群体的正常关系，感受到来自群体的压力感。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(socialPress));
		if (v >= 70) {
			data = "存在风险";
			r32 = "在社交技能和社交能力方面存在严重问题。在与人交往时（尤其是公共场合下），会不由自主地感到紧张、害怕，以致手足无措、语无伦次。不能和谐地与他人相处，无法维持与周围群体的正常关系，感受到来自群体的压力感。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r32 = "在社交技能和社交能力方面可能存在一定问题，与人相处时会不知所措，与他人的关系不是很和谐。过多地约束自己的言行，以致无法充分地表达自己的思想感情。";
		} else if (v < 60) {
			data = "无风险";
			r32 = "具有良好的社交技能和社交能力。与他人的关系比较和谐，在集体中能自由地表达自己的想法。在面对压力和挫折时，能够得到他人给予的社会支持。";
		}
		return data;

	}

	public String getR32() {
		return r32;
	}

	public String getR33() {
		/*
		 * 交往退缩 无风险：倾向于与人交往，在社交场合中通常能积极地参与同伴交往和群体活动，能比较良好地适应社会活动。
		 * 潜在风险：在社交场合中可能更愿意独处，由于一些原因较少主动和自如地发起同伴互动，或在与同伴的互动中容易脱离出来。
		 * 存在风险：有交往退缩的倾向。由于一些原因，不能自如地发起和维持同伴互动。在有同伴的场景中，仍然持续地表现出各种形式的独自活动。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(degenerate));
		if (v >= 70) {
			data = "存在风险";
			r34 = "有交往退缩的倾向。由于一些原因，不能自如地发起和维持同伴互动。在有同伴的场景中，仍然持续地表现出各种形式的独自活动。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r34 = "在社交场合中可能更愿意独处，由于一些原因较少主动和自如地发起同伴互动，或在与同伴的互动中容易脱离出来。";
		} else if (v < 60) {
			data = "无风险";
			r34 = "倾向于与人交往，在社交场合中通常能积极地参与同伴交往和群体活动，能比较良好地适应社会活动。";
		}
		return data;

	}

	public String getR34() {
		return r34;
	}

	public String getR35() {
		/*
		 *  欺负 无风险：能掌握好与同伴之间彼此尊重的人际关系，不会轻易地遭受他人来自言语或行动上的欺负。
		 * 潜在风险：可能容易受到他人故意的攻击和侵犯，包括言语或者行动上，有潜在的被欺负困扰的风险。
		 * 存在风险：可能存在着比较严重的被欺负困扰，容易受到他人来自言语或行动上的、故意且毫无理由的攻击和侵犯。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(bully));
		if (v >= 70) {
			data = "存在风险";
			r36 = "可能存在着比较严重的被欺负困扰，容易受到他人来自言语或行动上的、故意且毫无理由的攻击和侵犯。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r36 = "可能容易受到他人故意的攻击和侵犯，包括言语或者行动上，有潜在的被欺负困扰的风险。";
		} else if (v < 60) {
			data = "无风险";
			r36 = "能掌握好与同伴之间彼此尊重的人际关系，不会轻易地遭受他人来自言语或行动上的欺负。";
		}
		return data;
	}

	public String getR36() {
		return r36;
	}

	public String getR37() {
		/*
		 *  注意力不集中 无风险：在做事情时能达到全神贯注，能够保持很长时间的注意力，非常从容有效地应对生活上的各种问题。
		 * 潜在风险：可能具有一定程度的注意力缺陷。表现为做事常常会走神，不能自始自终集中精力，粗心大意，容易遗失物品，时常会心不在焉，无法长时间地倾听别人的说话。
		 * 存在风险：可能存在注意力缺陷症状。具体表现为不能自始至终集中注意力完成一件事，不注意细节，经常出错，常常无法专心倾听他人说话，忘记他人交待的事情，
		 * 注意力容易分散。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(inattention));
		if (v >= 70) {
			data = "存在风险";
			r38 = "可能存在注意力缺陷症状。具体表现为不能自始至终集中注意力完成一件事，不注意细节，经常出错，常常无法专心倾听他人说话，忘记他人交待的事情，注意力容易分散。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r38 = "可能具有一定程度的注意力缺陷。表现为做事常常会走神，不能自始自终集中精力，粗心大意，容易遗失物品，时常会心不在焉，无法长时间地倾听别人的说话。";
		} else if (v < 60) {
			data = "无风险";
			r38 = "在做事情时能达到全神贯注，能够保持很长时间的注意力，非常从容有效地应对生活上的各种问题。";
		}
		return data;

	}

	public String getR38() {
		return r38;
	}

	public String getR39() {
		/*
		 *  狂躁 无风险：能够有效地将思维活动集中到需要的地方，学习时能够专注地投入，能够控制自己的思想。
		 * 潜在风险：可能存在一定程度上的狂躁症状。表现为不能投入到学习中，集中精神认真听讲显得很困难，有时头脑中闪过的想法令人感到苦恼。
		 * 存在风险：可能存在狂躁症状。以活动量过度，思维转换过快为主要特征，在生活和学习中很难静下心。思维的快速变换给学习带来很大困扰，表现为难以静坐，
		 * 不能将注意力集中到学习的内容上。严重时，奔逸的想法会导致夜不能寐。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(mania));
		if (v >= 70) {
			data = "存在风险";
			r40 = "可能存在狂躁症状。以活动量过度，思维转换过快为主要特征，在生活和学习中很难静下心。思维的快速变换给学习带来很大困扰，表现为难以静坐，不能将注意力集中到学习的内容上。严重时，奔逸的想法会导致夜不能寐。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r40 = "可能存在一定程度上的狂躁症状。表现为不能投入到学习中，集中精神认真听讲显得很困难，有时头脑中闪过的想法令人感到苦恼。";
		} else if (v < 60) {
			data = "无风险";
			r40 = "能够有效地将思维活动集中到需要的地方，学习时能够专注地投入，能够控制自己的思想。";
		}
		return data;

	}

	public String getR40() {
		return r40;
	}

	public String getR41() {
		/*
		 *  网络成瘾 无风险：没有网络成瘾症状，能够有效地安排上网时间。
		 * 潜在风险：对网络的依赖性较强，或对其过度痴迷而经常无法自我摆脱。可能该问题已经影响到学习与生活，并能体验到一定程度上的抑郁和焦虑情绪等。
		 * 存在风险：可能存在网络成瘾症状。表现为对网络的过度依赖，或对其过度痴迷而无法摆脱。经常会觉得身体不适（生病或躯体疼痛感），做事缺乏精力。出现焦虑和抑郁情绪
		 * ，智力功能衰退等。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(netAddiction));
		if (v >= 70) {
			data = "存在风险";
			r42 = "可能存在网络成瘾症状。表现为对网络的过度依赖，或对其过度痴迷而无法摆脱。经常会觉得身体不适（生病或躯体疼痛感），做事缺乏精力。出现焦虑和抑郁情绪，智力功能衰退等。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r42 = "对网络的依赖性较强，或对其过度痴迷而经常无法自我摆脱。可能该问题已经影响到学习与生活，并能体验到一定程度上的抑郁和焦虑情绪等。";
		} else if (v < 60) {
			data = "无风险";
			r42 = "没有网络成瘾症状，能够有效地安排上网时间。";
		}
		return data;

	}

	public String getR42() {
		return r42;
	}

	public String getR43() {
		/*
		 *  手机成瘾 无风险：没有手机成瘾症状，能够合理有效地使用手机。
		 * 潜在风险：对手机有一定的依赖性，甚至对正常的学习和生活有轻微的影响，并由此产生了焦虑和抑郁等不良情绪。
		 * 存在风险：存在一定手机成瘾的症状。其表现为：过度依赖手机，经常感到无精打采、身体不适。有焦虑或抑郁等不良情绪，甚至出现智力功能衰退等表现。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(phoneAddiction));
		if (v >= 70) {
			data = "存在风险";
			r44 = "存在一定手机成瘾的症状。其表现为：过度依赖手机，经常感到无精打采、身体不适。有焦虑或抑郁等不良情绪，甚至出现智力功能衰退等表现。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r44 = "对手机有一定的依赖性，甚至对正常的学习和生活有轻微的影响，并由此产生了焦虑和抑郁等不良情绪。";
		} else if (v < 60) {
			data = "无风险";
			r44 = "没有手机成瘾症状，能够合理有效地使用手机。";
		}
		return data;

	}

	public String getR44() {
		return r44;
	}

	public String getR45() {
		/*
		 *  讨厌学校 无风险：对于学校的态度积极，能够身心愉悦地参加学校组织的各种活动。
		 * 潜在风险：对于学校的态度有些消极，在学校感到身心疲惫和不安，经常有逃避学校的想法或举动。
		 * 存在风险：对于学校的态度非常消极，不喜欢学校的活动和环境。经常想办法逃避学校或者有退学的打算，在学校里会出现生理上的不适感。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(hateSchool));
		if (v >= 70) {
			data = "存在风险";
			r46 = "对于学校的态度非常消极，不喜欢学校的活动和环境。经常想办法逃避学校或者有退学的打算，在学校里会出现生理上的不适感。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r46 = "对于学校的态度有些消极，在学校感到身心疲惫和不安，经常有逃避学校的想法或举动。";
		} else if (v < 60) {
			data = "无风险";
			r46 = "对于学校的态度积极，能够身心愉悦地参加学校组织的各种活动。";
		}
		return data;

	}

	public String getR46() {
		return r46;
	}

	public String getR47() {
		/*
		 *  讨厌老师 无风险：和老师的关系融洽，信赖并且喜欢老师。
		 * 潜在风险：可能不太满意一些老师的做法，或是与老师产生过一些矛盾和冲突，对老师有一些疏远和不信赖。
		 * 存在风险：对老师表现出极大的不信赖。与老师可能已经有过一定的矛盾与冲突，并且现在也没有得到很好的化解。经常对老师心存不满，例如他们的言谈、做法等等。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(hateTeacher));
		if (v >= 70) {
			data = "存在风险";
			r48 = "对老师表现出极大的不信赖。与老师可能已经有过一定的矛盾与冲突，并且现在也没有得到很好的化解。经常对老师心存不满，例如他们的言谈、做法等等。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r48 = "可能不太满意一些老师的做法，或是与老师产生过一些矛盾和冲突，对老师有一些疏远和不信赖。";
		} else if (v < 60) {
			data = "无风险";
			r48 = "和老师的关系融洽，信赖并且喜欢老师。";
		}
		return data;

	}

	public String getR48() {

		return r48;
	}

	public String getR49() {
		/*
		 * 讨厌学习 无风险：在学习过程中较为主动，学习目的明确，对学校的学习生活感到有趣，能以积极的态度应对作业和考试。
		 * 潜在风险：在学习过程中，学习目的不太明确，有时对学校的学习生活失去兴趣，感到学习生活有些单调。对学习的态度是冷漠的、逃避的、厌烦的，对作业和考试感到厌烦，
		 * 把学习看成是一种负担。
		 * 存在风险：在学习过程中非常被动，学习目的非常不明确，感到学习生活太无聊。把学习看成是一种沉重的负担，甚至可能伴有生理反应，如一提到学习就头痛、恶心、腹痛、
		 * 尿频、食欲下降、失眠等。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(hateStudy));
		if (v >= 70) {
			data = "存在风险";
			r50 = "在学习过程中非常被动，学习目的非常不明确，感到学习生活太无聊。把学习看成是一种沉重的负担，甚至可能伴有生理反应，如一提到学习就头痛、恶心、腹痛、尿频、食欲下降、失眠等。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r50 = "在学习过程中，学习目的不太明确，有时对学校的学习生活失去兴趣，感到学习生活有些单调。对学习的态度是冷漠的、逃避的、厌烦的，对作业和考试感到厌烦，把学习看成是一种负担。";
		} else if (v < 60) {
			data = "无风险";
			r50 = "在学习过程中较为主动，学习目的明确，对学校的学习生活感到有趣，能以积极的态度应对作业和考试。";
		}
		return data;

	}

	public String getR50() {
		return r50;
	}

	public String getR51() {
		/*
		 *  考试焦虑 无风险：能较好地应对考试带来的压力，考试并不会成为烦恼。 潜在风险：在应对考试的整个过程中，会显得稍微有些紧张和焦虑。
		 * 存在风险：在应对考试时，会显得非常紧张和焦虑。可能常常会感到头晕、头疼，反胃等，考前注意力范围会变得狭窄，很容易担心和发怒，担心的是主观臆想的糟糕后果，
		 * 愤怒的是身边发生的一些让自己不满的事情。
		 */
		String data = "";
		Integer v = Math.round(Float.parseFloat(anxExam));
		if (v >= 70) {
			data = "存在风险";
			r52 = "在应对考试时，会显得非常紧张和焦虑。可能常常会感到头晕、头疼，反胃等，考前注意力范围会变得狭窄，很容易担心和发怒，担心的是主观臆想的糟糕后果，愤怒的是身边发生的一些让自己不满的事情。";
		} else if (v >= 60 && v < 70) {
			data = "潜在风险";
			r52 = "在应对考试的整个过程中，会显得稍微有些紧张和焦虑。";
		} else if (v < 60) {
			data = "无风险";
			r52 = "能较好地应对考试带来的压力，考试并不会成为烦恼。";
		}
		return data;

	}

	public String getR52() {
		return r52;
	}

	public List<Float> getR53() {
		List<Float> data = new ArrayList<Float>();
		data.add(Float.parseFloat(autolesionIdx));
		data.add(Float.parseFloat(helplessnessIdx));
		data.add(Float.parseFloat(interpersonalIdx));
		data.add(Float.parseFloat(addictionIdx));

		data.add(Float.parseFloat(bullyIdx));
		data.add(Float.parseFloat(behavIdx));
		data.add(Float.parseFloat(maniaIdx));
		data.add(Float.parseFloat(poorHealthIdx));
		return data;
	}

	public String getR54() {
		return name;
	}

	public List<String> getR55() {

		List<String> data = new ArrayList<String>();
		/*
		 *  存在风险：T ≥ 70分，即指数 > 7.0。  潜在风险：60 ≤ T＜70分，即6.0 < 指数 < 7.0 。  无风险：T＜60分，即指数
		 * < 6.0。
		 */
		/*
		 * 无风险：对生活持积极乐观的态度，心理较健康。 
		 * 潜在风险：可能平时与人沟通较少，情绪控制能力较弱。有时会感觉到担心或不开心，以及身体上会有一些不适的症状。学习和生活可能已受到一定程度上的影响，
		 * 建议多与同伴、父母和老师交流。 
		 * 存在风险：平时总觉得有坏事要发生，感到紧张、害怕以及不能放松，可能有失眠的症状。并且时常感到悲伤、不快乐，伴有身体上的疼痛。建议多与心理健康老师交流，
		 * 改善和提升自己的心理状态。
		 */
		Float v = Float.parseFloat(autolesionIdx);
		if (v >= 7.0) {
			data.add("自伤指数" + v
					+ ",存在风险,平时总觉得有坏事要发生，感到紧张、害怕以及不能放松，可能有失眠的症状。并且时常感到悲伤、不快乐，伴有身体上的疼痛。建议多与心理健康老师交流，改善和提升自己的心理状态。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add(
					"自伤指数" + v + ",潜在风险,可能平时与人沟通较少，情绪控制能力较弱。有时会感觉到担心或不开心，以及身体上会有一些不适的症状。学习和生活可能已受到一定程度上的影响，建议多与同伴、父母和老师交流。");
		} else if (v < 6.0) {
			data.add("自伤指数" + v + ",无风险,对生活持积极乐观的态度，心理较健康。");
		}
		/*
		 * b. 无助感指数  无风险：可以有效地掌控自己的生活，控制自己的行为。努力尝试，不惧怕失败。心态乐观，为自己所做的事情感到愉快。 
		 * 潜在风险：情绪较低落，遇到困难时会更多地想到自己的不足之处。总觉得自己什么事都做不好，并把潜在的困难看得比实际上更严重。容易产生负性情绪体验，
		 * 降低行为的主动性。 
		 * 存在风险：遇到困难时往往把潜在的困难看得十分严重，甚至逐渐失去了应对微小困难的勇气。目前可能承受着巨大压力，被负性情绪困扰。以往可能多次尝试失败，
		 * 因此觉得自己做什么都不会成功，会轻易地选择放弃机会。
		 */
		v = Float.parseFloat(helplessnessIdx);
		if (v >= 7.0) {
			data.add("无助感指数" + v
					+ ",存在风险,遇到困难时往往把潜在的困难看得十分严重，甚至逐渐失去了应对微小困难的勇气。目前可能承受着巨大压力，被负性情绪困扰。以往可能多次尝试失败，因此觉得自己做什么都不会成功，会轻易地选择放弃机会。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("无助感指数" + v + ",潜在风险,情绪较低落，遇到困难时会更多地想到自己的不足之处。总觉得自己什么事都做不好，并把潜在的困难看得比实际上更严重。容易产生负性情绪体验，降低行为的主动性。");
		} else if (v < 6.0) {
			data.add("无助感指数" + v + ",无风险,可以有效地掌控自己的生活，控制自己的行为。努力尝试，不惧怕失败。心态乐观，为自己所做的事情感到愉快。");
		}
		/*
		 * c. 人际障碍指数  无风险：与他人的关系比较和谐，在集体中能自由地表达自己的想法。在面对压力和挫折时，能够得到他人给予的社会支持。 
		 * 潜在风险：有轻微的人际障碍，与他人的关系不是很和谐。过多地约束自己的言行，以致无法充分地表达自己的思想感情。 
		 * 存在风险：有严重的人际障碍。在与人交往时（尤其是公共场合下），会不由自主地感到紧张、害怕，以致手足无措、语无伦次，严重的甚至害怕见人。
		 */
		v = Float.parseFloat(interpersonalIdx);
		if (v >= 7.0) {
			data.add("人际障碍指数" + v + ",存在风险,有严重的人际障碍。在与人交往时（尤其是公共场合下），会不由自主地感到紧张、害怕，以致手足无措、语无伦次，严重的甚至害怕见人。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("人际障碍指数" + v + ",潜在风险,有轻微的人际障碍，与他人的关系不是很和谐。过多地约束自己的言行，以致无法充分地表达自己的思想感情。");
		} else if (v < 6.0) {
			data.add("人际障碍指数" + v + ",无风险,与他人的关系比较和谐，在集体中能自由地表达自己的想法。在面对压力和挫折时，能够得到他人给予的社会支持。");
		}
		/*
		 * d. 成瘾指数  无风险：对网络或手机使用的控制力较高，能够有效地安排上网或手机的使用时间。 
		 * 潜在风险：对网络或手机使用的控制力一般，可能已产生对网络或手机的依赖，并由此产生了焦虑和抑郁等不良情绪。 
		 * 存在风险：对网络或手机使用的控制力较低，可能已产生一定程度上的网络成瘾或手机成瘾症状。学习和生活已受到影响，建议合理分配上网时间或使用手机的时间。
		 */
		v = Float.parseFloat(addictionIdx);
		if (v >= 7.0) {
			data.add("成瘾指数" + v + ",存在风险,对网络或手机使用的控制力较低，可能已产生一定程度上的网络成瘾或手机成瘾症状。学习和生活已受到影响，建议合理分配上网时间或使用手机的时间。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("成瘾指数" + v + ",潜在风险,对网络或手机使用的控制力一般，可能已产生对网络或手机的依赖，并由此产生了焦虑和抑郁等不良情绪。");
		} else if (v < 6.0) {
			data.add("成瘾指数" + v + ",无风险,对网络或手机使用的控制力较高，能够有效地安排上网或手机的使用时间。");
		}
		/*
		 * e. 受欺负指数  无风险：能掌握好与同伴之间彼此尊重的人际关系，不会轻易遭受到他人故意的言语或行动上的欺负。 
		 * 潜在风险：可能容易受到他人故意的攻击和侵犯，包括言语或者行动上的，有潜在的被欺负困扰的风险。 
		 * 存在风险：可能存在着比较严重的被欺负困扰，容易受到来自他人言语或行动上、故意且毫无理由的攻击和侵犯。
		 */
		v = Float.parseFloat(bullyIdx);
		if (v >= 7.0) {
			data.add("受欺负指数" + v + ",存在风险,存在风险,可能存在着比较严重的被欺负困扰，容易受到来自他人言语或行动上、故意且毫无理由的攻击和侵犯。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("受欺负指数" + v + ",潜在风险,可能容易受到他人故意的攻击和侵犯，包括言语或者行动上的，有潜在的被欺负困扰的风险。");
		} else if (v < 6.0) {
			data.add("受欺负指数" + v + ",无风险,能掌握好与同伴之间彼此尊重的人际关系，不会轻易遭受到他人故意的言语或行动上的欺负。");
		}
		/*
		 * f. 行为失常指数  无风险：思维、想法和行为都属于正常范畴，主客观一致，内在统一和谐，即思维和想法一致。 
		 * 潜在风险：可能有一些奇怪的想法，有时会产生别人体验不到的感觉，或许曾经被人评价为很奇怪。 
		 * 存在风险：可能拥有一些特殊的、奇怪的想法，也会产生别人体验不到的感觉。曾经被人评价为行为或想法很奇怪，或人际关系不是特别和谐，可能存在心理健康风险。
		 */
		v = Float.parseFloat(behavIdx);
		if (v >= 7.0) {
			data.add("行为失常指数" + v + ",存在风险,可能拥有一些特殊的、奇怪的想法，也会产生别人体验不到的感觉。曾经被人评价为行为或想法很奇怪，或人际关系不是特别和谐，可能存在心理健康风险。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("行为失常指数" + v + ",潜在风险,可能有一些奇怪的想法，有时会产生别人体验不到的感觉，或许曾经被人评价为很奇怪。");
		} else if (v < 6.0) {
			data.add("行为失常指数" + v + ",无风险,思维、想法和行为都属于正常范畴，主客观一致，内在统一和谐，即思维和想法一致。");
		}
		/*
		 * g. 躁狂指数  无风险：能够有效地将思维活动集中到需要的地方，能够控制自己的思想。 
		 * 潜在风险：可能具备一定的狂躁症状。表现为不能投入到学习中，集中精神认真听讲显得很困难。有时头脑中闪过的想法令人感到苦恼。 
		 * 存在风险：可能存在狂躁症状。以活动量过度、思维转换过快为主要特征。在生活学习中很难静下心，思维的快速变换给学习带来很大的困扰。
		 */
		v = Float.parseFloat(maniaIdx);
		if (v >= 7.0) {
			data.add("躁狂指数" + v + ",存在风险,可能存在狂躁症状。以活动量过度、思维转换过快为主要特征。在生活学习中很难静下心，思维的快速变换给学习带来很大的困扰。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("躁狂指数" + v + ",潜在风险,可能具备一定的狂躁症状。表现为不能投入到学习中，集中精神认真听讲显得很困难。有时头脑中闪过的想法令人感到苦恼。");
		} else if (v < 6.0) {
			data.add("躁狂指数" + v + ",无风险,能够有效地将思维活动集中到需要的地方，能够控制自己的思想。");
		}
		/*
		 * h. 身体不适指数  无风险：没有心理上的相关病症，身体健康，属于健康人群。 
		 * 潜在风险：具有一定的躯体化症状。例如时常有头痛、乏力、失眠、胃痛等身体不适表现，学习效率下降。 
		 * 存在风险：躯体化症状明显。总是伴随着身体上的不适感，例如头痛、乏力、失眠、胃痛。经常因为生病而请假休息，但是又检查不出任何身体疾病。
		 */
		v = Float.parseFloat(poorHealthIdx);
		if (v >= 7.0) {
			data.add("身体不适指数" + v + ",存在风险,躯体化症状明显。总是伴随着身体上的不适感，例如头痛、乏力、失眠、胃痛。经常因为生病而请假休息，但是又检查不出任何身体疾病。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("身体不适指数" + v + ",潜在风险,具有一定的躯体化症状。例如时常有头痛、乏力、失眠、胃痛等身体不适表现，学习效率下降。");
		} else if (v < 6.0) {
			data.add("身体不适指数" + v + ",无风险,没有心理上的相关病症，身体健康，属于健康人群。");
		}
		return data;
	}

	public List<Float> getR56() {

		List<Float> data = new ArrayList<Float>();
		data.add(Float.parseFloat(wearinessIdx));
		data.add(Float.parseFloat(distractionIdx));
		data.add(Float.parseFloat(anxExamIdx));
		data.add(Float.parseFloat(conflictIdx));

		return data;

	}

	public String getR57() {
		return name;
	}

	public List<String> getR58() {

		List<String> data = new ArrayList<String>();
		/*
		 * i. 厌学指数  无风险：对于学校的态度积极。在学习过程中较为主动，学习目的明确，对学校的学习生活感到有趣。 
		 * 潜在风险：对于学校的态度有些消极。在学习过程中，学习目的不太明确，有时对学校的学习生活失去兴趣，感到学习生活有些单调。 
		 * 存在风险：对于学校的态度非常消极。在学习过程中非常被动，学习目的非常不明确，感到学习生活太无聊。
		 */
		Float v = Float.parseFloat(wearinessIdx);
		DecimalFormat   fnum  =   new  DecimalFormat("##0.00");  
		 String   value=fnum.format(v);     
		if (v >= 7.0) {
			data.add("厌学指数" + value + ",存在风险,对于学校的态度非常消极。在学习过程中非常被动，学习目的非常不明确，感到学习生活太无聊。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("厌学指数" + value + ",潜在风险,对于学校的态度有些消极。在学习过程中，学习目的不太明确，有时对学校的学习生活失去兴趣，感到学习生活有些单调。");
		} else if (v < 6.0) {
			data.add("厌学指数" + value + ",无风险,对于学校的态度积极。在学习过程中较为主动，学习目的明确，对学校的学习生活感到有趣。");
		}
		/*
		 * j. 分心指数  无风险：学习时能达到全神贯注，能够保持很长时间的注意力。 
		 * 潜在风险：可能具有一定程度上的注意力缺陷。表现为上课常常会走神，不能自始至终集中精力，做作业粗心大意等。 
		 * 存在风险：可能存在注意力缺陷症状，具体表现为不能自始至终集中注意力完成一件事。上课时注意力容易分散，常常无法专心倾听老师说话。
		 */
		v = Float.parseFloat(distractionIdx);
		value=fnum.format(v);  
		if (v >= 7.0) {
			data.add("分心指数" + value + ",无风险,可能存在注意力缺陷症状，具体表现为不能自始至终集中注意力完成一件事。上课时注意力容易分散，常常无法专心倾听老师说话。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("分心指数" + value + ",潜在风险,可能具有一定程度上的注意力缺陷。表现为上课常常会走神，不能自始至终集中精力，做作业粗心大意等。");
		} else if (v < 6.0) {
			data.add("分心指数" + value + ",无风险,学习时能达到全神贯注，能够保持很长时间的注意力。");
		}
		/*
		 * k. 考试焦虑指数  无风险：能从容自如地面对考试带来的压力，考试并不会成为烦恼。  潜在风险：应对考试压力的能力较差，产生轻微的紧张和焦虑等情绪。
		 *  存在风险：在应对考试时，非常紧张和焦虑。可能常常会感到头晕、头疼、反胃等，很容易担心和发怒，担心的是主观臆想的糟糕后果，
		 * 愤怒的是身边发生的一些让自己不满的事情。
		 */ v = Float.parseFloat(anxExamIdx);
		 value=fnum.format(v);  
		if (v >= 7.0) {
			data.add("考试焦虑指数" + value + ",无风险,在应对考试时，非常紧张和焦虑。可能常常会感到头晕、头疼、反胃等，很容易担心和发怒，担心的是主观臆想的糟糕后果，愤怒的是身边发生的一些让自己不满的事情。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("考试焦虑指数" + value + ",潜在风险,应对考试压力的能力较差，产生轻微的紧张和焦虑等情绪。");
		} else if (v < 6.0) {
			data.add("考试焦虑指数" + value + ",无风险,能从容自如地面对考试带来的压力，考试并不会成为烦恼。");
		}
		/*
		 * l. 师生冲突指数  无风险：师生关系和谐，信赖并且喜欢老师。 
		 * 潜在风险：可能不太满意一些老师的做法，或是与老师产生过一些矛盾和冲突，对老师有一些疏远和不信赖。 
		 * 存在风险：对老师表现出了极大的不信赖，对老师经常心存不满。与老师可能已经有过一定的矛盾与冲突，并且直到现在也没有得到很好的化解。
		 */
		v = Float.parseFloat(conflictIdx);
		 value=fnum.format(v);  
		if (v >= 7.0) {
			data.add("师生冲突指数" + value + ",无风险,对老师表现出了极大的不信赖，对老师经常心存不满。与老师可能已经有过一定的矛盾与冲突，并且直到现在也没有得到很好的化解。");
		} else if (v >= 6.0 && v < 7.0) {
			data.add("师生冲突指数" + value + ",潜在风险,可能不太满意一些老师的做法，或是与老师产生过一些矛盾和冲突，对老师有一些疏远和不信赖。");
		} else if (v < 6.0) {
			data.add("师生冲突指数" + value + ",无风险,师生关系和谐，信赖并且喜欢老师。");
		}
		return data;
	}

	public int getIsGenerate() {
		return isGenerate;
	}

	public void setIsGenerate(int isGenerate) {
		this.isGenerate = isGenerate;
	}

	public String getGeneratePath() {
		return generatePath;
	}

	public void setGeneratePath(String generatePath) {
		this.generatePath = generatePath;
	}

}
