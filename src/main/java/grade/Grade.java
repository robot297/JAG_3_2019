package grade;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import grade.model.GradeScheme;
import grade.model.Question;
import grade.model.TestFileResults;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Grade {
    
    
    public static void main(String[] args) throws  Exception{
        
        // Read grades week_X.json file
        
        GradeScheme gradeScheme = readGradeScheme();
        
        if (gradeScheme == null) {
            System.out.println("Unable to read grade scheme file from grades directory. " +
                    "\nSorry, can't calculate estimated grade.");
            System.exit(0);
        }
        
        int week = gradeScheme.getWeek();
        
        Question[] questions = gradeScheme.getQuestions();
        
        double totalPointsEarnedForLab = 0;
        
        for (Question question : questions) {
            
            String codeFileName = question.getJava_file();
            int questionNumber = question.getQuestion();
            String[] testFiles = question.getTest_files();
            double pointsAvailableForQuestion = question.getPoints();
            
            System.out.printf("Question %d, %s. Total points available: %.2f\n",
                    questionNumber, codeFileName, pointsAvailableForQuestion);
            
            double totalPass = 0;
            double totalFail = 0;
            
            for (String testFile : testFiles) {
                TestFileResults results = readTestResults(testFile, week);
                if (results == null) {
                    System.out.println("Warning - could not read results from Test Results file. Skipping.");
                } else {
                    System.out.println(results.summary());
                    totalPass += results.getTotalPassed();
                    totalFail += results.getTotalNotPassed();
                }
            }
            
            double fractionPassed = totalPass / ( totalFail + totalPass );
            double pointsEarnedForQuestion = fractionPassed * pointsAvailableForQuestion;
            System.out.printf("Fraction of tests passed for question %d: %.2f. Points earned %.2f\n", questionNumber, fractionPassed, pointsEarnedForQuestion);
            totalPointsEarnedForLab += pointsEarnedForQuestion;
            
            System.out.println();
        }
        
        
        System.out.printf("Total estimated points for lab, based on tests passing: %.2f\n", totalPointsEarnedForLab);
        
    }
    
    private static TestFileResults readTestResults(String fileBase, int week) {
        
        // find the surefire file /target/surefire-reports/week_5.Question_4_Exception_Handling_QuestionsTest.txt
        
        System.out.println("Test result file: " + fileBase);
        
        String filename = String.format("week_%d.%s.txt", week, fileBase);
        File dirOb = new File("target", "surefire-reports");
        File fileOb = new File(dirOb, filename);
        
        try ( BufferedReader r = new BufferedReader(new FileReader(fileOb)) ) {
            
            String line;
            StringBuilder all = new StringBuilder();
            while ((line = r.readLine()) != null) {
                all.append(line);
            }
            
            // An example line from the test report file looks like this
            // Tests run: 6, Failures: 4, Errors: 0, Skipped: 0, Time elapsed: 0.055 s <<< FAILURE! - in week_6.q1_course.ITECCourseTest
            
            Pattern testRun = Pattern.compile(".*Tests run: (?<run>\\d+), Failures: (?<failures>\\d+), Errors: (?<errors>\\d+), Skipped: (?<skipped>\\d).*");
            
            Matcher m = testRun.matcher(all.toString());
            if (m.matches()) {
                return new TestFileResults(m.group("run"), m.group("failures"), m.group("errors"), m.group("skipped"));
            } else {
                System.out.println("Unable to extract test statistics from test file");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Can't find test results file. Did you run this from the run configuration provided? Is there anything in target/surefire-reports?");
            return null;
        }
        
    }
    
    
    private static GradeScheme readGradeScheme() {
        
        // File is in grades/week_X.json
        
        File gradeDirectory = new File("grades");
        String[] files = gradeDirectory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("json");
            }
        });
        
        if (files != null && files.length < 1) {
            System.out.println("Grade schema file (named week_*.json) not found in grades directory.");
        }
        
        String gradeFilename = files[0];
        
        try {
            
            JsonReader reader = new JsonReader(new FileReader(new File(gradeDirectory, gradeFilename)));
            Gson gson = new Gson();
            return gson.fromJson(reader, GradeScheme.class);
            
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Unable to read grade schema data from grade file.");
            return null;
        }
    }
    
}
