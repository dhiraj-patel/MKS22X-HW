public class Driver{
    public static void main(String[] args){
	RunningMedian m1 = new RunningMedian();
	m1.add(2);
	m1.add(5);
	m1.add(3);
	System.out.println(m1.getMedian());
    }
}
