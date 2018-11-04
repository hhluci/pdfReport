package nuc.bsd.report;

import java.util.Map;

import nuc.bsd.report.domain.ProblemBehavRep;
import nuc.bsd.report.domain.PsyQualityRep;

public interface IReport {

	public String createProblemBehaviorReport(ProblemBehavRep obj,String outDir);
	public String createPsyQualityReport(PsyQualityRep obj,String outDir);
}
