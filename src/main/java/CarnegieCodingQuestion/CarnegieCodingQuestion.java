package CarnegieCodingQuestion;

import java.util.*;

public class CarnegieCodingQuestion {
    // Ideally this would be a property in a file, DB or ?
    public static final int THRESHOLD = 95;

    public static void main (String[] args) {

        // Data setup
        CarnegieCodingQuestion solution = new CarnegieCodingQuestion();

        // Students
        Student stu1 = new Student();
        stu1.addSkill(Skills.ADD_DECIMALS, 97);
        stu1.addSkill(Skills.ADD_FRACTIONS, 17);
        stu1.addSkill(Skills.MULTIPLY_FRACTIONS, 53);

        Student stu2 = new Student();
        stu2.addSkill(Skills.ADD_FRACTIONS, 96);
        stu2.addSkill(Skills.MULTIPLY_FRACTIONS, 81);
        stu2.addSkill(Skills.ADD_DECIMALS, 33);
        stu2.addSkill(Skills.MULTIPLY_DECIMALS, 47);


        Student stu3 = new Student();
        stu3.addSkill(Skills.ADD_FRACTIONS, 23);


        // Problems
        Problem prob1 = new Problem("prob1");
        prob1.addSkill(Skills.ADD_DECIMALS);

        Problem prob2 = new Problem("prob2");
        prob2.addSkill(Skills.ADD_DECIMALS);
        prob2.addSkill(Skills.MULTIPLY_DECIMALS);

        Problem prob3 = new Problem("prob3");
        prob3.addSkill(Skills.ADD_FRACTIONS);

        Problem prob4 = new Problem("prob4");
        prob4.addSkill(Skills.ADD_FRACTIONS);
        prob4.addSkill(Skills.MULTIPLY_FRACTIONS);

        Problem prob5= new Problem("prob5");
        prob5.addSkill(Skills.MULTIPLY_DECIMALS);
        prob5.addSkill(Skills.MULTIPLY_FRACTIONS);

        Problem prob6 = new Problem("prob6");
        prob6.addSkill(Skills.ADD_FRACTIONS);
        prob6.addSkill(Skills.ADD_DECIMALS);

        Set<Problem> input = new HashSet<>();
        input.add(prob1);
        input.add(prob2);
        input.add(prob3);
        input.add(prob4);
        input.add(prob5);
        input.add(prob6);

        System.out.println("Student 1 best suited problem is " + solution.getMostAppropriateProblem(stu1,input));
        System.out.println("Student 2 best suited problem is " + solution.getMostAppropriateProblem(stu2,input));
        System.out.println("Student 3 best suited problem is " + solution.getMostAppropriateProblem(stu3,input));
    }


    // 100s
    /**
     * Gets the problem that best suited for the student's skill set
     * @param student A student with a specific set of skill.
     * @param problems A problem set that address specific skills
     * @return The name of the Problem that's best fitting the given student skill set.
     */
    public String getMostAppropriateProblem(Student student, Set<Problem> problems) {
        Map<Problem, Integer> temp = new HashMap<>();
        for (Problem problem : problems) {
            int skillsCount = 0;
            for (Map.Entry<Skills, Integer> entry: student.getSkills().entrySet()) {
                if (entry.getValue() < THRESHOLD) {
                    if (problem.getSkills().contains(entry.getKey())) {
                        skillsCount++;
                    }
                }
            }
            temp.put(problem,skillsCount);
        }
        return temp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey().getName();
    }
}

class Student {
    private Map<Skills, Integer> skills;
    public Student() {
        skills = new HashMap<>();
    }
    public void addSkill(Skills skill, Integer score) {
        skills.put(skill,score);
    }

    public Map<Skills, Integer> getSkills() {
        return this.skills;
    }
}

class Problem {
    private String name;
    private List<Skills> skills;
    public Problem(String name) {
        skills = new ArrayList<>();
        this.name = name;
    }
    public void addSkill(Skills skill) {
        skills.add(skill);
    }
    public String getName() {
        return name;
    }
    public List<Skills> getSkills() {
        return this.skills;
    }
}

// Ideally this would come from a data set (File of DB)

/**
 * ENUM specifying the finite skill set that we're provided with. Ideally this would come from a data set (File of
 * DB) in which case I'd get rid of the enum.
 */
enum Skills {
    ADD_DECIMALS (1),
    ADD_FRACTIONS (2),
    MULTIPLY_DECIMALS (3),
    MULTIPLY_FRACTIONS (4);

    private final int skillCode;
    Skills (int skillCode) {
        this.skillCode = skillCode;
    }
}
