package nuc.bsd.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import nuc.bsd.report.Impl.PdfReport;
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
		
		processProblemBehaviors();
	/*processPsyQualities();*/
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

}
