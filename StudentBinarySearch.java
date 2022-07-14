public class StudentBinarySearch {
    public static final int NOTFOUND = -1;

    public static int studentBinarySearch(Student[] studentArray, int studentCount,int studentId) {
        {
            int foundPosition = NOTFOUND;
            int low = 0;
            int high = studentCount - 1;
            int mid;

            while(foundPosition == NOTFOUND && low <= high)
            {	mid = (low + high) / 2;
                if(studentArray[mid].getStudentId() == studentId)
                    foundPosition = mid;
                else
                if(studentId > studentArray[mid].getStudentId())
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return foundPosition;
        }

    }
}
