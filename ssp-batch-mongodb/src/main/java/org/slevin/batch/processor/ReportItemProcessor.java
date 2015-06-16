package org.slevin.batch.processor;

import org.slevin.batch.model.Report;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by jacky on 25/04/15.
 */
public class ReportItemProcessor implements ItemProcessor<Report, Report> {
    @Override
    public Report process(Report report) throws Exception {

        System.out.println("Processing report  : " + report.toString());
        return report;
    }
}
