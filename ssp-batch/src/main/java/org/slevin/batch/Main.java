package org.slevin.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jacky on 02/04/15.
 */
public class Main {

    public static void main(String[] args) {

        String[] springConfig  =
                {
                        "classpath*:META-INF/spring/config/context.xml",
                        "classpath*:META-INF/spring/jobs/job-accounts.xml"
                };

        ApplicationContext context =
                new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("fromCsvToXmlAndCsvToXmlJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Done");

    }



    

}
