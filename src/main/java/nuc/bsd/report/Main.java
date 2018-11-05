package nuc.bsd.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import nuc.bsd.report.Impl.PdfReport;
import nuc.bsd.report.domain.ClsProBlmRep;
import nuc.bsd.report.domain.ClsPsyRep;
import nuc.bsd.report.domain.ProblemBehavRep;
import nuc.bsd.report.domain.PsyQualityRep;
import nuc.bsd.util.DateUtil;
import nuc.bsd.util.JFinalUtil;
/*
 * 产生报告的主类
 */
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFinalUtil.init();
		
		/*processProblemBehaviors();
	processPsyQualities();*/
		/*processClsProBlmReps();*/
		processClsPsyReps();
		JFinalUtil.destroy();
	}
	private static void  processProblemBehaviors() {
		logger.debug("正在获取问题行为报告数据");
		List<ProblemBehavRep> pbObjs = getProblemBehaviors();
		/*List<PsyQualityRep> psyObjs = getPsyQualities();*/
		logger.debug("获取问题行为报告数据结束");
		IReport iReport  = new PdfReport();
		List<String> sqls = new ArrayList<String>();
		for(ProblemBehavRep pbObj: pbObjs) {
			logger.debug("正在处理报告:"+pbObj.getId()+",学生:"+pbObj.getName());
			String file_path = iReport.createProblemBehaviorReport(pbObj, pbObj.getStuId()+"_"+DateUtil.format(new Date()));
			
			sqls.add("update tbproblembehavrep set is_generate=1,generate_path='"+file_path.substring(1)+"' where id="+pbObj.getId());
			logger.debug("完成处理报告:"+pbObj.getId()+",学生:"+pbObj.getName());
		}
		logger.debug("正在回写问题行为报告数据库...+共:"+sqls.size()+"记录");
		//Db.batch(sqls, sqls.size());
		logger.debug("回写完成");
	}
	private static void processPsyQualities() {
		logger.debug("正在获取积极心理品质报告数据");
		List<PsyQualityRep> pbObjs = getPsyQualities();
		/*List<PsyQualityRep> psyObjs = getPsyQualities();*/
		logger.debug("获取积极心理品质报告数据结束");
		IReport iReport  = new PdfReport();
		List<String> sqls = new ArrayList<String>();
		for(PsyQualityRep pbObj: pbObjs) {
			logger.debug("正在处理报告:"+pbObj.getId()+",学生:"+pbObj.getName());
			String file_path = iReport.createPsyQualityReport(pbObj, pbObj.getStuId()+DateUtil.format(new Date()));
			sqls.add("update tbPsyQualityRep set is_generate=1,generate_path='"+file_path+"' where id="+pbObj.getId());
			logger.debug("完成处理报告:"+pbObj.getId()+",学生:"+pbObj.getName());
		}
		logger.debug("正在回写积极心理品质报告数据库...+共:"+sqls.size()+"记录");
		//Db.batch(sqls, sqls.size());
		logger.debug("回写完成");
	}
	private static List<PsyQualityRep>  getPsyQualities() {
		StringBuffer psytemplatesql = new StringBuffer();
		psytemplatesql.append("SELECT\r\n" + 
				"	a.id,\r\n" + 
				"	a.schoolId,\r\n" + 
				"	a.gradeId,\r\n" + 
				"	a.classId,\r\n" + 
				"	a.stuId,\r\n" + 
				"	b.NAME as stuName,\r\n" + 
				"	TIMESTAMPDIFF(YEAR, b.birthday, CURDATE()) AS age,\r\n" + 
				"	b.gender,\r\n" + 
				"	c.class as className,\r\n" + 
				"	a.testDate,\r\n" + 
				"	a.accuracy,\r\n" + 
				"	a.tendentiousness,\r\n" + 
				"	a.consistency,\r\n" + 
				"	a.stability,\r\n" + 
				"	a.companionT,\r\n" + 
				"	a.parenthoodT,\r\n" + 
				"	a.tsRelationT,\r\n" + 
				"	a.agreeablenessT,\r\n" + 
				"	a.resilienceT,\r\n" + 
				"	a.selfEsteemT,\r\n" + 
				"	a.SelfControllT as selfControllT,\r\n" + 
				"	a.SocialActiveT as socialActiveT,\r\n" + 
				"	a.learningResponsibilityT,\r\n" + 
				"	a.continueTnterestT,\r\n" + 
				"	a.continueEffortT,\r\n" + 
				"	a.situationSelT,\r\n" + 
				"	a.situationAdpT,\r\n" + 
				"	a.distriOfAttenT,\r\n" + 
				"	a.cognitiveChangeT,\r\n" + 
				"	a.responseModT\r\n" + 
				"	\r\n" + 
				"FROM\r\n" + 
				"	tbPsyQualityRep a\r\n" + 
				"JOIN student b ON a.stuId = b.studentNO\r\n" + 
				"JOIN class c ON a.classId = c.id where a.is_generate=0");
		List<Record> records = Db.find(psytemplatesql.toString());
 		List<PsyQualityRep> objs = new ArrayList<PsyQualityRep>();
 		for(Record record : records) {
 			PsyQualityRep obj = new PsyQualityRep();
 			obj.setId(record.getStr("id"));
 			obj.setSchoolId(record.getStr("schoolId"));
 			obj.setGradeId(record.getStr("gradeId"));
 			obj.setClassId(record.getStr("classId"));
 			obj.setStuId(record.getStr("stuId"));
 			obj.setName(record.getStr("stuName"));
 			obj.setAge(record.getStr("age"));
 			obj.setGender(record.getStr("gender"));
 			obj.setClassName(record.getStr("className"));
 			obj.setTestDate(record.getStr("testDate"));
			obj.setAccuracy(record.getStr("accuracy"));
 			obj.setTendentiousness(record.getStr("tendentiousness"));
 			obj.setConsistency(record.getStr("consistency"));
 			obj.setStability(record.getStr("stability"));
 			obj.setCompanionT(record.getStr("companionT"));
 			obj.setParenthoodT(record.getStr("parenthoodT"));
 			obj.setTsRelationT(record.getStr("tsRelationT"));
 			obj.setAgreeablenessT(record.getStr("agreeablenessT"));
 			obj.setResilienceT(record.getStr("resilienceT"));
 			obj.setSelfEsteemT(record.getStr("selfEsteemT"));
 			obj.setSelfControllT(record.getStr("selfControllT"));
 			obj.setSocialActiveT(record.getStr("socialActiveT"));
 			obj.setLearningResponsibilityT(record.getStr("learningResponsibilityT"));
 			obj.setContinueTnterestT(record.getStr("continueTnterestT"));
 			obj.setContinueEffortT(record.getStr("continueEffortT"));
 			obj.setSituationSelT(record.getStr("situationSelT"));
 			obj.setSituationAdpT(record.getStr("situationAdpT"));
 			obj.setDistriOfAttenT(record.getStr("distriOfAttenT"));
 			obj.setCognitiveChangeT(record.getStr("cognitiveChangeT"));
 			obj.setResponseModT(record.getStr("responseModT"));
 		    objs.add(obj);
 		}
		return objs;
	}
	private static List<ProblemBehavRep>  getProblemBehaviors() {
		StringBuffer pbtemplatesql = new StringBuffer();
 		pbtemplatesql.append("SELECT\r\n" + 
 				"	a.id,\r\n" + 
 				"	a.schoolId,\r\n" + 
 				"	a.gradeId,\r\n" + 
 				"	a.classId,\r\n" + 
 				"	a.stuId,\r\n" + 
 				"	b.NAME as stuName,\r\n" + 
 				"	TIMESTAMPDIFF(YEAR, b.birthday, CURDATE()) AS age,\r\n" + 
 				"	b.gender,\r\n" + 
 				"	c.class as className,\r\n" + 
 				"	a.testDate,\r\n" + 
 				"	a.missRate,\r\n" + 
 				"	a.elapsedTime,\r\n" + 
 				"	a.idxL,\r\n" + 
 				"	a.idxF,\r\n" + 
 				"	a.idxC,\r\n" + 
 				"	a.emotion,\r\n" + 
 				"	a.anxiety,\r\n" + 
 				"	a.depression,\r\n" + 
 				"	a.uncontroll,\r\n" + 
 				"	a.fail,\r\n" + 
 				"	a.somatization,\r\n" + 
 				"	a.oddBehav,\r\n" + 
 				"	a.Interpersonal as interpersonal,\r\n" + 
 				"	a.socialPress,\r\n" + 
 				"	a.degenerate,\r\n" + 
 				"	a.bully,\r\n" + 
 				"	a.attention,\r\n" + 
 				"	a.inattention,\r\n" + 
 				"	a.mania,\r\n" + 
 				"	a.addiction,\r\n" + 
 				"	a.netAddiction,\r\n" + 
 				"	a.phoneAddiction,\r\n" + 
 				"	a.Weariness as weariness,\r\n" + 
 				"	a.hateSchool,\r\n" + 
 				"	a.hateTeacher,\r\n" + 
 				"	a.hateStudy,\r\n" + 
 				"	a.anxExam,\r\n" + 
 				"	a.autolesionIdx,\r\n" + 
 				"	a.HelplessnessIdx as helplessnessIdx,\r\n" + 
 				"	a.interpersonalIdx,\r\n" + 
 				"	a.addictionIdx,\r\n" + 
 				"	a.bullyIdx,\r\n" + 
 				"	a.behavIdx,\r\n" + 
 				"	a.maniaIdx,\r\n" + 
 				"	a.poorHealthIdx,\r\n" + 
 				"	a.WearinessIdx as wearinessIdx,\r\n" + 
 				"	a.distractionIdx,\r\n" + 
 				"	a.anxExamIdx,\r\n" + 
 				"	a.conflictIdx\r\n" + 
 				"FROM\r\n" + 
 				"	tbproblembehavrep a\r\n" + 
 				"JOIN student b ON a.stuId = b.studentNO\r\n" + 
 				"JOIN class c ON a.classId = c.id where a.is_generate=0");
				
 		List<Record> records = Db.find(pbtemplatesql.toString());
 		List<ProblemBehavRep> objs = new ArrayList<ProblemBehavRep>();
 		for(Record record : records) {
 			ProblemBehavRep obj = new ProblemBehavRep();
 			obj.setId(record.getStr("id"));
 			obj.setSchoolId(record.getStr("schoolId"));
 			obj.setGradeId(record.getStr("gradeId"));
 			obj.setClassId(record.getStr("classId"));
 			obj.setStuId(record.getStr("stuId"));
 			obj.setName(record.getStr("stuName"));
 			obj.setAge(record.getStr("age"));
 			obj.setGender(record.getStr("gender"));
 			obj.setClassName(record.getStr("className"));
 			obj.setTestDate(record.getStr("testDate"));
 			obj.setMissRate(record.getStr("missRate"));
 			obj.setElapsedTime(record.getStr("elapsedTime"));
 			obj.setIdxL(record.getStr("idxL"));
 			obj.setIdxF(record.getStr("idxF"));
 			obj.setIdxC(record.getStr("idxC"));
 			obj.setEmotion(record.getStr("emotion"));
 			obj.setAnxiety(record.getStr("anxiety"));
 			obj.setDepression(record.getStr("depression"));
 			obj.setUncontroll(record.getStr("uncontroll"));
 			obj.setFail(record.getStr("fail"));
 			obj.setSomatization(record.getStr("somatization"));
 			obj.setOddBehav(record.getStr("oddBehav"));
 			obj.setInterpersonal(record.getStr("interpersonal"));
 			obj.setSocialPress(record.getStr("socialPress"));
 			obj.setDegenerate(record.getStr("degenerate"));
 			obj.setBully(record.getStr("bully"));
 			obj.setAttention(record.getStr("attention"));
 			obj.setInattention(record.getStr("inattention"));
 			obj.setMania(record.getStr("mania"));
 			obj.setAddiction(record.getStr("addiction"));
 			obj.setNetAddiction(record.getStr("netAddiction"));
 			obj.setPhoneAddiction(record.getStr("phoneAddiction"));
 			obj.setWeariness(record.getStr("weariness"));
 			obj.setHateSchool(record.getStr("hateSchool"));
 			obj.setHateTeacher(record.getStr("hateTeacher"));
 			obj.setHateStudy(record.getStr("hateStudy"));
 			obj.setAnxExam(record.getStr("anxExam"));
 			obj.setAutolesionIdx(record.getStr("autolesionIdx"));
 			obj.setHelplessnessIdx(record.getStr("helplessnessIdx"));
 			obj.setInterpersonalIdx(record.getStr("interpersonalIdx"));
 			obj.setAddictionIdx(record.getStr("addictionIdx"));
 			obj.setBullyIdx(record.getStr("bullyIdx"));
 			obj.setBehavIdx(record.getStr("behavIdx"));
 			obj.setManiaIdx(record.getStr("maniaIdx"));
 			obj.setPoorHealthIdx(record.getStr("poorHealthIdx"));
 			obj.setWearinessIdx(record.getStr("wearinessIdx"));
 			obj.setDistractionIdx(record.getStr("distractionIdx"));
 			obj.setAnxExamIdx(record.getStr("anxExamIdx"));
 			obj.setConflictIdx(record.getStr("conflictIdx"));
			objs.add(obj);
		}
 		return objs;
	}
    
	private static void processClsProBlmReps() {
		logger.debug("正在获取班级问题行为报告数据");
		List<ClsProBlmRep> pbObjs = getClsProBlmReps();
		
		logger.debug("获取班级问题行为报告数据结束");
		IReport iReport  = new PdfReport();
		List<String> sqls = new ArrayList<String>();
		for(ClsProBlmRep pbObj: pbObjs) {
			logger.debug("正在处理报告:"+pbObj.getId()+",班级:"+pbObj.getClassName());
			String file_path = iReport.createClsProBlmReport(pbObj, pbObj.getClassId()+"_"+DateUtil.format(new Date()));
			
			sqls.add("update class_problem_behavior set is_generate=1,generate_path='"+file_path.substring(1)+"' where id="+pbObj.getId());
			logger.debug("完成处理报告:"+pbObj.getId()+",班级:"+pbObj.getClassName());
		}
		logger.debug("正在回写班级问题行为报告数据库...+共:"+sqls.size()+"记录");
		//Db.batch(sqls, sqls.size());
		logger.debug("回写完成");
	}
	private static List<ClsProBlmRep> getClsProBlmReps(){
    	StringBuffer sqlBuf = new StringBuffer();
    	sqlBuf.append("SELECT\r\n"+
	" a.id,\r\n"+
	" a.school_id,\r\n"+
	" a.grade_id,\r\n"+
	" a.class_id,\r\n"+
	" a.test_stu_num,\r\n"+
	" a.test_stu_percent,\r\n"+
	" a.stu_sex_percent,\r\n"+
	" a.stu_birthday_rang,\r\n"+
	" a.test_date,\r\n"+
	" a.test_deficiency_percent,\r\n"+
	" a.test_deficiency_num,\r\n"+
	" a.test_deficiency_list,\r\n"+
	" a.test_time_percent,\r\n"+
	" a.test_time_num,\r\n"+
	" a.test_time_list,\r\n"+
	" a.available_l_percent,\r\n"+
	" a.available_l_num,\r\n"+
	" a.available_l_list,\r\n"+
	" a.available_f_percent,\r\n"+
	" a.available_f_num,\r\n"+
	" a.available_f_list,\r\n"+
	" a.available_c_percent,\r\n"+
	" a.available_c_num,\r\n"+
	" a.available_c_list,\r\n"+
	" a.anxious_norisk_num,\r\n"+
	" a.anxious_potentialrisk_num,\r\n"+
	" a.anxious_risk_num,\r\n"+
	" a.anxious_potentialrisk_list,\r\n"+
	" a.anxious_risk_list,\r\n"+
	" a.depressed_norisk_num,\r\n"+
	" a.depressed_potentialrisk_num,\r\n"+
	" a.depressed_risk_num,\r\n"+
	" a.depressed_potentialrisk_list,\r\n"+
	" a.depressed_risk_list,\r\n"+
	" a.somatization_norisk_num,\r\n"+
	" a.somatization_potentialrisk_num,\r\n"+
	" a.somatization_risk_num,\r\n"+
	" a.somatization_potentialrisk_list,\r\n"+
	" a.somatization_risk_list,\r\n"+
	" a.uncontrol_norisk_num,\r\n"+
	" a.uncontrol_potentialrisk_num,\r\n"+
	" a.uncontrol_risk_num,\r\n"+
	" a.uncontrol_potentialrisk_list,\r\n"+
	" a.uncontrol_risk_list,\r\n"+
	" a.fail_norisk_num,\r\n"+
	" a.fail_potentialrisk_num,\r\n"+
	" a.fail_risk_num,\r\n"+
	" a.fail_potentialrisk_list,\r\n"+
	" a.fail_risk_list,\r\n"+
	" a.oddbehavior_norisk_num,\r\n"+
	" a.oddbehavior_potentialrisk_num,\r\n"+
	" a.oddbehavior_risk_num,\r\n"+
	" a.oddbehavior_potentialrisk_list,\r\n"+
	" a.oddbehavior_risk_list,\r\n"+
	" a.pressure_norisk_num,\r\n"+
	" a.pressure_potentialrisk_num,\r\n"+
	" a.pressure_risk_num,\r\n"+
	" a.pressure_potentialrisk_list,\r\n"+
	" a.pressure_risk_list,\r\n"+
	" a.degenerate_norisk_num,\r\n"+
	" a.degenerate_potentialrisk_num,\r\n"+
	" a.degenerate_risk_num,\r\n"+
	" a.degenerate_potentialrisk_list,\r\n"+
	" a.degenerate_risk_list,\r\n"+
	" a.bully_norisk_num,\r\n"+
	" a.bully_potentialrisk_num,\r\n"+
	" a.bully_risk_num,\r\n"+
	" a.bully_potentialrisk_list,\r\n"+
	" a.bully_risk_list,\r\n"+
	" a.inattention_norisk_num,\r\n"+
	" a.inattention_potentialrisk_num,\r\n"+
	" a.inattention_risk_num,\r\n"+
	" a.inattention_potentialrisk_list,\r\n"+
	" a.inattention_risk_list,\r\n"+
	" a.mania_norisk_num,\r\n"+
	" a.mania_potentialrisk_num,\r\n"+
	" a.mania_risk_num,\r\n"+
	" a.mania_potentialrisk_list,\r\n"+
	" a.mania_risk_list,\r\n"+
	" a.netaddiction_norisk_num,\r\n"+
	" a.netaddiction_potentialrisk_num,\r\n"+
	" a.netaddiction_risk_num,\r\n"+
	" a.netaddiction_potentialrisk_list,\r\n"+
	" a.netaddiction_risk_list,\r\n"+
	" a.phoneaddiction_norisk_num,\r\n"+
	" a.phoneaddiction_potentialrisk_num,\r\n"+
	" a.phoneaddiction_risk_num,\r\n"+
	" a.phoneaddiction_potentialrisk_list,\r\n"+
	" a.phoneaddiction_risk_list,\r\n"+
	" a.hateschool_norisk_num,\r\n"+
	" a.hateschool_potentialrisk_num,\r\n"+
	" a.hateschool_risk_num,\r\n"+
	" a.hateschool_potentialrisk_list,\r\n"+
	" a.hateschool_risk_list,\r\n"+
	" a.hateteacher_norisk_num,\r\n"+
	" a.hateteacher_potentialrisk_num,\r\n"+
	" a.hateteacher_risk_num,\r\n"+
	" a.hateteacher_potentialrisk_list,\r\n"+
	" a.hateteacher_risk_list,\r\n"+
	" a.hatestudy_norisk_num,\r\n"+
	" a.hatestudy_potentialrisk_num,\r\n"+
	" a.hatestudy_risk_num,\r\n"+
	" a.hatestudy_potentialrisk_list,\r\n"+
	" a.hatestudy_risk_list,\r\n"+
	" a.anxexam_norisk_num,\r\n"+
	" a.anxexam_potentialrisk_num,\r\n"+
	" a.anxexam_risk_num,\r\n"+
	" a.anxexam_potentialrisk_list,\r\n"+
	" a.anxexam_risk_list,\r\n"+
	" a.autolesionidx_norisk_num,\r\n"+
	" a.autolesionidx_potentialrisk_num,\r\n"+
	" a.autolesionidx_risk_num,\r\n"+
	" a.autolesionidx_potentialrisk_list,\r\n"+
	" a.autolesionidx_risk_list,\r\n"+
	" a.helplessnessidx_norisk_num,\r\n"+
	" a.helplessnessidx_potentialrisk_num,\r\n"+
	" a.helplessnessidx_risk_num,\r\n"+
	" a.helplessnessidx_potentialrisk_list,\r\n"+
	" a.helplessnessidx_risk_list,\r\n"+
	" a.interpersonalidx_norisk_num,\r\n"+
	" a.interpersonalidx_potentialrisk_num,\r\n"+
	" a.interpersonalidx_risk_num,\r\n"+
	" a.interpersonalidx_potentialrisk_list,\r\n"+
	" a.interpersonalidx_risk_list,\r\n"+
	" a.addictionidx_norisk_num,\r\n"+
	" a.addictionidx_potentialrisk_num,\r\n"+
	" a.addictionidx_risk_num,\r\n"+
	" a.addictionidx_potentialrisk_list,\r\n"+
	" a.addictionidx_risk_list,\r\n"+
	" a.bullyidx_norisk_num,\r\n"+
	" a.bullyidx_potentialrisk_num,\r\n"+
	" a.bullyidx_risk_num,\r\n"+
	" a.bullyidx_potentialrisk_list,\r\n"+
	" a.bullyidx_risk_list,\r\n"+
	" a.behavidx_norisk_num,\r\n"+
	" a.behavidx_potentialrisk_num,\r\n"+
	" a.behavidx_risk_num,\r\n"+
	" a.behavidx_potentialrisk_list,\r\n"+
	" a.behavidx_risk_list,\r\n"+
	" a.maniaidx_norisk_num,\r\n"+
	" a.maniaidx_potentialrisk_num,\r\n"+
	" a.maniaidx_risk_num,\r\n"+
	" a.maniaidx_potentialrisk_list,\r\n"+
	" a.maniaidx_risk_list,\r\n"+
	" a.poorhealthidx_norisk_num,\r\n"+
	" a.poorhealthidx_potentialrisk_num,\r\n"+
	" a.poorhealthidx_risk_num,\r\n"+
	" a.poorhealthidx_potentialrisk_list,\r\n"+
	" a.poorhealthidx_risk_list,\r\n"+
	" a.wearinessidx_norisk_num,\r\n"+
	" a.wearinessidx_potentialrisk_num,\r\n"+
	" a.wearinessidx_risk_num,\r\n"+
	" a.wearinessidx_potentialrisk_list,\r\n"+
	" a.wearinessidx_risk_list,\r\n"+
	" a.distractionidx_norisk_num,\r\n"+
	" a.distractionidx_potentialrisk_num,\r\n"+
	" a.distractionidx_risk_num,\r\n"+
	" a.distractionidx_potentialrisk_list,\r\n"+
	" a.distractionidx_risk_list,\r\n"+
	" a.anxexamidx_norisk_num,\r\n"+
	" a.anxexamidx_potentialrisk_num,\r\n"+
	" a.anxexamidx_risk_num,\r\n"+
	" a.anxexamidx_potentialrisk_list,\r\n"+
	" a.anxexamidx_risk_list,\r\n"+
	" a.conflictidx_norisk_num,\r\n"+
	" a.conflictidx_potentialrisk_num,\r\n"+
	" a.conflictidx_risk_num,\r\n"+
	" a.conflictidx_potentialrisk_list,\r\n"+
	" a.conflictidx_risk_list,\r\n"+
	" a.is_generate,\r\n"+
	" a.generate_path,\r\n"+
	" c.class as className\r\n"+
" FROM\r\n"+
	" class_problem_behavior  a join class c ON a.class_id = c.id where a.is_generate=0");
 		List<Record> records = Db.find(sqlBuf.toString());
 		List<ClsProBlmRep> objs = new ArrayList<ClsProBlmRep>();
 		for(Record record : records) {
 			ClsProBlmRep obj = new ClsProBlmRep();
 			obj.setId(record.getStr("id"));
 			obj.setSchoolId(record.getStr("school_id"));
 			obj.setGradeId(record.getStr("grade_id"));
 			obj.setClassId(record.getStr("class_id"));
 			obj.setTestStuNum(record.getStr("test_stu_num"));
 			obj.setTestStuPercent(record.getStr("test_stu_percent"));
 			obj.setStuSexPercent(record.getStr("stu_sex_percent"));
 			obj.setStuBirthdayRang(record.getStr("stu_birthday_rang"));
 			obj.setTestDate(record.getStr("test_date"));
 			obj.setTestDeficiencyPercent(record.getStr("test_deficiency_percent"));
 			obj.setTestDeficiencyNum(record.getStr("test_deficiency_num"));
 			obj.setTestDeficiencyList(record.getStr("test_deficiency_list"));
 			obj.setTestTimePercent(record.getStr("test_time_percent"));
 			obj.setTestTimeNum(record.getStr("test_time_num"));
 			obj.setTestTimeList(record.getStr("test_time_list"));
 			obj.setAvailableLPercent(record.getStr("available_l_percent"));
 			obj.setAvailableLNum(record.getStr("available_l_num"));
 			obj.setAvailableLList(record.getStr("available_l_list"));
 			obj.setAvailableFPercent(record.getStr("available_f_percent"));
 			obj.setAvailableFNum(record.getStr("available_f_num"));
 			obj.setAvailableFList(record.getStr("available_f_list"));
 			obj.setAvailableCPercent(record.getStr("available_c_percent"));
 			obj.setAvailableCNum(record.getStr("available_c_num"));
 			obj.setAvailableCList(record.getStr("available_c_list"));
 			obj.setAnxiousNoriskNum(record.getStr("anxious_norisk_num"));
 			obj.setAnxiousPotentialriskNum(record.getStr("anxious_potentialrisk_num"));
 			obj.setAnxiousRiskNum(record.getStr("anxious_risk_num"));
 			obj.setAnxiousPotentialriskList(record.getStr("anxious_potentialrisk_list"));
 			obj.setAnxiousRiskList(record.getStr("anxious_risk_list"));
 			obj.setDepressedNoriskNum(record.getStr("depressed_norisk_num"));
 			obj.setDepressedPotentialriskNum(record.getStr("depressed_potentialrisk_num"));
 			obj.setDepressedRiskNum(record.getStr("depressed_risk_num"));
 			obj.setDepressedPotentialriskList(record.getStr("depressed_potentialrisk_list"));
 			obj.setDepressedRiskList(record.getStr("depressed_risk_list"));
 			obj.setSomatizationNoriskNum(record.getStr("somatization_norisk_num"));
 			obj.setSomatizationPotentialriskNum(record.getStr("somatization_potentialrisk_num"));
 			obj.setSomatizationRiskNum(record.getStr("somatization_risk_num"));
 			obj.setSomatizationPotentialriskList(record.getStr("somatization_potentialrisk_list"));
 			obj.setSomatizationRiskList(record.getStr("somatization_risk_list"));
 			obj.setUncontrolNoriskNum(record.getStr("uncontrol_norisk_num"));
 			obj.setUncontrolPotentialriskNum(record.getStr("uncontrol_potentialrisk_num"));
 			obj.setUncontrolRiskNum(record.getStr("uncontrol_risk_num"));
 			obj.setUncontrolPotentialriskList(record.getStr("uncontrol_potentialrisk_list"));
 			obj.setUncontrolRiskList(record.getStr("uncontrol_risk_list"));
 			obj.setFailNoriskNum(record.getStr("fail_norisk_num"));
 			obj.setFailPotentialriskNum(record.getStr("fail_potentialrisk_num"));
 			obj.setFailRiskNum(record.getStr("fail_risk_num"));
 			obj.setFailPotentialriskList(record.getStr("fail_potentialrisk_list"));
 			obj.setFailRiskList(record.getStr("fail_risk_list"));
 			obj.setOddbehaviorNoriskNum(record.getStr("oddbehavior_norisk_num"));
 			obj.setOddbehaviorPotentialriskNum(record.getStr("oddbehavior_potentialrisk_num"));
 			obj.setOddbehaviorRiskNum(record.getStr("oddbehavior_risk_num"));
 			obj.setOddbehaviorPotentialriskList(record.getStr("oddbehavior_potentialrisk_list"));
 			obj.setOddbehaviorRiskList(record.getStr("oddbehavior_risk_list"));
 			obj.setPressureNoriskNum(record.getStr("pressure_norisk_num"));
 			obj.setPressurePotentialriskNum(record.getStr("pressure_potentialrisk_num"));
 			obj.setPressureRiskNum(record.getStr("pressure_risk_num"));
 			obj.setPressurePotentialriskList(record.getStr("pressure_potentialrisk_list"));
 			obj.setPressureRiskList(record.getStr("pressure_risk_list"));
 			obj.setDegenerateNoriskNum(record.getStr("degenerate_norisk_num"));
 			obj.setDegeneratePotentialriskNum(record.getStr("degenerate_potentialrisk_num"));
 			obj.setDegenerateRiskNum(record.getStr("degenerate_risk_num"));
 			obj.setDegeneratePotentialriskList(record.getStr("degenerate_potentialrisk_list"));
 			obj.setDegenerateRiskList(record.getStr("degenerate_risk_list"));
 			obj.setBullyNoriskNum(record.getStr("bully_norisk_num"));
 			obj.setBullyPotentialriskNum(record.getStr("bully_potentialrisk_num"));
 			obj.setBullyRiskNum(record.getStr("bully_risk_num"));
 			obj.setBullyPotentialriskList(record.getStr("bully_potentialrisk_list"));
 			obj.setBullyRiskList(record.getStr("bully_risk_list"));
 			obj.setInattentionNoriskNum(record.getStr("inattention_norisk_num"));
 			obj.setInattentionPotentialriskNum(record.getStr("inattention_potentialrisk_num"));
 			obj.setInattentionRiskNum(record.getStr("inattention_risk_num"));
 			obj.setInattentionPotentialriskList(record.getStr("inattention_potentialrisk_list"));
 			obj.setInattentionRiskList(record.getStr("inattention_risk_list"));
 			obj.setManiaNoriskNum(record.getStr("mania_norisk_num"));
 			obj.setManiaPotentialriskNum(record.getStr("mania_potentialrisk_num"));
 			obj.setManiaRiskNum(record.getStr("mania_risk_num"));
 			obj.setManiaPotentialriskList(record.getStr("mania_potentialrisk_list"));
 			obj.setManiaRiskList(record.getStr("mania_risk_list"));
 			obj.setNetaddictionNoriskNum(record.getStr("netaddiction_norisk_num"));
 			obj.setNetaddictionPotentialriskNum(record.getStr("netaddiction_potentialrisk_num"));
 			obj.setNetaddictionRiskNum(record.getStr("netaddiction_risk_num"));
 			obj.setNetaddictionPotentialriskList(record.getStr("netaddiction_potentialrisk_list"));
 			obj.setNetaddictionRiskList(record.getStr("netaddiction_risk_list"));
 			obj.setPhoneaddictionNoriskNum(record.getStr("phoneaddiction_norisk_num"));
 			obj.setPhoneaddictionPotentialriskNum(record.getStr("phoneaddiction_potentialrisk_num"));
 			obj.setPhoneaddictionRiskNum(record.getStr("phoneaddiction_risk_num"));
 			obj.setPhoneaddictionPotentialriskList(record.getStr("phoneaddiction_potentialrisk_list"));
 			obj.setPhoneaddictionRiskList(record.getStr("phoneaddiction_risk_list"));
 			obj.setHateschoolNoriskNum(record.getStr("hateschool_norisk_num"));
 			obj.setHateschoolPotentialriskNum(record.getStr("hateschool_potentialrisk_num"));
 			obj.setHateschoolRiskNum(record.getStr("hateschool_risk_num"));
 			obj.setHateschoolPotentialriskList(record.getStr("hateschool_potentialrisk_list"));
 			obj.setHateschoolRiskList(record.getStr("hateschool_risk_list"));
 			obj.setHateteacherNoriskNum(record.getStr("hateteacher_norisk_num"));
 			obj.setHateteacherPotentialriskNum(record.getStr("hateteacher_potentialrisk_num"));
 			obj.setHateteacherRiskNum(record.getStr("hateteacher_risk_num"));
 			obj.setHateteacherPotentialriskList(record.getStr("hateteacher_potentialrisk_list"));
 			obj.setHateteacherRiskList(record.getStr("hateteacher_risk_list"));
 			obj.setHatestudyNoriskNum(record.getStr("hatestudy_norisk_num"));
 			obj.setHatestudyPotentialriskNum(record.getStr("hatestudy_potentialrisk_num"));
 			obj.setHatestudyRiskNum(record.getStr("hatestudy_risk_num"));
 			obj.setHatestudyPotentialriskList(record.getStr("hatestudy_potentialrisk_list"));
 			obj.setHatestudyRiskList(record.getStr("hatestudy_risk_list"));
 			obj.setAnxexamNoriskNum(record.getStr("anxexam_norisk_num"));
 			obj.setAnxexamPotentialriskNum(record.getStr("anxexam_potentialrisk_num"));
 			obj.setAnxexamRiskNum(record.getStr("anxexam_risk_num"));
 			obj.setAnxexamPotentialriskList(record.getStr("anxexam_potentialrisk_list"));
 			obj.setAnxexamRiskList(record.getStr("anxexam_risk_list"));
 			obj.setAutolesionidxNoriskNum(record.getStr("autolesionidx_norisk_num"));
 			obj.setAutolesionidxPotentialriskNum(record.getStr("autolesionidx_potentialrisk_num"));
 			obj.setAutolesionidxRiskNum(record.getStr("autolesionidx_risk_num"));
 			obj.setAutolesionidxPotentialriskList(record.getStr("autolesionidx_potentialrisk_list"));
 			obj.setAutolesionidxRiskList(record.getStr("autolesionidx_risk_list"));
 			obj.setHelplessnessidxNoriskNum(record.getStr("helplessnessidx_norisk_num"));
 			obj.setHelplessnessidxPotentialriskNum(record.getStr("helplessnessidx_potentialrisk_num"));
 			obj.setHelplessnessidxRiskNum(record.getStr("helplessnessidx_risk_num"));
 			obj.setHelplessnessidxPotentialriskList(record.getStr("helplessnessidx_potentialrisk_list"));
 			obj.setHelplessnessidxRiskList(record.getStr("helplessnessidx_risk_list"));
 			obj.setInterpersonalidxNoriskNum(record.getStr("interpersonalidx_norisk_num"));
 			obj.setInterpersonalidxPotentialriskNum(record.getStr("interpersonalidx_potentialrisk_num"));
 			obj.setInterpersonalidxRiskNum(record.getStr("interpersonalidx_risk_num"));
 			obj.setInterpersonalidxPotentialriskList(record.getStr("interpersonalidx_potentialrisk_list"));
 			obj.setInterpersonalidxRiskList(record.getStr("interpersonalidx_risk_list"));
 			obj.setAddictionidxNoriskNum(record.getStr("addictionidx_norisk_num"));
 			obj.setAddictionidxPotentialriskNum(record.getStr("addictionidx_potentialrisk_num"));
 			obj.setAddictionidxRiskNum(record.getStr("addictionidx_risk_num"));
 			obj.setAddictionidxPotentialriskList(record.getStr("addictionidx_potentialrisk_list"));
 			obj.setAddictionidxRiskList(record.getStr("addictionidx_risk_list"));
 			obj.setBullyidxNoriskNum(record.getStr("bullyidx_norisk_num"));
 			obj.setBullyidxPotentialriskNum(record.getStr("bullyidx_potentialrisk_num"));
 			obj.setBullyidxRiskNum(record.getStr("bullyidx_risk_num"));
 			obj.setBullyidxPotentialriskList(record.getStr("bullyidx_potentialrisk_list"));
 			obj.setBullyidxRiskList(record.getStr("bullyidx_risk_list"));
 			obj.setBehavidxNoriskNum(record.getStr("behavidx_norisk_num"));
 			obj.setBehavidxPotentialriskNum(record.getStr("behavidx_potentialrisk_num"));
 			obj.setBehavidxRiskNum(record.getStr("behavidx_risk_num"));
 			obj.setBehavidxPotentialriskList(record.getStr("behavidx_potentialrisk_list"));
 			obj.setBehavidxRiskList(record.getStr("behavidx_risk_list"));
 			obj.setManiaidxNoriskNum(record.getStr("maniaidx_norisk_num"));
 			obj.setManiaidxPotentialriskNum(record.getStr("maniaidx_potentialrisk_num"));
 			obj.setManiaidxRiskNum(record.getStr("maniaidx_risk_num"));
 			obj.setManiaidxPotentialriskList(record.getStr("maniaidx_potentialrisk_list"));
 			obj.setManiaidxRiskList(record.getStr("maniaidx_risk_list"));
 			obj.setPoorhealthidxNoriskNum(record.getStr("poorhealthidx_norisk_num"));
 			obj.setPoorhealthidxPotentialriskNum(record.getStr("poorhealthidx_potentialrisk_num"));
 			obj.setPoorhealthidxRiskNum(record.getStr("poorhealthidx_risk_num"));
 			obj.setPoorhealthidxPotentialriskList(record.getStr("poorhealthidx_potentialrisk_list"));
 			obj.setPoorhealthidxRiskList(record.getStr("poorhealthidx_risk_list"));
 			obj.setWearinessidxNoriskNum(record.getStr("wearinessidx_norisk_num"));
 			obj.setWearinessidxPotentialriskNum(record.getStr("wearinessidx_potentialrisk_num"));
 			obj.setWearinessidxRiskNum(record.getStr("wearinessidx_risk_num"));
 			obj.setWearinessidxPotentialriskList(record.getStr("wearinessidx_potentialrisk_list"));
 			obj.setWearinessidxRiskList(record.getStr("wearinessidx_risk_list"));
 			obj.setDistractionidxNoriskNum(record.getStr("distractionidx_norisk_num"));
 			obj.setDistractionidxPotentialriskNum(record.getStr("distractionidx_potentialrisk_num"));
 			obj.setDistractionidxRiskNum(record.getStr("distractionidx_risk_num"));
 			obj.setDistractionidxPotentialriskList(record.getStr("distractionidx_potentialrisk_list"));
 			obj.setDistractionidxRiskList(record.getStr("distractionidx_risk_list"));
 			obj.setAnxexamidxNoriskNum(record.getStr("anxexamidx_norisk_num"));
 			obj.setAnxexamidxPotentialriskNum(record.getStr("anxexamidx_potentialrisk_num"));
 			obj.setAnxexamidxRiskNum(record.getStr("anxexamidx_risk_num"));
 			obj.setAnxexamidxPotentialriskList(record.getStr("anxexamidx_potentialrisk_list"));
 			obj.setAnxexamidxRiskList(record.getStr("anxexamidx_risk_list"));
 			obj.setConflictidxNoriskNum(record.getStr("conflictidx_norisk_num"));
 			obj.setConflictidxPotentialriskNum(record.getStr("conflictidx_potentialrisk_num"));
 			obj.setConflictidxRiskNum(record.getStr("conflictidx_risk_num"));
 			obj.setConflictidxPotentialriskList(record.getStr("conflictidx_potentialrisk_list"));
 			obj.setConflictidxRiskList(record.getStr("conflictidx_risk_list"));
 			obj.setClassName(record.getStr("className"));
 			objs.add(obj);
 		}
 		
 		return objs;
    }
	private static void processClsPsyReps() {
		logger.debug("正在获取班级积极心理品质报告数据");
		List<ClsPsyRep> pbObjs = getClsPsyReps();
		
		logger.debug("获取班级积极心理品质报告数据结束");
		IReport iReport  = new PdfReport();
		List<String> sqls = new ArrayList<String>();
		for(ClsPsyRep pbObj: pbObjs) {
			logger.debug("正在处理报告:"+pbObj.getId()+",班级:"+pbObj.getClassName());
			String file_path = iReport.createClsPsyQualityReport(pbObj, pbObj.getClassId()+"_"+DateUtil.format(new Date()));
			
			sqls.add("update class_positive_psychology set is_generate=1,generate_path='"+file_path.substring(1)+"' where id="+pbObj.getId());
			logger.debug("完成处理报告:"+pbObj.getId()+",班级:"+pbObj.getClassName());
		}
		logger.debug("正在回写班级积极心理品质报告数据库...+共:"+sqls.size()+"记录");
		//Db.batch(sqls, sqls.size());
		logger.debug("回写完成");
	}
	private static List<ClsPsyRep> getClsPsyReps(){
    	StringBuffer sqlBuf = new StringBuffer();
    	sqlBuf.append("SELECT\r\n"+
	" a.id,\r\n"+
	" a.school_id,\r\n"+
	" a.grade_id,\r\n"+
	" a.class_id,\r\n"+
	" c.class as className,\r\n"+
	" a.test_stu_num,\r\n"+
	" a.test_stu_percent,\r\n"+
	" a.stu_sex_percent,\r\n"+
	" a.stu_birthday_rang,\r\n"+
	" a.test_date,\r\n"+
	" a.accuracy_percent,\r\n"+
	" a.accuracy_num,\r\n"+
	" a.accuracy_list,\r\n"+
	" a.tendentiousness_percent,\r\n"+
	" a.tendentiousness_num,\r\n"+
	" a.tendentiousness_list,\r\n"+
	" a.consistency_percent,\r\n"+
	" a.consistency_num,\r\n"+
	" a.consistency_list,\r\n"+
	" a.stability_percent,\r\n"+
	" a.stability_num,\r\n"+
	" a.stability_list,\r\n"+
	" a.companion_high_num,\r\n"+
	" a.companion_middle_num,\r\n"+
	" a.companion_low_num,\r\n"+
	" a.companion_high_list,\r\n"+
	" a.companion_low_list,\r\n"+
	" a.parenthood_high_num,\r\n"+
	" a.parenthood_middle_num,\r\n"+
	" a.parenthood_low_num,\r\n"+
	" a.parenthood_high_list,\r\n"+
	" a.parenthood_low_list,\r\n"+
	" a.tsrelation_high_num,\r\n"+
	" a.tsrelation_middle_num,\r\n"+
	" a.tsrelation_low_num,\r\n"+
	" a.tsrelation_high_list,\r\n"+
	" a.tsrelation_low_list,\r\n"+
	" a.agreeableness_high_num,\r\n"+
	" a.agreeableness_middle_num,\r\n"+
	" a.agreeableness_low_num,\r\n"+
	" a.agreeableness_high_list,\r\n"+
	" a.agreeableness_low_list,\r\n"+
	" a.resilience_high_num,\r\n"+
	" a.resilience_middle_num,\r\n"+
	" a.resilience_low_num,\r\n"+
	" a.resilience_high_list,\r\n"+
	" a.resilience_low_list,\r\n"+
	" a.selfesteem_high_num,\r\n"+
	" a.selfesteem_middle_num,\r\n"+
	" a.selfesteem_low_num,\r\n"+
	" a.selfesteem_high_list,\r\n"+
	" a.selfesteem_low_list,\r\n"+
	" a.selfcontroll_high_num,\r\n"+
	" a.selfcontroll_middle_num,\r\n"+
	" a.selfcontroll_low_num,\r\n"+
	" a.selfcontroll_high_list,\r\n"+
	" a.selfcontroll_low_list,\r\n"+
	" a.socialactive_high_num,\r\n"+
	" a.socialactive_middle_num,\r\n"+
	" a.socialactive_low_num,\r\n"+
	" a.socialactive_high_list,\r\n"+
	" a.socialactive_low_list,\r\n"+
	" a.learningresponsibility_high_num,\r\n"+
	" a.learningresponsibility_middle_num,\r\n"+
	" a.learningresponsibility_low_num,\r\n"+
	" a.learningresponsibility_high_list,\r\n"+
	" a.learningresponsibility_low_list,\r\n"+
	" a.continueinterest_high_num,\r\n"+
	" a.continueinterest_middle_num,\r\n"+
	" a.continueinterest_low_num,\r\n"+
	" a.continueinterest_high_list,\r\n"+
	" a.continueinterest_low_list,\r\n"+
	" a.continueeffort_high_num,\r\n"+
	" a.continueeffort_middle_num,\r\n"+
	" a.continueeffort_low_num,\r\n"+
	" a.continueeffort_high_list,\r\n"+
	" a.continueeffort_low_list,\r\n"+
	" a.situationcorrect_high_num,\r\n"+
	" a.situationcorrect_middle_num,\r\n"+
	" a.situationcorrect_low_num,\r\n"+
	" a.situationcorrect_high_list,\r\n"+
	" a.situationcorrect_low_list,\r\n"+
	" a.attentiondistribution_high_num,\r\n"+
	" a.attentiondistribution_middle_num,\r\n"+
	" a.attentiondistribution_low_num,\r\n"+
	" a.attentiondistribution_high_list,\r\n"+
	" a.attentiondistribution_low_list,\r\n"+
	" a.cognitivechange_high_num,\r\n"+
	" a.cognitivechange_middle_num,\r\n"+
	" a.cognitivechange_low_num,\r\n"+
	" a.cognitivechange_high_list,\r\n"+
	" a.cognitivechange_low_list,\r\n"+
	" a.responsemod_high_num,\r\n"+
	" a.responsemod_middle_num,\r\n"+
	" a.responsemod_low_num,\r\n"+
	" a.responsemod_high_list,\r\n"+
	" a.responsemod_low_list,\r\n"+
	" a.is_generate,\r\n"+
	" a.generate_path\r\n"+
" FROM\r\n"+
	" class_positive_psychology a join class c ON a.class_id = c.id where a.is_generate=0");

 		List<Record> records = Db.find(sqlBuf.toString());
 		List<ClsPsyRep> objs = new ArrayList<ClsPsyRep>();
 		for(Record record:records) {
 			ClsPsyRep obj = new ClsPsyRep();
 			obj.setId(record.getStr("id"));
 			obj.setClassName(record.getStr("className"));
 			obj.setSchoolId(record.getStr("school_id"));
 			obj.setGradeId(record.getStr("grade_id"));
 			obj.setClassId(record.getStr("class_id"));
 			obj.setTestStuNum(record.getStr("test_stu_num"));
 			obj.setTestStuPercent(record.getStr("test_stu_percent"));
 			obj.setStuSexPercent(record.getStr("stu_sex_percent"));
 			obj.setStuBirthdayRang(record.getStr("stu_birthday_rang"));
 			obj.setTestDate(record.getStr("test_date"));
 			obj.setAccuracyPercent(record.getStr("accuracy_percent"));
 			obj.setAccuracyNum(record.getStr("accuracy_num"));
 			obj.setAccuracyList(record.getStr("accuracy_list"));
 			obj.setTendentiousnessPercent(record.getStr("tendentiousness_percent"));
 			obj.setTendentiousnessNum(record.getStr("tendentiousness_num"));
 			obj.setTendentiousnessList(record.getStr("tendentiousness_list"));
 			obj.setConsistencyPercent(record.getStr("consistency_percent"));
 			obj.setConsistencyNum(record.getStr("consistency_num"));
 			obj.setConsistencyList(record.getStr("consistency_list"));
 			obj.setStabilityPercent(record.getStr("stability_percent"));
 			obj.setStabilityNum(record.getStr("stability_num"));
 			obj.setStabilityList(record.getStr("stability_list"));
 			obj.setCompanionHighNum(record.getStr("companion_high_num"));
 			obj.setCompanionMiddleNum(record.getStr("companion_middle_num"));
 			obj.setCompanionLowNum(record.getStr("companion_low_num"));
 			obj.setCompanionHighList(record.getStr("companion_high_list"));
 			obj.setCompanionLowList(record.getStr("companion_low_list"));
 			obj.setParenthoodHighNum(record.getStr("parenthood_high_num"));
 			obj.setParenthoodMiddleNum(record.getStr("parenthood_middle_num"));
 			obj.setParenthoodLowNum(record.getStr("parenthood_low_num"));
 			obj.setParenthoodHighList(record.getStr("parenthood_high_list"));
 			obj.setParenthoodLowList(record.getStr("parenthood_low_list"));
 			obj.setTsrelationHighNum(record.getStr("tsrelation_high_num"));
 			obj.setTsrelationMiddleNum(record.getStr("tsrelation_middle_num"));
 			obj.setTsrelationLowNum(record.getStr("tsrelation_low_num"));
 			obj.setTsrelationHighList(record.getStr("tsrelation_high_list"));
 			obj.setTsrelationLowList(record.getStr("tsrelation_low_list"));
 			obj.setAgreeablenessHighNum(record.getStr("agreeableness_high_num"));
 			obj.setAgreeablenessMiddleNum(record.getStr("agreeableness_middle_num"));
 			obj.setAgreeablenessLowNum(record.getStr("agreeableness_low_num"));
 			obj.setAgreeablenessHighList(record.getStr("agreeableness_high_list"));
 			obj.setAgreeablenessLowList(record.getStr("agreeableness_low_list"));
 			obj.setResilienceHighNum(record.getStr("resilience_high_num"));
 			obj.setResilienceMiddleNum(record.getStr("resilience_middle_num"));
 			obj.setResilienceLowNum(record.getStr("resilience_low_num"));
 			obj.setResilienceHighList(record.getStr("resilience_high_list"));
 			obj.setResilienceLowList(record.getStr("resilience_low_list"));
 			obj.setSelfesteemHighNum(record.getStr("selfesteem_high_num"));
 			obj.setSelfesteemMiddleNum(record.getStr("selfesteem_middle_num"));
 			obj.setSelfesteemLowNum(record.getStr("selfesteem_low_num"));
 			obj.setSelfesteemHighList(record.getStr("selfesteem_high_list"));
 			obj.setSelfesteemLowList(record.getStr("selfesteem_low_list"));
 			obj.setSelfcontrollHighNum(record.getStr("selfcontroll_high_num"));
 			obj.setSelfcontrollMiddleNum(record.getStr("selfcontroll_middle_num"));
 			obj.setSelfcontrollLowNum(record.getStr("selfcontroll_low_num"));
 			obj.setSelfcontrollHighList(record.getStr("selfcontroll_high_list"));
 			obj.setSelfcontrollLowList(record.getStr("selfcontroll_low_list"));
 			obj.setSocialactiveHighNum(record.getStr("socialactive_high_num"));
 			obj.setSocialactiveMiddleNum(record.getStr("socialactive_middle_num"));
 			obj.setSocialactiveLowNum(record.getStr("socialactive_low_num"));
 			obj.setSocialactiveHighList(record.getStr("socialactive_high_list"));
 			obj.setSocialactiveLowList(record.getStr("socialactive_low_list"));
 			obj.setLearningresponsibilityHighNum(record.getStr("learningresponsibility_high_num"));
 			obj.setLearningresponsibilityMiddleNum(record.getStr("learningresponsibility_middle_num"));
 			obj.setLearningresponsibilityLowNum(record.getStr("learningresponsibility_low_num"));
 			obj.setLearningresponsibilityHighList(record.getStr("learningresponsibility_high_list"));
 			obj.setLearningresponsibilityLowList(record.getStr("learningresponsibility_low_list"));
 			obj.setContinueinterestHighNum(record.getStr("continueinterest_high_num"));
 			obj.setContinueinterestMiddleNum(record.getStr("continueinterest_middle_num"));
 			obj.setContinueinterestLowNum(record.getStr("continueinterest_low_num"));
 			obj.setContinueinterestHighList(record.getStr("continueinterest_high_list"));
 			obj.setContinueinterestLowList(record.getStr("continueinterest_low_list"));
 			obj.setContinueeffortHighNum(record.getStr("continueeffort_high_num"));
 			obj.setContinueeffortMiddleNum(record.getStr("continueeffort_middle_num"));
 			obj.setContinueeffortLowNum(record.getStr("continueeffort_low_num"));
 			obj.setContinueeffortHighList(record.getStr("continueeffort_high_list"));
 			obj.setContinueeffortLowList(record.getStr("continueeffort_low_list"));
 			obj.setSituationcorrectHighNum(record.getStr("situationcorrect_high_num"));
 			obj.setSituationcorrectMiddleNum(record.getStr("situationcorrect_middle_num"));
 			obj.setSituationcorrectLowNum(record.getStr("situationcorrect_low_num"));
 			obj.setSituationcorrectHighList(record.getStr("situationcorrect_high_list"));
 			obj.setSituationcorrectLowList(record.getStr("situationcorrect_low_list"));
 			obj.setAttentiondistributionHighNum(record.getStr("attentiondistribution_high_num"));
 			obj.setAttentiondistributionMiddleNum(record.getStr("attentiondistribution_middle_num"));
 			obj.setAttentiondistributionLowNum(record.getStr("attentiondistribution_low_num"));
 			obj.setAttentiondistributionHighList(record.getStr("attentiondistribution_high_list"));
 			obj.setAttentiondistributionLowList(record.getStr("attentiondistribution_low_list"));
 			obj.setCognitivechangeHighNum(record.getStr("cognitivechange_high_num"));
 			obj.setCognitivechangeMiddleNum(record.getStr("cognitivechange_middle_num"));
 			obj.setCognitivechangeLowNum(record.getStr("cognitivechange_low_num"));
 			obj.setCognitivechangeHighList(record.getStr("cognitivechange_high_list"));
 			obj.setCognitivechangeLowList(record.getStr("cognitivechange_low_list"));
 			obj.setResponsemodHighNum(record.getStr("responsemod_high_num"));
 			obj.setResponsemodMiddleNum(record.getStr("responsemod_middle_num"));
 			obj.setResponsemodLowNum(record.getStr("responsemod_low_num"));
 			obj.setResponsemodHighList(record.getStr("responsemod_high_list"));
 			obj.setResponsemodLowList(record.getStr("responsemod_low_list"));
 			objs.add(obj);
 		}
 		return objs;
    }
}

