import java.util.Random;

public class StudentSearchTest {
    private static final Random rand = new Random();
    private static final String[] surnames = {"Shay", "Taylor", "Fleming", "Maloney", "White", "Gagnon", "Harrison", "Lee", "Mcdonald", "Whiteman"};
    private static final String[] givenNames = {"Owen", "Michael", "Chris", "Mackenzie", "Joey", "Cohen", "Jacob", "Brayden", "Brenden", "Jackson"};


    public static void main(String[] args) {
        int studentCount = 10;
        Student[] studentArray = generateStudentArray(3100000, 20, studentCount);
        int[] target =new int[6]; // creates a list of targets you want to check for using the binary search
        target[0] = studentArray[0].getStudentId();
        target[1] = studentArray[9].getStudentId();
        target[2] = studentArray[rand.nextInt(studentCount)].getStudentId();
        target[3] = target[0] - 1;
        target[4] = target[1] + 1;
        target[5] = target[2] + 1;
        for(int i = 0; i < studentCount;i++) { //iterates through the student array, printing their array index and the student object at that index
            System.out.println("[" + i + "] " + studentArray[i]);
        }
        System.out.println("St. Id   " + "Result");
        System.out.println("=======  ======");
        for(int i = 0; i < target.length;i++) { // runs a binary search for each of the targets you want to look for
            int result = StudentBinarySearch.studentBinarySearch(studentArray, studentCount, target[i]);
            System.out.println(target[i] + "     " + result);
        }
    }

    /**
     * private static Student[] generateStudentArray(int baseId, int arrSize, int studentCount)
     Generates an array of student objects given the size of the array and how many students you want to include in the array

     * @param baseId - the starting value for your students ID's
     * @param arrSize - The length of the Student array
     * @param studentCount - The amount of Student objects you want in the array
     * @return The array of students
     */
    private static Student[] generateStudentArray(int baseId, int arrSize, int studentCount) {
        Student[] studentArray = new Student[arrSize];
        Student student;
        int studentId = baseId;
        for (int i = 0; i < studentCount; i++) {
            int increment = rand.nextInt(1, 80_000);
            int surnameIndex = rand.nextInt(surnames.length);
            int givenNameIndex = rand.nextInt(givenNames.length);
            double gpa = rand.nextInt(20, 40) / 10.0;
            studentId += increment;
            student = new Student(studentId, surnames[surnameIndex], givenNames[givenNameIndex], gpa);
            studentArray[i] = student;

        }

        return studentArray;
    }
}

