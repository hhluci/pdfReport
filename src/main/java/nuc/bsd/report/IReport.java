package nuc.bsd.report;

import nuc.bsd.report.domain.ClsProBlmRep;
import nuc.bsd.report.domain.ClsPsyRep;
import nuc.bsd.report.domain.ProblemBehavRep;
import nuc.bsd.report.domain.PsyQualityRep;

public interface IReport {

	public String createProblemBehaviorReport(ProblemBehavRep obj,String outDir);
	public String createPsyQualityReport(PsyQualityRep obj,String outDir);
	public String createClsProBlmReport(ClsProBlmRep obj,String outDir);
	public String createClsPsyQualityReport(ClsPsyRep obj,String outDir);
}
